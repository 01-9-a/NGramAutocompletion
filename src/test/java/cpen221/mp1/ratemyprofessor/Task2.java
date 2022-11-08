package cpen221.mp1.ratemyprofessor;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Task2 {

    @Test
    public void testFileFound() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/ratemyprofessor_data.txt");
            assertNotNull(rmpDA);
        } catch (Exception e) {
            fail("File not found");
        }
    }

    @Test
    public void testFileNotFound() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/blahblah_ijk.txt");
            assertNotNull(rmpDA);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testVerySmall() {
        try {
            DataAnalyzer data = new DataAnalyzer("data/rmp_small.txt");

            Map<String, Long> actual = data.getHistogram("funny");
            Map<String, Long> expected = Map.of("ML", 0L, "WL", 0L, "MM", 0L, "WM", 0L, "MH", 0L, "WH", 1L);
            assertEquals(expected, actual);

            actual = data.getHistogram("nice");
            expected = Map.of("ML", 0L, "WL", 0L, "MM", 0L, "WM", 1L, "MH", 0L, "WH", 0L);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("File not found");
        }
    }

    @Test
    public void testMedium1() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/rmp_medium.txt");
            Map<String, Long> actual = rmpDA.getHistogram("best professor");
            Map<String, Long> expected = Map.of("ML", 0L, "MM", 0L, "MH", 28L, "WL", 0L, "WM", 1L, "WH", 17L);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("File not found");
        }
    }

    @Test
    public void testMedium2() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/rmp_medium.txt");
            Map<String, Long> actual = rmpDA.getHistogram("best professors");
            Map<String, Long> expected = Map.of("ML", 0L, "MM", 0L, "MH", 11L, "WL", 0L, "WM", 0L, "WH", 10L);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("File not found");
        }
    }

    @Test
    public void testMedium3() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/rmp_medium.txt");
            Map<String, Long> actual = rmpDA.getHistogram("favorite");
            Map<String, Long> expected = Map.of("ML", 2L, "MM", 6L, "MH", 24L, "WL", 2L, "WM", 2L, "WH", 21L);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("File not found");
        }
    }

    @Test
    public void testMedium4() {
        try {
            DataAnalyzer rmpDA = new DataAnalyzer("data/rmp_medium.txt");
            Map<String, Long> actual = rmpDA.getHistogram("the worst teacher");
            Map<String, Long> expected = Map.of("ML", 7L, "MM", 0L, "MH", 0L, "WL", 4L, "WM", 0L, "WH", 0L);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("File not found");
        }
    }
}
