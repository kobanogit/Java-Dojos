package fr.wildcodeschool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import fr.wildcodeschool.poker.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerTest {

    @Test
    public void testCardSuitParsing() {
        assertEquals(CardSuit.SPADES, CardSuit.parse('S'));
    }

    @Test
    public void testCardParsing() {
        Card expected = new Card('2', 'S');
        assertEquals(CardValue.TWO, expected.getValue());
        assertEquals(CardSuit.SPADES, expected.getSuit());
    }

    @Test
    public void testHand() {
        Card card = new Card('A', 'C');
        PokerHand pokerHand = new PokerHand("AC AC AC AC AC");
        List<Card> expectedCardsList = new ArrayList<Card>();
        expectedCardsList.add(card);
        expectedCardsList.add(card);
        expectedCardsList.add(card);
        expectedCardsList.add(card);
        expectedCardsList.add(card);
        assertThat(expectedCardsList, is(pokerHand.getCards()));

    }

    @Test
    public void testGetCombination() {
        PokerHand pokerHand = new PokerHand("AS AC AD AH 2D");
        assertEquals(CombinationType.FOUR_OF_A_KIND, pokerHand.getBestCombination());
    }

    @Test
    public void testHandConversionIntoCombinationType() {
        PokerHand pokerHand = new PokerHand("AS AC AD AH 2D");
        CombinationType bestCombination = CombinationType.fromPokerHand(pokerHand);
        assertEquals(CombinationType.FOUR_OF_A_KIND, bestCombination);
    }

    @Test
    public void testCombinationTypeMatched() {
        PokerHand pokerHand = new PokerHand("AS AC AD AH 2D");
        assertTrue(CombinationType.FOUR_OF_A_KIND.isMatched(pokerHand));
    }


    @Test
    public void testIsSameValueCombinationType() {
        PokerHand pokerHand = new PokerHand("AS AC 3D KH KD");
        assertTrue(CombinationType.TWO_PAIR.isSameRepetitions(pokerHand));
    }


    @Test
    public void testIsNotSameValueCombinationType() {
        PokerHand pokerHand = new PokerHand("AS AC AD KH KD");
        assertFalse(CombinationType.TWO_PAIR.isSameRepetitions(pokerHand));
    }


    @Test
    public void testIsSequence() {
        PokerHand pokerHand = new PokerHand("2S 3C 4D 5H 6D");
        assertTrue(CombinationType.isSequence(pokerHand));
    }

    @Test
    public void testIsNotSequence() {
        PokerHand pokerHand = new PokerHand("2S 3C 4D KH 6D");
        assertFalse(CombinationType.isSequence(pokerHand));
    }

    @Test
    public void testHighHandCombination() {
        PokerHand pokerHand = new PokerHand("2S 3C 4D KH 6D");
        assertEquals(CombinationType.HIGH_HAND, CombinationType.fromPokerHand(pokerHand));
    }

    @Test
    public void testCompareWithTie() {
        PokerHand pokerHand = new PokerHand("2S 3C 4D KH 6D");
        PokerHand pokerHand2 = new PokerHand("2S 3C 4D KH 6D");
        assertEquals(Result.TIE, pokerHand.compareWith(pokerHand2));
    }

    @Test
    public void testCompareFullVsTwoPairs() {
        PokerHand pokerHand = new PokerHand("2S 2C 2D KH KD");
        PokerHand pokerHand2 = new PokerHand("3S 3C 4D AH AD");
        assertEquals(Result.WIN, pokerHand.compareWith(pokerHand2));
        assertEquals(Result.LOSS, pokerHand2.compareWith(pokerHand));
    }


    @Test
    public void testCompareSameCombinationWithWinnerKicker() {
        PokerHand loserHand = new PokerHand("3S 3C 8D QH KD");
        PokerHand winnerHand = new PokerHand("3S 3C 7D AH KD");
        assertEquals(Result.WIN, winnerHand.compareWith(loserHand));
    }

    @Test
    public void testCompareThreeOfAKindWithWinnerCombination() {
        PokerHand winnerHand = new PokerHand("8S 8C 8D QH KD");
        PokerHand loserHand = new PokerHand("3S 3C 3D AH KD");
        assertEquals(Result.WIN, winnerHand.compareWith(loserHand));
    }

    @Test
    public void testCompareFullWithWinnerCombination() {
        PokerHand winnerHand = new PokerHand("8S 8C 8D QH QD");
        PokerHand loserHand = new PokerHand("3S 3C 3D AH AD");
        assertEquals(Result.WIN, winnerHand.compareWith(loserHand));
    }


    @Test
    public void testCompareTwoPairsWithWinnerCombination() {
        PokerHand winnerHand = new PokerHand("8S 8C 5D 5H QD");
        PokerHand loserHand = new PokerHand("8H 8D 2D 2H AD");
        assertEquals(Result.WIN, winnerHand.compareWith(loserHand));
    }


    @Test
    public void testKickerHand() {
        PokerHand hand = new PokerHand("3S 3C QH 8D KD");
        List<Card> kicker = Arrays.asList(
                new Card(CardValue.EIGHT, CardSuit.DIAMONDS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.DIAMONDS)
        );
        List<Card> resultKicker = hand.getKicker();
        Collections.sort(kicker);
        Collections.sort(resultKicker);
        assertEquals(kicker, resultKicker);
    }

}