package cpen221.mp1.autocompletion;

import cpen221.mp1.searchterm.SearchTerm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutoCompletor {

    private static final int DEFAULT_SEARCH_LIMIT = 10;
    List<Map<String,Long>> searchterms=new ArrayList<>();
    SearchTerm[] searchTerms;
    /**
     * Initializes a term with the given searchTerms.
     *
     * @param searchTerms a list of search terms, is not null and not empty.
     *
     */
    public AutoCompletor(SearchTerm[] searchTerms) {
        this.searchTerms=searchTerms;
    }

    /**
     * Initializes a term with the given searchTerms list.
     *
     * @param searchTerms a list of search terms, is not null and not empty.
     *                    searchTerms contains n-grams
     */
    public AutoCompletor(List<Map<String, Long>> searchTerms) {
        this.searchterms=searchTerms;
    }

    /**
     * return all the SearchTerms that match the given prefix.
     *
     * @param prefix a string represents the prefix of some searchTerms
     * @return an array of SearchTerms that match the given prefix.
     */
    public SearchTerm[] allMatches(String prefix) {
        ArrayList<SearchTerm> MatchSearchTerms= new ArrayList<>();
        for(SearchTerm s: searchTerms){
            int tabposition=s.toString().indexOf("\t");
            if(s.toString().startsWith(prefix, tabposition+1)){
                MatchSearchTerms.add(s);
            }
        }
        SearchTerm[] MatchSearchTerm=new SearchTerm[MatchSearchTerms.size()];
        for(int i=0;i<MatchSearchTerm.length;i++){
            MatchSearchTerm[i]=MatchSearchTerms.get(i);
        }


        return MatchSearchTerm;
    }

    /**
     * Returns the top-K (K indicated by limit) SearchTerms that match the given prefix.
     *
     * @param prefix a string that is the prefix of some SearchTerms
     * @param limit an int that is the maximum number of SearchTerms returned
     * @return an array of top-K SearchTerms that match the given prefix
     */
    public SearchTerm[] topKMatches(String prefix, int limit) {
        SearchTerm[] topkst = new SearchTerm[limit];
        SearchTerm[] allst = allMatches(prefix);
        if (allst.length < limit) {
            return allst;
        } else {
            for (int i = 0; i < limit; i++) {
                topkst[i] = allst[i];
            }
        }
        return topkst;
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
        SearchTerm[] st=allMatches(prefix);
        int num=st.length;
        return num;
    }

}
