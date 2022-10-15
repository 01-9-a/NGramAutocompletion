package cpen221.mp1.sentimentanalysis;

import cpen221.mp1.datawrapper.DataWrapper;

import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.*;

public class SentimentAnalyzer {
    private final Map<Float,Map<String,Long>> bagOfWord = new HashMap<>();

    private float rating = 0.0f;

    private final List<String[]> array = new ArrayList<>();

    private final List<Float> r = new ArrayList<>();

    /**
     * Constructor of the sentiment analyzer.
     * @param filename the name of the file.
     *                 It can not be null and the file is not empty
     * @throws FileNotFoundException when the file does not exist
     * or is at the wrong place.
     */
    public SentimentAnalyzer(String filename) throws FileNotFoundException {

        DataWrapper read = new DataWrapper(filename);
        read.nextLine();
        for (String line=read.nextLine(); line!=null; line=read.nextLine()) {
            if (line.split(",").length>=3) {
                array.add(line.split(",",3));
            }
        }
        for (String[] strings : array) {
            if (!r.contains(Float.parseFloat(strings[0]))) {
                r.add(Float.parseFloat(strings[0]));
            }
        }
        for (Float f:r) {
            List<String> text = new ArrayList<>();
            for (String[] strings : array) {
                if (Objects.equals(f, Float.parseFloat(strings[0]))) {
                    text.add(strings[2]);
                }
            }
            String text1 = text.toString();
            bagOfWord.put(f, getOneGram(text1));
        }
    }

    public Map<String,Long> getOneGram(String text) {
        Map<String,Long> oneGram = new HashMap<>();
        String[] t = getWords(text);
        for (String s : t) {
            if (!oneGram.containsKey(s)) {
                oneGram.put(s, 1L);
            } else {
                long count = oneGram.get(s);
                count++;
                oneGram.put(s, count);
            }
        }
        return oneGram;
    }

    /**
     * To find the rating that best matches the comment.
     * @param reviewText the text would like to be checked in the comments.
     *                   It can not be empty. It must be the words appearing in comments.
     * @return rating. If there are two or more ratings meeting the requirements, return the
     * highest rating.
     */
    public float getPredictedRating(String reviewText) {

        String[] review = getWords(reviewText);
        float prating_bag = 0;
        int number = array.size();
        long totalNumOfWord=0;

        for (Map map:bagOfWord.values()) {
            for (Object l : map.values()) {
                totalNumOfWord += (long) l;
            }
        }

        for (Float f:r) {
            float pbag =1;
            float pbag_rating =1;
            int occurrences_r = 0;
            long occurrences_w = 0;
            long occurrences_w_r = 0;
            for (String[] strings : array) {
                if (Objects.equals(f, Float.parseFloat(strings[0]))) {
                    occurrences_r++;
                }
            }
            float prating = (float) occurrences_r / number;

            float Pword = 0;
            for (String s : review) {
                for (Map map : bagOfWord.values()) {
                    if (map.containsKey(s)) {
                        occurrences_w += (long) map.get(s);
                    }
                }
                Pword = (float) occurrences_w / totalNumOfWord;
                pbag *= Pword;
            }

            float Pbr=0;
            int totalNumOfWordRating = 0;
            for (long l:bagOfWord.get(f).values()) {
                totalNumOfWordRating += (int)l;
            }
            for (String s : review) {
                if (bagOfWord.get(f).get(s)==null) {
                    Pbr = (float) (occurrences_w_r+1) / (totalNumOfWordRating+1);
                }
                else {
                    occurrences_w_r = bagOfWord.get(f).get(s);
                    Pbr = (float) (occurrences_w_r + 1) / (totalNumOfWordRating + 1);
                }
                pbag_rating *= Pbr;
            }

            float tempp = pbag_rating * prating / pbag;

            if (tempp > prating_bag) {
                prating_bag =tempp;
                rating=f;
            }
            else if (tempp == prating_bag) {
                prating_bag =tempp;
                if (rating<f) {
                    rating=f;
                }
            }
        }
        return rating;
    }

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
            if (!word.equals(" ")&&!word.equals("")) {
                words.add(word);
            }
        }
        String[] wordsArray = new String[words.size()];
        words.toArray(wordsArray);
        return wordsArray;
    }

}