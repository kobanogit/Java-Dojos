package fr.wildcodeschool.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CombinationType {
    HIGH_HAND(1, false, false),
    PAIR(2, false, new Integer[]{2},false),
    TWO_PAIR(3,false, new Integer[]{2,2},false ),
    THREE_OF_A_KIND(4,false, new Integer[]{3},false),
    STRAIGHT(5,false,true),
    FLUSH(6,true,false),
    FULL_HOUSE(7,false,new Integer[]{3,2},false),
    FOUR_OF_A_KIND(8,false,new Integer[]{4},false),
    STRAIGHT_FLUSH(9, true, true),
    ROYAL_FLUSH(10, true, true);

    private int value = 0;
    private boolean sameSuit;
    private List<Integer> sameValues;
    private boolean sequenceValue ;


    CombinationType(int value, boolean sameSuit, boolean sequenceValue) {
        this(value, sameSuit, new Integer[]{}, sequenceValue);
    }

    CombinationType(int value, boolean sameSuit, Integer[] sameValues, boolean sequenceValue) {
        this.value = value;
        this.sameSuit = sameSuit;
        this.sameValues = Arrays.asList(sameValues);
        this.sequenceValue = sequenceValue;
    }

    public static CombinationType fromPokerHand(PokerHand pokerHand){
        // commencer par chercher les combinaison les plus fortes
        // tester les couleurs
        // trier les cartes de la main de la plus haute valeur à la plus basse
        // si toutes ont la même couleur
            // comparer les valeurs
        for (Card currentCard : pokerHand.getCards()) {

        }

        return null;
    }

    public boolean isMatched(PokerHand hand){

        return false;
    }

    public boolean isSameSuit(PokerHand hand) {
        CardSuit matchingSuit = null;
        for (Card currentCard : hand.getCards()) {
            if (matchingSuit == null){
                matchingSuit = currentCard.getSuit();
            } else if ( ! matchingSuit.equals(currentCard.getSuit()) ){
                return false;
            }
        }
        return true;
    }

    public boolean isSameValue(PokerHand hand) {
        // On trie les cartes par valeur pour simplifier la comparaison
        List<Card> sortedCards = new ArrayList<>(hand.getCards());
        Collections.sort(sortedCards);
        for (int nbIdenticalCards: this.sameValues)
        {
            int counter = 1;
            CardValue previousCardValue = null;
            for (int i = 0 ; i < sortedCards.size() ; i++) {
                if (sortedCards.get(i).getValue().equals(previousCardValue) ) {
                            counter++;
                            if(counter == nbIdenticalCards){
                                return true;
                            }
                }else{
                    counter = 1;
                }
                previousCardValue = sortedCards.get(i).getValue();

            }
        }


        return false;
    }
}
