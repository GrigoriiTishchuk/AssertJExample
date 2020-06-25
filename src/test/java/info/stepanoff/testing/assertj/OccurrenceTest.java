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
import org.junit.Test;
import static org.junit.Assert.*;


public class OccurrenceTest {

    /**
     * Test of compareTo method, of class Occurrence.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Occurrence o1 = new Occurrence(1, 3, 2),
                o2 = new Occurrence(1, 3, 2),
                o3 = new Occurrence(1, 3, 1),
                o4 = new Occurrence(1, 3, 3),
                o5 = new Occurrence(1, 2, 2),
                o6 = new Occurrence(1, 4, 2),
                o7 = new Occurrence(0, 3, 2),
                o8 = new Occurrence(2, 3, 2);
        assertTrue(o1.compareTo(o2) == 0);
        assertTrue(o1.compareTo(o3) > 0);
        assertTrue(o1.compareTo(o4) < 0);
        assertTrue(o1.compareTo(o5) > 0);
        assertTrue(o1.compareTo(o6) < 0);
        assertTrue(o1.compareTo(o7) > 0);
        assertTrue(o1.compareTo(o8) < 0);
    }

    /**
     * Test of hashCode method, of class Occurrence.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(
                new Occurrence(0, 1, 2).hashCode(),
                new Occurrence(0, 1, 2).hashCode());
        assertNotEquals(
                new Occurrence(0, 1, 2).hashCode(),
                new Occurrence(0, 1, 3).hashCode());
        assertNotEquals(
                new Occurrence(0, 1, 2).hashCode(),
                new Occurrence(0, 2, 2).hashCode());
        assertNotEquals(
                new Occurrence(0, 1, 2).hashCode(),
                new Occurrence(1, 1, 2).hashCode());
    }

    /**
     * Test of equals method, of class Occurrence.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertEquals(
                new Occurrence(0, 1, 2),
                new Occurrence(0, 1, 2));
        assertNotEquals(
                new Occurrence(0, 1, 2),
                new Occurrence(0, 1, 3));
        assertNotEquals(
                new Occurrence(0, 1, 2),
                new Occurrence(0, 2, 2));
        assertNotEquals(
                new Occurrence(0, 1, 2),
                new Occurrence(1, 1, 2));
    }

    /**
     * Test of toString method, of class Occurrence.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("(0, 1, 2)", new Occurrence(0, 1, 2).toString());
    }
}