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
import com.google.common.collect.Sets;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;


public class AhoCorasickHelpersTest {

    /**
     * Test of toOccurrenceList method, of class AhoCorasickHelpers.
     */
    @Test
    public void testToOccurrenceList() {
        Character[] text = ArrayUtils.toObject("hushers".toCharArray());
        List<Character[]> patterns = Stream.of(
                "hu",
                "she",
                "hers")
                .map(s -> ArrayUtils.toObject(s.toCharArray()))
                .collect(Collectors.toList());
          AhoCorasick<Character> ac = new   AhoCorasick<>(patterns);
        SortedSet<Occurrence> expResult = Sets.newTreeSet();
        expResult.add(new Occurrence(0, 1, 0));
        expResult.add(new Occurrence(2, 4, 1));
        expResult.add(new Occurrence(3, 6, 2));
        SortedSet<Occurrence> result
                = AhoCorasickHelpers.toOccurrenceList(
                        ac.searchPosToPattern(text),
                        patterns,
                        false);
        assertEquals(expResult, result);
        result = AhoCorasickHelpers.toOccurrenceList(
                ac.searchPatternToPos(text),
                patterns,
                true);
        assertEquals(expResult, result);
    }

}