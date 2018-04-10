package fr.wildcodeschool;


import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    @Test
    public void fizz() {
        assertEquals("fizz", FizzBuzz.fizzbuzz(9));
    }

    @Test
    public void buzz() {
        assertEquals("buzz", FizzBuzz.fizzbuzz(50));
    }

    @Test
    public void fizzbuzz() {
        assertEquals("fizzbuzz", FizzBuzz.fizzbuzz(45));
    }

    @Test
    public void noFizzNoBuzz() {
        assertEquals("11", FizzBuzz.fizzbuzz(11));
    }

}
