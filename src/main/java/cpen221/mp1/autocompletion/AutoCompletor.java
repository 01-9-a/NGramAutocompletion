package cpen221.mp1.autocompletion;

import cpen221.mp1.searchterm.SearchTerm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutoCompletor {

    private static final int DEFAULT_SEARCH_LIMIT = 10;
    SearchTerm[] searchTerms;
    List<Map<String, Long>> searchTermsMaps;


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
        this.searchTermsMaps = searchTerms;
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
