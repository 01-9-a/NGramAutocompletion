package cpen221.mp1;

import cpen221.mp1.ngrams.NGrams;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class task1tests {

    @Test
    public void simpleTestCount() {
        String text1 = "1 2 3 1 2 3 4";
        String text2 = "1 2 3 4 5";

        long expectedCount = 10;

        NGrams ng = new NGrams(new String[]{text1, text2});

        assertEquals(expectedCount, ng.getTotalNGramCount(2));
    }

    @Test
    public void simpleTestGetNGrams() {
        String text1 = "great textbook";
        String text2 = "good textbook written by him";

        List<Map<String, Long>> expectedNGrams = List.of(
                Map.of("great", 1L, "textbook", 2L, "good", 1L, "written", 1L, "by", 1L, "him", 1L),
                Map.of("great textbook", 1L, "good textbook", 1L, "textbook written", 1L, "written by", 1L, "by him", 1L),
                Map.of("good textbook written", 1L, "textbook written by", 1L, "written by him", 1L),
                Map.of("good textbook written by", 1L, "textbook written by him", 1L),
                Map.of("good textbook written by him", 1L)
        );

        NGrams ng = new NGrams(new String[]{text1, text2});
        assertEquals(expectedNGrams, ng.getAllNGrams());
    }

}