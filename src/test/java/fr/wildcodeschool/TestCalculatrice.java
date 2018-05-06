package fr.wildcodeschool;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestCalculatrice {

    Calculatrice calculatrice = new Calculatrice();

    @Test
    public void calculeTestSymbolPlus(){
        assertEquals(12, calculatrice.calcule("6+6"), 0.00 );
    }

    @Test
    public void calculeTestSymbolMoins(){
        assertEquals(0, calculatrice.calcule("6-6"), 0.00 );
    }

    @Test
    public void calculeTestReturnType(){
       assertEquals(12, calculatrice.calcule("12"), 0.00 );
    }
}
