package cpen221.mp1.ngrams;

import java.text.BreakIterator;
import java.util.*;


public class NGrams {

    private List<Map<String, Long>> wordss;

    String[] wordsarray;

    private String[] getWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        BreakIterator wb = BreakIterator.getWordInstance();
        wb.setText(text);
        int start = wb.first();
        for (int end = wb.next();
             end != BreakIterator.DONE;
             start = end, end = wb.next()) {
            String word = text.substring(start, end).toLowerCase();
            word = word.replaceAll("^\\s*\\p{Punct}+\\s*", "").replaceAll("\\s*\\p{Punct}+\\s*$", "");
            if (!word.equals(" ")) {
                words.add(word);
            }
        }
        String[] wordsArray = new String[words.size()];
        words.toArray(wordsArray);
        return wordsArray;
    }

    /**
     * Create an NGrams object
     *
     * @param text all the text to analyze and create n-grams from;
     *             is not null and is not empty.
     */
    public NGrams(String[] text) {
        wordsarray=new String[text.length];
        for (int i=0;i<text.length;i++){
            wordsarray[i]=text[i];
        }
    }

    /**
     * Obtain the total number of unique 1-grams,
     * 2-grams, ..., n-grams.
     *
     * Specifically, if there are m_i i-grams,
     * obtain sum_{i=1}^{n} m_i.
     *
     * @return the total number of 1-grams,
     * 2-grams, ..., n-grams
     */
    public long getTotalNGramCount(int n) {
        long totalcount=0;
        for(int x=0;x<wordsarray.length;x++){
            String[] words=getWords(wordsarray[x]);
            for(int i=1;i<=n;i++){
                Set<String> seti=new HashSet<>();
                for(int j=0;j<words.length-i;j++){
                    String iwords="";
                    for(int k=j;k<i+j;k++) {
                        iwords += words[k];
                    }
                    seti.add(iwords);
                }
                totalcount += seti.size();
            }
        }
        return totalcount; // TODO: Implement this method
    }

    /**
     * Get the n-grams, as a List, with the i-th entry being
     * all the (i+1)-grams and their counts.
     * @return a list of n-grams and their associated counts,
     * with the i-th entry being all the (i+1)-grams and their counts
     */
    public List<Map<String, Long>> getAllNGrams() {
        long count=0;
        int max=0;
        for(int x=0;x<wordsarray.length;x++) {
            String[] words = getWords(wordsarray[x]);
            if(words.length>=max){
                max= words.length;
            }
        }
        List<Map<String, Long>> maplist = new ArrayList<>(max);
        for(int x=0;x<wordsarray.length;x++) {
            String[] words = getWords(wordsarray[x]);
            for (int i = 1; i <= words.length; i++) {
                Map<String, Long> map = new HashMap<>();
                List<String> igram = new ArrayList<>();
                for (int j = 0; j <= words.length - i; j++) {
                    String iwords = "";
                    for (int k = j; k < i + j; k++) {
                        iwords += words[k];
                    }
                    String iwordsString = String.join(" ", iwords);
                    igram.add(iwordsString);//creates a list that contains all i-grams
                }
                for (String s : igram) {
                    for (int l = 0; l < igram.size(); l++) {
                        count = 0;
                        if (s.equals(igram.get(i))) {
                            count++;
                        }
                    }
                    map.put(s, count);
                }
                maplist.add(map);
            }
        }
        return maplist; // TODO: Implement this method
    }
}
