package cpen221.mp1.autocompletion;

import cpen221.mp1.searchterm.SearchTerm;

import java.util.*;

public class AutoCompletor {

    private static final int DEFAULT_SEARCH_LIMIT = 10;
    SearchTerm[] searchTerms;


    /**
     * Initializes an auto completer with the given search terms.
     *
     * @param searchTerms an array of search terms, is not null and not empty
     */
    public AutoCompletor(SearchTerm[] searchTerms) {
        this.searchTerms = searchTerms;
    }


    /**
     * Initializes an auto completer with the given search terms.
     *
     * @param searchTerms a list of search terms, is not null and not empty
     */
    public AutoCompletor(List<Map<String, Long>> searchTerms) {
        List<SearchTerm> list = new ArrayList<>();
        for (Map<String, Long> searchTerm : searchTerms) {
            for (Map.Entry<String, Long> pair : searchTerm.entrySet()) {
                String key = pair.getKey();
                Long value = pair.getValue();
                SearchTerm s = new SearchTerm(key, value);
                list.add(s);
            }
        }
        SearchTerm[] arr = new SearchTerm[list.size()];
        for(int i=0; i< arr.length; i++){
            arr[i] = list.get(i);
        }
        this.searchTerms = arr;
    }

    /**
     * Returns all the SearchTerms that match the given prefix.
     *
     * @param prefix a string that is the prefix of some SearchTerms
     * @return an array of SearchTerms that match the given prefix
     */
    public SearchTerm[] allMatches(String prefix) {
        ArrayList<SearchTerm> arrList = new ArrayList<>();
        for(SearchTerm s: searchTerms){
            int tabIndex = s.toString().indexOf("\t");
            if(s.toString().startsWith(prefix,tabIndex+1)){
                arrList.add(s);
            }
        }
        SearchTerm[] arr = new SearchTerm[arrList.size()];
        for(int i=0; i< arrList.size(); i++){
            arr[i] = arrList.get(i);
        }
        if(arrList.size()>1) {
            Arrays.sort(arr, SearchTerm.byReverseWeightOrder());
            Collections.reverse(Arrays.asList(arr));
            long[] numArr = new long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                numArr[i] = arr[i].weightToLong();
            }
            Set<Long> repeatedN = new HashSet<>();
            for (int i = 0; i < numArr.length; i++) {
                for (int j = i + 1; j < numArr.length - 1; j++) {
                    if (numArr[i] == numArr[j]) {
                        repeatedN.add(numArr[i]);
                    }
                }
            }
            if(repeatedN.size()>0){
                for(long l: repeatedN){
                    int startIndex = -1;
                    int endIndex = -1;
                    for(int i=0; i<numArr.length; i++){
                        if(numArr[i]==l && startIndex==-1){
                            startIndex = i;
                        }
                    }
                    for(int i=numArr.length-1; i>=0; i--){
                        if(numArr[i]==l && endIndex==-1){
                            endIndex = i;
                        }
                    }

                    SearchTerm[] subArray = Arrays.copyOfRange(arr, startIndex, endIndex+1);
                    Arrays.sort(subArray, SearchTerm.byPrefixOrder());
                    System.arraycopy(subArray, 0, arr, startIndex, subArray.length);
                }
            }
        }
        return arr;
    }

    /**
     * Returns the top-K (K indicated by limit) SearchTerms that match the given prefix.
     *
     * @param prefix a string that is the prefix of some SearchTerms
     * @param limit an int that is the maximum number of SearchTerms returned
     * @return an array of top-K SearchTerms that match the given prefix
     */
    public SearchTerm[] topKMatches(String prefix, int limit) {
        SearchTerm[] arrAll = allMatches(prefix);
        if(limit> arrAll.length){
            return arrAll;
        }
        SearchTerm[] arr = new SearchTerm[limit];
        System.arraycopy(arrAll, 0, arr, 0, limit);
        return arr;
    }

    /**
     * Returns the top-K (K indicated by a default set number) SearchTerms that match the given prefix.
     *
     * @param prefix a string that is the prefix of some SearchTerms
     * @return an array of top-K SearchTerms that match the given prefix
     */
    public SearchTerm[] topKMatches(String prefix) {
        return topKMatches(prefix, DEFAULT_SEARCH_LIMIT);
    }

    /**
     * Returns the number of matched SearchTerms starts with the given prefix.
     *
     * @param prefix a string that is the prefix of some SearchTerms
     * @return the number of matched SearchTerms starts with the given prefix
     */
    public int numberOfMatches(String prefix) {
        return allMatches(prefix).length;
    }

}
