package cpen221.mp1.ratemyprofessor;

import cpen221.mp1.datawrapper.DataWrapper;
import cpen221.mp1.histogram.Histogram;

import java.io.FileNotFoundException;
import java.util.*;

public class DataAnalyzer{
    ArrayList<String>reviews=new ArrayList();
    Map<String ,Long>map= new LinkedHashMap<>();

    /**
     * Create an object to analyze a RateMyProfessor dataset
     * @param dataSourceFileName the name of the file that contains the data
     * @throws FileNotFoundException if the file does not exist or is not found
     */
    public DataAnalyzer(String dataSourceFileName) throws FileNotFoundException {
        DataWrapper dw = new DataWrapper(dataSourceFileName);
        while(dw.dataReader.hasNext()){
            this.reviews.add(dw.nextLine());
        }
        // TODO: Implement the rest of this method as appropriate
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
                long count=0L;
                for(int i=0;i+query.length()<s.length();i++) {
                    String str=s.substring(i,i+query.length());
                    if(str.equals(query)){
                        int spaceplace=i-1;
                        if (s.charAt(spaceplace) == ',' || s.charAt(spaceplace) == ' ') {
                            count++;
                        }
                    }
                }

                String cate = category(s);
                if (map.get(cate) == null) {
                    map.put(cate, count);
                } else {
                    map.put(cate, map.get(cate) + count);
                }
            }
        }
        this.map=map;
            return map; // TODO: Implement this method
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
        Histogram his=new Histogram("Histogram of counts of keywords in reviews","keywords","count");
        List<String> xData  = Arrays.asList("L", "M", "H");
        int ml,mm,mh=0;
        if(histogram.get("ML")!=null){
            ml=histogram.get("ML").intValue();
        }else{
            ml=0;
        }
        if(histogram.get("MM")!=null){
            mm=histogram.get("MM").intValue();
        }else{
            mm=0;
        }
        if(histogram.get("MH")!=null){
            mh=histogram.get("MH").intValue();
        }else{
            mh=0;
        }
        List<Integer> yData  = Arrays.asList(ml,mm,mh);
        his.addSeries("M", xData, yData);

        int wl,wm,wh=0;
        if(histogram.get("WL")!=null){
            wl=histogram.get("WL").intValue();
        }else{
            wl=0;
        }
        if(histogram.get("WM")!=null){
            wm=histogram.get("WM").intValue();
        }else{
            wm=0;
        }
        if(histogram.get("WH")!=null){
            wh=histogram.get("WH").intValue();
        }else{
            wh=0;
        }
        yData  = Arrays.asList(wl,wm,wh);
        his.addSeries("W", xData, yData);
        his.showChart();

    }
    public static void main(String[] args) throws FileNotFoundException {
        DataAnalyzer testhis=new DataAnalyzer("data/reviews2.txt");
        Map<String,Long> m=testhis.getHistogram("he is");
        testhis.showHistogramChart(m);
    }

    public String category(String s){
        String cate="";
        if(s.contains("M")){
            cate=cate+"M";
        }else if(s.contains("W")){
            cate=cate+"W";
        }
        double rate=0;
        String ratestring=s.substring(0,3);
        rate=Double.parseDouble(ratestring);
        if(rate>=0&&rate<=2){
            cate+="L";
        }else if(rate>2&&rate<=3.5){
            cate+="M";
        }else if(rate>3.5&&rate<=5){
            cate+="H";
        }
        return cate;
    }
}

