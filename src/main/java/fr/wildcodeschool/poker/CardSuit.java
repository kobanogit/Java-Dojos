package fr.wildcodeschool.poker;

public enum CardSuit {
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D'),
    CLUBS('C');

    private final char identifier;

    CardSuit(char identifier){
        this.identifier = identifier;
    }

    public static CardSuit parse(char suit){
        //recupere le tableau des valeur
        for (CardSuit cardSuit : CardSuit.values()){
            // On compare cette identifier à la identifier de cardSuit
            if (suit == cardSuit.identifier){
                return cardSuit; // On quitte la méthode avec la bonne valeur
            }
        }
        return null;
    }
}
