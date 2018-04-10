package fr.wildcodeschool;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


public class MissingLetterTest {
    MissingLetter cletter=new MissingLetter();
    @Test
    public void testFail(){
        char [] tabArray = {'a', 'b', 'd'};
        char expected = 'c';
        assertEquals(expected, cletter.checkMissingLetter(tabArray));
    }
    @Test
    public void testFailBis(){
        char [] tabArray = {'a', 'b', 'd'};
        char expected = 'c';
        assertEquals(expected, cletter.checkMissingLetterBis(tabArray));
    }
    @Test
    public void testMajBis(){
        char [] tabArray = {'J', 'K', 'M'};
        char expected = 'L';
        assertEquals(expected, cletter.checkMissingLetterBis(tabArray));
    }
}
