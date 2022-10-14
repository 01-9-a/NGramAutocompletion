package cpen221.mp1.ngrams;

import java.text.BreakIterator;
import java.util.*;
import java.util.Map;


public class NGrams {

    /**
     * Create an NGrams object
     *
     * @param text all the text to analyze and create n-grams from;
     *             is not null and is not empty.
     */
    String[] wordsarray;
    public NGrams(String[] text) {
        wordsarray=new String[text.length];
        for (int i=0;i< text.length;i++){
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
        Set<String> seti=new HashSet<>();
        for(int x=0;x<wordsarray.length;x++){
            String[] words=getWords(wordsarray[x]);
            for(int i=1;i<=n;i++){

                for(int j=0;j<=words.length-i;j++){
                    String iwords="";
                    for(int k=j;k<i+j;k++) {
                        iwords =iwords+" "+words[k];
                    }
                    seti.add(iwords);
                }
            }
        }
        totalcount=seti.size();
        return totalcount;
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
        for(int x=0;x<wordsarray.length;x++){
            String[] words = (getWords(wordsarray[x]));
            if(words.length>=max){
                max= words.length;
            }
        }
        List<Map<String, Long>> maplist = new ArrayList<Map<String, Long>>();

            for (int i = 1; i <= max; i++) {
                Map<String, Long> map = new LinkedHashMap<>();
                List<String> igram = new ArrayList<>();
                for(int x=0;x<wordsarray.length;x++) {
                    String[] words = (getWords(wordsarray[x]));
                    for (int j = 0; j <= words.length - i; j++) {
                        String iwords ="";
                        for (int k = j; k < i + j; k++) {
                            if(k!=i+j-1){
                                if(k<words.length) {
                                    iwords = iwords+words[k]+" ";
                                }
                            }else{
                                iwords+=words[k];
                            }
                        }
                        igram.add(iwords);//creates a list that contains all i-grams
                    }
                }
                for (int b = 0; b < igram.size(); b++) {
                    count = 1;
                    for (int l = b + 1; l < igram.size(); l++) {
                        String str1= igram.get(b);
                        String str2=igram.get(l);
                        if (str1.equals(str2)) {
                            count += 1;
                            igram.remove(l);

                        }
                    }
                    map.put(igram.get(b),count);
                }
                maplist.add(map);
            }
        return maplist;
    }

    //using a BreakIterator to obtain an array of words.

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
        ArrayList<String> nospace=new ArrayList<>();
        for(String s:wordsArray){
            if(!s.equals("")){
                nospace.add(s);
            }
        }
        String[] wordsarray=new String[nospace.size()];
        wordsarray=nospace.toArray(wordsarray);
        return wordsarray;
    }
}
