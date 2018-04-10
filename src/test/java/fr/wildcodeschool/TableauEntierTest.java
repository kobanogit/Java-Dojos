package fr.wildcodeschool;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


public class TableauEntierTest {

    int [] tableau = {5,10,-1,3};

    public TableauEntierTest() {
        tableau2 = new int[]{-5,10,-1,3};
    }

    @Test
    public void mintest() {
        TableauEntier calculateur= new TableauEntier();
        assertEquals(-1, calculateur.minmax(tableau)[0]);
        assertEquals(10,calculateur.minmax(tableau)[1]);
    }
    //on test le min en premiere position

    int [] tableau2;
    @Test
    public void test2() {
        TableauEntier calculateur= new TableauEntier();
        assertEquals(-5, calculateur.minmax(tableau2)[0]);
        assertEquals(10,calculateur.minmax(tableau2)[1]);
    }

    //on test le max en premiere position
    int [] tableau3 = {50,10,-1,3};
    @Test
    public void test3() {
        TableauEntier calculateur= new TableauEntier();
        assertEquals(-1, calculateur.minmax(tableau3)[0]);
        assertEquals(50,calculateur.minmax(tableau3)[1]);
    }
    //on test avec une seule valeur
    int [] tableau4 = {-5};
    @Test
    public void test4() {
        TableauEntier calculateur= new TableauEntier();
        assertEquals(-5, calculateur.minmax(tableau4)[0]);
        assertEquals(-5,calculateur.minmax(tableau4)[1]);
    }

}
