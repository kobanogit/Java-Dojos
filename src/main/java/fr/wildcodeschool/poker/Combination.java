package fr.wildcodeschool.poker;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    private List<Card> cards;
    private CombinationType type;

    public Combination(PokerHand hand) {
        this.type = CombinationType.fromPokerHand(hand);
        this.cards = this.matchingCards(hand);
    }


    /**
     * Renvoie la liste des cartes "impliquées" dans la combinaison
     * @param hand
     * @return
     */
    private List<Card> matchingCards(PokerHand hand) {
        CombinationType matchingCombinationType = CombinationType.fromPokerHand(hand);
        List<Card> matchingCards = new ArrayList<>();
        if (matchingCombinationType.isSameSuit() || matchingCombinationType.isSequenceValue()) {
            matchingCards = hand.getCards();
        } else if (matchingCombinationType.isSameValueBased()){
            List<List<Card>> allSameCards = CombinationType.getSameValueCards(hand.getCards());
            for (List<Card> sameCards: allSameCards) {
                matchingCards.addAll(sameCards);
            }
        } else {
            matchingCards.addAll(hand.getCards());
        }
        return matchingCards;
    }


}
