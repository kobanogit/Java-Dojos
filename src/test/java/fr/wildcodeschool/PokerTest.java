package fr.wildcodeschool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import fr.wildcodeschool.poker.Card;
import fr.wildcodeschool.poker.CardSuit;
import fr.wildcodeschool.poker.CardValue;
import fr.wildcodeschool.poker.PokerHand;
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


}
