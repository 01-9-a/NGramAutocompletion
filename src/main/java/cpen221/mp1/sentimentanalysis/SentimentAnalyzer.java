package cpen221.mp1.sentimentanalysis;

import cpen221.mp1.datawrapper.DataWrapper;
import cpen221.mp1.ngrams.NGrams;

import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.*;

public class SentimentAnalyzer {

    private String filename;

    private Map<String,Map<String,Long>> bagOfWord = new HashMap<>();

    private float Prating;

    private float Pbag;

    private float Prating_bag;

    private float Pbag_rating;

    private float rating;

    private List<String[]> array = new ArrayList<>();

    private List<String> r = new ArrayList<>();

    /**
     *
     * @param filename
     */
    public SentimentAnalyzer(String filename) throws FileNotFoundException {
        // TODO: Implement this constructor and write the spec
        // You may assume that the file is in the format
        // of the RateMyProfessor data with each line containing
        // a rating, a second column (gender or similar) that you
        // can ignore for this task, and the text of the review.
        // The file whose name is provided here is expected to
        // contain the **training data** with which you build
        // your prediction model.
        this.filename=filename;
        DataWrapper read = new DataWrapper(filename);
        read.nextLine();
        for (String line=read.nextLine(); line!=null; line=read.nextLine()) {
            if (line.split(",").length>=3) {
                array.add(line.split(",",3));
            }
        }
        for (int i=0; i<array.size(); i++) {
            if (!r.contains(array.get(i)[0])) {
                r.add(array.get(i)[0]);
            }
        }
        for (String string:r) {
            List<String> text = new ArrayList<>();
            for (int i=0; i<array.size(); i++) {
                if (Objects.equals(string, array.get(i)[0])) {
                    text.add(array.get(i)[2]);
                }
            }
            String[] text1 = new String[text.size()];
            text1 = text.toArray(text1);
            NGrams n = new NGrams(text1);
            bagOfWord.put(string, n.getAllNGrams().get(0));
        }
    }

    /**
     *
     * @param reviewText
     * @return
     */
    public float getPredictedRating(String reviewText) {
        // TODO: Implement this method for predicting
        // the rating given the text of a review using
        // the simple Bayesian approach outlined in the
        // MP statement. Also write the specification for
        // the method.
        String[] review = getWords(reviewText);
        Prating_bag=0;
        float Ptemp = 0;
        int occurrences_r = 0;
        int number = array.size();
        long totalNumOfWord=0;
        int occurrences_w = 0;
        int occurrences_w_r = 0;

        for (Map map:bagOfWord.values()) {
            for (Object l:map.values()) {
                totalNumOfWord += (long)l;
            }
        }

        for (String string:r) {
            for (int i=0; i<array.size(); i++) {
                if (Objects.equals(string, array.get(i)[0])) {
                    occurrences_r++;
                }
            }
            Prating = (float) occurrences_r/number;

            float Pword = 0;
            for (int i=0; i<review.length; i++) {
                for (Map map : bagOfWord.values()) {
                    if (map.containsKey(review[i])) {
                        occurrences_w += (int)map.get(review[i]);
                    }
                }
                Pword = (float) occurrences_w/totalNumOfWord;
                Pbag *= Pword;
            }

            float Pbr = 0;
            int totalNumOfWordRating = 0;
            for (long l:bagOfWord.get(string).values()) {
                totalNumOfWordRating += (int)l;
            }
            for (int i=0; i<review.length; i++) {
                occurrences_w_r += bagOfWord.get(string).get(review[i]);
                Pbr = (float) occurrences_w_r/totalNumOfWordRating;
                Pbag_rating *= Pbr;
            }

            Ptemp = Pbag_rating*Prating/Pbag;

            if (Ptemp>Prating_bag) {
                rating = Float.parseFloat(string);
                Prating_bag=Ptemp;
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
            if (!word.equals(" ")) {
                words.add(word);
            }
        }
        String[] wordsArray = new String[words.size()];
        words.toArray(wordsArray);
        return wordsArray;
    }

}