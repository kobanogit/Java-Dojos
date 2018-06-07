package fr.wildcodeschool.poker;

import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {

    private CardSuit suit;
    private CardValue value;

    public Card(CardValue value,CardSuit suit) {
        this.suit = suit;
        this.value = value;
    }

    public Card(char value, char suit){
        this.suit = CardSuit.parse(suit);
        this.value = CardValue.parse(value);
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card){
            Card cardRepresentation = (Card) obj;
            return this.value.equals(cardRepresentation.value)
                    && this.suit.equals(cardRepresentation.suit);
        }
        else {
            return false;
        }
    }

    @Override
    public int compareTo(Card other) {
        return getValue().getValue() - other.getValue().getValue();
    }

    public String toString() {
        return this.getValue().name() + this.suit.name();
    }



    /**
     * Compare 2 listes de cartes
     * @param refCards
     * @param candidateCards
     * @return
     */
    public static int compareCards(List<Card> refCards, List<Card> candidateCards) {
        int res = 0;
        Collections.sort(refCards);
        Collections.sort(candidateCards);

        Collections.reverse(refCards);
        Collections.reverse(candidateCards);

        for (int i = 0; i < refCards.size(); i++) {
            res = refCards.get(i).compareTo(candidateCards.get(i));
            if (res != 0) {
                break;
            }
        }
        return res;
    }

}
