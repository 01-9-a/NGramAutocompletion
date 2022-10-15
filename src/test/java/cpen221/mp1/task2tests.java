package cpen221.mp1;

import cpen221.mp1.ratemyprofessor.DataAnalyzer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class task2tests {

    private static DataAnalyzer da1;
    private static DataAnalyzer da2;
    private static DataAnalyzer da3;

    @BeforeAll
    public static void setUpTests() throws FileNotFoundException {
        da1 = new DataAnalyzer("data/reviews1.txt");
        da2 = new DataAnalyzer("data/reviews2.txt");
    }


    @Test
    public void testGood() {
        String query = "she";
        Map<String, Long> expected = Map.of(
                "ML", 0L,
                "WL", 1L,
                "MM", 0L,
                "WM", 0L,
                "MH", 0L,
                "WH", 1L
        );
        da2.showHistogramChart(da2.getHistogram(query));
        assertEquals(expected, da1.getHistogram(query));
    }

    @Test
    public void testGetA() {
        String query = "get a";
        Map<String, Long> expected = Map.of(
                "ML", 0L,
                "WL", 0L,
                "MM", 0L,
                "WM", 0L,
                "MH", 1L,
                "WH", 0L
        );
        da2.showHistogramChart(da2.getHistogram(query));
        assertEquals(expected, da2.getHistogram(query));
    }
    @Test
    public void testHis() {
        String query = "his";

        Map<String, Long> expected = Map.of(
                "ML", 1L,
                "WL", 0L,
                "MM", 0L,
                "WM", 0L,
                "MH", 1L,
                "WH", 0L
        );
        da2.showHistogramChart(da2.getHistogram(query));
        assertEquals(expected, da2.getHistogram(query));
    }
    @Test
    public void testHeIs() throws FileNotFoundException {
        String query = "he is";
        Map<String, Long> expected = Map.of(
                "ML", 1L,
                "WL", 0L,
                "MM", 3L,
                "WM", 0L,
                "MH", 3L,
                "WH", 0L
        );
        da2.showHistogramChart(da2.getHistogram(query));
        assertEquals(expected, da2.getHistogram(query));

    }

    @Test
    public void testProfessorWasBad() {
        String query = "12345";
        Map<String, Long> expected = Map.of(
                "ML", 0L,
                "WL", 0L,
                "MM", 0L,
                "WM", 0L,
                "MH", 0L,
                "WH", 0L
        );
        da2.showHistogramChart(da2.getHistogram(query));
        assertEquals(expected, da2.getHistogram(query));
    }
}