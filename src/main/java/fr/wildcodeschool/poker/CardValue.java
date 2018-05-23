package fr.wildcodeschool.poker;

public enum CardValue {
    TWO(2, '2'), THREE(3, '3'), FOUR(4, '4'), FIVE(5, '5'), SIX(6, '6'),
    SEVEN(7, '7'), EIGHT(8, '8'), NINE(9, '9'),
    TEN(10, 'T'), JACK(11, 'J'), QUEEN(12, 'Q'), KING(13, 'K'), ACE(14, 'A');

    private int value = 0;
    private char identifier;
    CardValue(int value, char identifier){
        this.value = value;
        this.identifier = identifier;
    }

    public int getValue() {
        return value;
    }

    public static CardValue parse(char value){
        for (CardValue card: CardValue.values()) {
            if (value == card.identifier){
                return card;
            }

        }
        return null;
    }
}
