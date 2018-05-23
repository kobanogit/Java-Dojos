package fr.wildcodeschool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import fr.wildcodeschool.poker.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerTest {

    @Test
    public void testCardSuitParsing(){
        assertEquals(CardSuit.SPADES, CardSuit.parse('S'));
    }

    @Test
    public void testCardParsing(){
        Card expected = new Card('2','S');
        assertEquals(CardValue.TWO,expected.getValue());
        assertEquals(CardSuit.SPADES,expected.getSuit());
    }

    @Test
    public void testHand(){
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
    public void testGetCombination () {
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
    public void testCombinationTypeMatched(){
        PokerHand pokerHand = new PokerHand("AS AC AD AH 2D");
        assertTrue(CombinationType.FOUR_OF_A_KIND.isMatched(pokerHand));
    }


}
