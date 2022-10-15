package cpen221.mp1.sentimentanalysis;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

public class Task4test {
    @Test
    public void testRating1() {
        try {
            SentimentAnalyzer rmp_sa = new SentimentAnalyzer("data/review1.txt");
            assertEquals(5f, rmp_sa.getPredictedRating("good teacher"));
        }
        catch (FileNotFoundException fnf) {
            fail("Data file is not in the right place!");
        }
    }

    @Test
    public void testRating2() {
        try {
            SentimentAnalyzer rmp_sa = new SentimentAnalyzer("data/review2.txt");
            assertEquals(5f, rmp_sa.getPredictedRating("good"));
        }
        catch (FileNotFoundException fnf) {
            fail("Data file is not in the right place!");
        }
    }
}