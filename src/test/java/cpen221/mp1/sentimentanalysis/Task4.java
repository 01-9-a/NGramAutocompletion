package cpen221.mp1.sentimentanalysis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task4 {
    private static SentimentAnalyzer rmpSA;

    @BeforeAll
    public static void setup() throws Exception {
        rmpSA = new SentimentAnalyzer("data/ratemyprofessor_data.txt");
    }

    @Test
    public void test_Great() throws Exception {
        float actual = rmpSA.getPredictedRating("great");
        assertEquals(5f, actual);
    }

    @Test
    public void test_Caring() throws Exception {
        float actual = rmpSA.getPredictedRating("caring");
        assertEquals(5f, actual);
    }

    @Test
    public void test_Hard_Work_Easy() throws Exception {
        float actual = rmpSA.getPredictedRating("hard work but easy");
        assertEquals(4f, actual);
    }

    @Test
    public void testRepeatedWords() throws Exception {
        float actual = rmpSA.getPredictedRating("very very bad");
        assertEquals(5f, actual);
    }

    @Test
    public void testLowRating() throws Exception {
        float actual = rmpSA.getPredictedRating("bad terrible awful");

        assertEquals(1f, actual);
    }

    @Test
    public void testMixedRating() throws Exception {
        float actual = rmpSA.getPredictedRating("good bad excellent okay nice horrible");
        assertEquals(3.5f, actual);
    }

    @Test
    public void testMissingWord() throws Exception {
        float actual = rmpSA.getPredictedRating("ignoramus");
        assertTrue(actual == 1.0 || actual == 5.0);
    }

    @Test
    public void testSomeMissingWords() throws Exception {
        float actual = rmpSA.getPredictedRating("ignoramus okay so-so");
        assertEquals(3f, actual);
    }

    @Test
    public void testJunk() throws Exception {
        float actual = rmpSA.getPredictedRating("okay but !!!$% what good");
        assertEquals(3f, actual);
    }

    @Test
    public void test_Star() throws Exception {
        float actual = rmpSA.getPredictedRating("star *");
        assertEquals(5f, actual);
    }

    @Test
    public void test_1() throws Exception {
        float actual = rmpSA.getPredictedRating("1 ****");
        assertTrue(actual == 1.0 || actual == 5.0);
    }

    @Test
    public void test_1_5() throws Exception {
        float actual = rmpSA.getPredictedRating("average could be bad weird vague harsh sucks");
        assertEquals(1.5f, actual);
    }

}
