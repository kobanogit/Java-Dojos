package fr.wildcodeschool;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCrazyPyramide {
    CrazyPyramide testPyramide = new CrazyPyramide();


    @Test
    public void testAvecTaille_1(){
        String[] expected = new String[3];
        expected[0] = "  /*\\";
        expected[1] = " /***\\";
        expected[2] = "/**|**\\";

        assertTrue(Arrays.equals(expected, testPyramide.buildPyramide(1)));
    }
}
