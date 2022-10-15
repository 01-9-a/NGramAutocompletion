package cpen221.mp1;

import cpen221.mp1.autocompletion.AutoCompletor;
import cpen221.mp1.cities.DataAnalyzer;
import cpen221.mp1.searchterm.SearchTerm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.List;

public class Task3Tests {
    private static String citiesData = "data/cities.txt";
    private static DataAnalyzer cityAnalyzer;
    private static AutoCompletor ac;
    private static AutoCompletor ac1;

    @BeforeAll
    public static void setupTests() {
        cityAnalyzer = new DataAnalyzer(citiesData);
        ac = new AutoCompletor(cityAnalyzer.getSearchTerms());
        List<Map<String, Long>> testIn = List.of(
                Map.of("Shangaai, China", (long)14608512,"Buenos Aires, Argentina", (long)13076300, "Mumbai, India", (long)12691836, "Shangrao, China", (long)318769),
                Map.of("Shangqiu, China", (long)181218, "Kishangarh, India", (long)131749,"Shanghai, China", (long)14608512,"Shangyu, China", (long)770000)
        );
        ac1 = new AutoCompletor(testIn);
    }

/*
    @Test
    public void test_Shang_4() {
        SearchTerm[] st = ac.topKMatches("Shang", 4);

        SearchTerm shanghai = new SearchTerm("Shanghai, China", 14608512);
        SearchTerm shangyu = new SearchTerm("Shangyu, China", 770000);
        SearchTerm shangrao = new SearchTerm("Shangrao, China", 318769);
        SearchTerm shangqiu = new SearchTerm("Shangqiu, China", 181218);
        SearchTerm[] expectedST = new SearchTerm[] { shanghai, shangyu, shangrao, shangqiu};

        Assertions.assertArrayEquals(expectedST, st);
    }
*/
    @Test
    public void test_Shang_3() {
        SearchTerm[] all = ac1.allMatches("Shang");

        SearchTerm[] topK1 = ac1.topKMatches("Shang", 3);
        SearchTerm[] topK2 = ac1.topKMatches("Shang");
        int matches = ac1.numberOfMatches("Shang");

        SearchTerm shangaai = new SearchTerm("Shangaai, China", 14608512);
        SearchTerm shanghai = new SearchTerm("Shanghai, China", 14608512);
        SearchTerm shangyu = new SearchTerm("Shangyu, China", 770000);
        SearchTerm shangrao = new SearchTerm("Shangrao, China", 318769);
        SearchTerm shangqiu = new SearchTerm("Shangqiu, China", 181218);
        SearchTerm[] expectedAll = new SearchTerm[] { shangaai, shanghai, shangyu, shangrao, shangqiu};
        SearchTerm[] expectedTopK1 = new SearchTerm[] { shangaai, shanghai, shangyu};
        SearchTerm[] expectedTopK2 = new SearchTerm[] { shangaai, shanghai, shangyu, shangrao, shangqiu};
        int expectedMatches = 5;

        Assertions.assertArrayEquals(expectedAll, all);
        Assertions.assertArrayEquals(expectedTopK1, topK1);
        Assertions.assertArrayEquals(expectedTopK2, topK2);
        Assertions.assertEquals(expectedMatches, matches);
    }

    @Test
    public void testCities2() {
        SearchTerm[] topK = ac.topKMatches("Bor", 5);

        SearchTerm bordeaux = new SearchTerm("Bordeaux, France", 609617);
        SearchTerm borivli = new SearchTerm("Borivli, India", 609617);
        SearchTerm borūjerd = new SearchTerm("Borūjerd, Iran", 609617);
        SearchTerm bordj = new SearchTerm("Bordj el Kiffan, Algeria", 123246);
        SearchTerm born = new SearchTerm("Born, Netherlands", 97169);
        SearchTerm[] expectedTopK = new SearchTerm[] {bordeaux, borivli, borūjerd, bordj, born};

        Assertions.assertArrayEquals(expectedTopK, topK);
    }
}
