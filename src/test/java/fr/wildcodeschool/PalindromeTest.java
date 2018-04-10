package fr.wildcodeschool;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class PalindromeTest {
    String estUnPalindrome = "Abba";
    String nestPasUnPalindrome = "sonar";

    Palindrome palinTest = new Palindrome();
    @Test
    public void testIsPalindrome(){
        assertTrue(palinTest.isPalindrome("ABBA") );
    }

    @Test
    public void testIsPalindromeSeveralCases(){
        assertTrue(palinTest.isPalindrome("Abba") );
    }

    @Test
    public void testIsPalindromeImpair(){
        assertTrue(palinTest.isPalindrome("Abcba") );
    }

    @Test
    public void testIsPalindromeNumbers(){
        assertTrue(palinTest.isPalindrome("12321"));
    }

}
