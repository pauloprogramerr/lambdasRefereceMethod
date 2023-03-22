package org.example;

import org.functionpackage.ImplementPredicate;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.functionpackage.ImplementPredicate.*;
import static org.junit.Assert.assertEquals;
public class ImplementPredicateTest {

    private ImplementPredicate demo = new ImplementPredicate();
    private String[] names;

    @Before
    public void setUp(){
        names = Stream.of("Mal", "Wash", "Kaylee", "Inara", "Zoẽ",
                        "Jayne", "Simon", "River", "Shepherd Book")
                .sorted()
                .toArray(String[]::new);
    }

    @Test
    public void getNamesOfLength5() throws Exception{
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNameOfLength(5, names));
    }
    @Test
    public void getNameStartingWithS() throws Exception{
        assertEquals("Shepherd Book, Simon" ,
                demo.getNameStartingWith("S", names));
    }

    @Test
    public void getNamesSatisfyingCondition() throws Exception{
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNameSatisfyCondition(s -> s.length() == 5, names));
        assertEquals("Shepherd Book, Simon" ,
                demo.getNameSatisfyCondition(s ->  s.startsWith("s"), names));
        assertEquals("Inara, Jayne, River, Simon",
                demo.getNameSatisfyCondition(LENGTH_FIVE, names));
        assertEquals("Shepherd Book, Simon" ,
                demo.getNameSatisfyCondition(STARTS_WITH_S, names));
    }
    @Test
    public void composedPredicate() throws Exception{
        assertEquals("Simon",
                demo.getNameSatisfyCondition(
                        LENGTH_FIVE.and(STARTS_WITH_S), names));
        assertEquals("Inara, Jayne, River, Shepherd Book, Simon",
                demo.getNameSatisfyCondition(
                        LENGTH_FIVE.or(STARTS_WITH_S), names));
        assertEquals("Kaylee, Mal, Shepherd Book, Wash, Zoê",
                demo.getNameSatisfyCondition(LENGTH_FIVE.negate(), names));

    }
}
