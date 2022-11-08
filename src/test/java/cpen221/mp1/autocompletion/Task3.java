package cpen221.mp1.autocompletion;

import cpen221.mp1.autocompletion.gui.In;
import cpen221.mp1.cities.DataAnalyzer;
import cpen221.mp1.ngrams.NGrams;
import cpen221.mp1.searchterm.SearchTerm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Task3 {
    private static final String ngrams1 = "data/ngrams-sample1.csv";
    private static AutoCompletor ac;

    @BeforeAll
    public static void setupTests() {
        List<SearchTerm> searchTermList = new LinkedList<>();
        In reader = new In(new File(ngrams1));
        while (reader.hasNextLine()) {
            String line = reader.readLine();
            String[] columns = line.split(",");
            SearchTerm st = new SearchTerm(columns[0], Long.parseLong(columns[1]));
            searchTermList.add(st);
        }
        SearchTerm[] searchTerms = new SearchTerm[searchTermList.size()];
        searchTerms = searchTermList.toArray(searchTerms);
        ac = new AutoCompletor(searchTerms);
    }

    @Test
    public void test1Gram1() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("to her", 53836478L),
            new SearchTerm("to go", 43484567L),
            new SearchTerm("total", 42219879L)
        };
        SearchTerm[] actual = ac.topKMatches("to", 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test1Gram2() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("she did", 25319673L),
            new SearchTerm("she did not", 19055690L),
            new SearchTerm("sheet", 9236673L),
            new SearchTerm("shell", 6058521L),
            new SearchTerm("she says", 4529855L),
            new SearchTerm("she had a", 3455701L),
            new SearchTerm("sheriff", 3394606L),
            new SearchTerm("she did not want", 2644690L),
            new SearchTerm("she had no", 2334192L),

        };
        SearchTerm[] actual = ac.topKMatches("she");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test1Gram3() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("an", 769975875L),
            new SearchTerm("again", 124520067L),
            new SearchTerm("against", 112836204L),
            new SearchTerm("and I", 105589183L),
            new SearchTerm("always", 92441144L),
            new SearchTerm("already", 63039352L),
            new SearchTerm("age", 51345139L),
            new SearchTerm("approach", 51187511L),
            new SearchTerm("according to", 46786465L),
            new SearchTerm("addition", 33103168L),
        };
        SearchTerm[] actual = ac.topKMatches("a");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2Gram1() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("how do you know", 1249290L)
        };
        SearchTerm[] actual = ac.topKMatches("how d", 6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2Gram2() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("and their", 31610547L),
            new SearchTerm("and then I", 2663849L),
            new SearchTerm("and that they", 1805593L),
            new SearchTerm("and the United States", 1613231)
        };
        SearchTerm[] actual = ac.topKMatches("and t", 4);
        assertArrayEquals(expected, actual);
        assertArrayEquals(expected, ac.allMatches("and t"));
    }

    @Test
    public void test3Gram1() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("I am not", 5827094L),
            new SearchTerm("I am the", 1931943L),
        };
        SearchTerm[] actual = ac.topKMatches("I am", 6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3Gram2() {
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("the middle of the", 5634026L),
            new SearchTerm("the middle of a", 934950L),
        };
        SearchTerm[] actual = ac.allMatches("the middle of");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4Gram1() {
        // to test lexicographic ordering
        SearchTerm[] expected = new SearchTerm[] {
            new SearchTerm("where in the world is", 103L),
            new SearchTerm("where in the world will", 103L),
        };
        SearchTerm[] actual = ac.allMatches("where in the world");
        assertArrayEquals(expected, actual);
    }
}
