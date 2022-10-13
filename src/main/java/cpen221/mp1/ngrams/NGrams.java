package cpen221.mp1.ngrams;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.*;

public class NGrams {
    ArrayList<String> NGrams;
    Set<String> unrepeated;
    ArrayList<Set<String>> ngSetsArray = new ArrayList<>();
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
            if (!word.equals(" ") && !word.isEmpty()) {
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
        String[] wordsArray;
        ArrayList<String> ng = new ArrayList<>();
        int maxLength = 0;
        for(String s: text){
            wordsArray = getWords(s);
            if(wordsArray.length>maxLength) {
                maxLength = wordsArray.length;
            }
        }
        for(int i=0; i<maxLength; i++){
            Set<String> ngSet = new LinkedHashSet<>();
            ngSetsArray.add(ngSet);
        }

        for (String s: text) {
            wordsArray = getWords(s);
            for (int i = 0; i < wordsArray.length; i++) {
                for (int j = i, n = 0; j < wordsArray.length; j++, n++) {
                    ng.add(String.join(" ", Arrays.copyOfRange(wordsArray, i, j + 1)));
                    ngSetsArray.get(n).add(String.join(" ", Arrays.copyOfRange(wordsArray, i, j + 1)));

                }
            }
        }
        Set<String> noRepeat = new HashSet<>(ng);
        this.NGrams = ng;
        this.unrepeated = noRepeat;
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
        int count = 0;

        for(String s: unrepeated) {
            int spaceN = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    spaceN++;
                }
            }
            if (spaceN < n) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get the n-grams, as a List, with the i-th entry being
     * all the (i+1)-grams and their counts.
     * @return a list of n-grams and their associated counts,
     * with the i-th entry being all the (i+1)-grams and their counts
     */

    public List<Map<String, Long>> getAllNGrams() {
        ArrayList<Map<String, Long>> allNGrams = new ArrayList<>();
        for(Set<String> set: ngSetsArray) {
            Map<String, Long> NGramsMap = new LinkedHashMap<>();
            for (String str: set) {
                NGramsMap.put(str, (long) Collections.frequency(NGrams, str));
            }
            allNGrams.add(NGramsMap);
        }
        return allNGrams;
    }
}
