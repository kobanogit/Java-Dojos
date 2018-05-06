package fr.wildcodeschool;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class TestCalcJulien {

    CalcJulien maCalc = new CalcJulien();

    @Test
    public void testReturnPristine() {
        assertEquals(6, maCalc.calcule("6"), 0);
    }

    @Test
    public void testAdditionner() {
        assertEquals(11, maCalc.calcule("6+5"), 0);
    }

    @Test
    public void testAdditionnerPlusieurs() {
        assertEquals(19, maCalc.calcule("6+4+9"), 0);
    }

    @Test
    public void testAdditionnerSoustraire() {
        assertEquals(1, maCalc.calcule("6+4-9"), 0);
    }

    @Test
    public void testSoustraireAdditionner() {
        assertEquals(11, maCalc.calcule("6-4+9"), 0);
    }

    @Test
    public void testSoustraire() {
        assertEquals(2, maCalc.calcule("6-4"), 0);
    }

    @Test
    public void testMultiplier() {
        assertEquals(24, maCalc.calcule("6*4"), 0);
    }

    @Test
    public void testDiviser() {
        assertEquals(2, maCalc.calcule("6/3"), 0);
    }

    @Test
    public void testCalcule() {
        assertEquals(1, maCalc.calcule("2+3-4"), 0);
    }

    @Test
    public void testCalcule2() {
        assertEquals(6, maCalc.calcule("2+3*2-18/9"), 0);
    }

    @Test
    public void testCalcule3() {
        assertEquals(13, maCalc.calcule("2+3*2-18/9+3*9/3-2"), 0);
    }

    @Test
    public void testCalcule4() {
        assertEquals(-10, maCalc.calcule("18/6*3+3+2-6/2-3*9/3+5-5-4*3"), 0);
    }

}
