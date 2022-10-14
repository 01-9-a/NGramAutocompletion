package cpen221.mp1.ratemyprofessor;

import cpen221.mp1.datawrapper.DataWrapper;
import cpen221.mp1.histogram.Histogram;

import java.io.FileNotFoundException;
import java.util.*;

public class DataAnalyzer {
    ArrayList<String> reviews = new ArrayList();
    Map<String, Long> map = new LinkedHashMap<>();

    /**
     * Create an object to analyze a RateMyProfessor dataset
     *
     * @param dataSourceFileName the name of the file that contains the data
     * @throws FileNotFoundException if the file does not exist or is not found
     */
    public DataAnalyzer(String dataSourceFileName) throws FileNotFoundException {
        DataWrapper dw = new DataWrapper(dataSourceFileName);
        while (dw.dataReader.hasNext()) {
            this.reviews.add(dw.nextLine());
        }
        // TODO: Implement the rest of this method as appropriate
    }

    /**
     * Obtain a histogram with the number of occurrences of the
     * query term in the RMP comments, categorized as men-low (ML),
     * women-low (WL), men-medium (MM), women-medium (WM),
     * men-high (MH), and women-high (WH).
     *
     * @param query the search term, which contains between one and three words
     * @return the histogram with the number of occurrences of the
     * query term in the RMP comments, categorized as men-low (ML),
     * women-low (WL), men-medium (MM), women-medium (WM),
     * men-high (MH), and women-high (WH)
     */
    public Map<String, Long> getHistogram(String query) {
        Map<String, Long> map = new LinkedHashMap<>(Map.of(
                "ML", 0L,
                "WL", 0L,
                "MM", 0L,
                "WM", 0L,
                "MH", 0L,
                "WH", 0L
        ));
        for (String s : reviews) {
            if (s.contains(query)) {
                long count = 0L;
                for (int i = 0; i + query.length() < s.length(); i++) {
                    String str = s.substring(i, i + query.length());
                    if (str.equals(query)) {
                        int before = i - 1;
                        int after = i + query.length();
                        if ((s.charAt(before) == ',' || s.charAt(before) == ' ')){
                            if (s.charAt(after) == ' '){

                                count++;
                            }

                        }
                    }
                }
                String cate = category(s);
                map.put(cate, map.get(cate) + count);

            }
        }
        this.map = map;
        return map; // TODO: Implement this method
    }


    /**
     * categorize each string based on the information it given
     *
     * @param s given string that contains the rates which helps to categorize rating level
     *          and "M" or "L" help to categorize
     * @return string represents what it is categorized.
     */
    public String category(String s) {
        String cate = "";
        if (s.contains("M")) {
            cate = cate + "M";
        } else  {
            cate = cate + "W";
        }
        double rate = 0;
        String ratestring = s.substring(0, 3);
        rate = Double.parseDouble(ratestring);
        if (rate <= 2) {
            cate += "L";
        } else if (rate <= 3.5) {
            cate += "M";
        } else {
            cate += "H";
        }
        return cate;
    }


}

