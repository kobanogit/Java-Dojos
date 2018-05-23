package fr.wildcodeschool.poker;

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
        return other.getValue().getValue() - getValue().getValue();
    }
}
