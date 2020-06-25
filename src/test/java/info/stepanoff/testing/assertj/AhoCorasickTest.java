/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.stepanoff.testing.assertj;

/**
 *
 * @author GTO
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;


public class AhoCorasickTest {

    /**
     * Test of search method, of class AhoCorasick.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Character[] text = ArrayUtils.toObject("hushers".toCharArray());
        List<Character[]> patterns = Stream.of(
                "hu",
                "she",
                "hers")
                .map(s -> ArrayUtils.toObject(s.toCharArray()))
                .collect(Collectors.toList());
         AhoCorasick<Character> ac = new   AhoCorasick<>(patterns);
        SetMultimap<Integer, Integer> expResult = HashMultimap.create();
        expResult.put(1, 0);
        expResult.put(4, 1);
        expResult.put(6, 2);
        SetMultimap<Integer, Integer> result = ac.searchPosToPattern(text);
        assertEquals(expResult, result);
    }
}