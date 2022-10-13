package cpen221.mp1.ratemyprofessor;

import cpen221.mp1.datawrapper.DataWrapper;

import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.*;

public class DataAnalyzer {
    private final String[] rating = {"ML","WL","MM","WM","MH","WH"};
    private final int[] counter = {0,0,0,0,0,0};
    List<List<String>> dataContent;

    /**
     * Create an object to analyze a RateMyProfessor dataset
     * @param dataSourceFileName the name of the file that contains the data
     * @throws FileNotFoundException if the file does not exist or is not found
     */
    public DataAnalyzer(String dataSourceFileName) throws FileNotFoundException {
        DataWrapper dw = new DataWrapper(dataSourceFileName);
        dataContent = new ArrayList<>();
        dw.resetScanner();
        dw.nextLine();
        String nextLine = dw.nextLine();
        while(nextLine!=null){
            String thisLine = nextLine;
            List<String> separated = Arrays.asList(thisLine.split(","));
            dataContent.add(separated);
            nextLine = dw.nextLine();
        }
    }

    /**
     * Obtain a histogram with the number of occurrences of the
     * query term in the RMP comments, categorized as men-low (ML),
     * women-low (WL), men-medium (MM), women-medium (WM),
     * men-high (MH), and women-high (WH).
     * @param query the search term, which contains between one and three words
     * @return the histogram with the number of occurrences of the
     * query term in the RMP comments, categorized as men-low (ML),
     * women-low (WL), men-medium (MM), women-medium (WM),
     * men-high (MH), and women-high (WH)
     */
    public Map<String, Long> getHistogram(String query) {
        Map<String, Long> histogram = new HashMap<>();
        for(List<String> l: dataContent){
            String str = " " + l.get(2) + " ";
            int lastIndex = 0;
            int count = 0;
            String findStr = " "+query+" ";
            while (lastIndex != -1) {

                lastIndex = str.indexOf(findStr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findStr.length();
                }
            }
            if(count!=0){
                float rating = Float.parseFloat(l.get(0));
                if(l.get(1).equals("M")) {
                    if (rating >= 0 && rating <= 2) {
                        counter[0]+=count;
                    }
                    else if(rating > 2 && rating <= 3.5){
                        counter[2]+=count;
                    }
                    else if(rating > 3.5 && rating <= 5){
                        counter[4]+=count;
                    }
                }
                else {
                    if (rating >= 0 && rating <= 2) {
                        counter[1]+=count;
                    }
                    else if(rating > 2 && rating <= 3.5){
                        counter[3]+=count;
                    }
                    else if(rating > 3.5 && rating <= 5){
                        counter[5]+=count;
                    }
                }
            }
        }
        for(int i=0; i<counter.length; i++){
            histogram.put(rating[i], (long) counter[i]);
        }
        return histogram; // TODO: Implement this method
    }

    /**
     * Display the histogram data as a chart
     * @param histogram with entries for men-low (ML),
     * women-low (WL), men-medium (MM), women-medium (WM),
     * men-high (MH), and women-high (WH)
     */
    public void showHistogramChart(Map<String, Long> histogram) {
        // TODO: This is an optional component but is
        //  instructive in that graphing may not be that hard!
        //  See the histogram package.
    }

}
