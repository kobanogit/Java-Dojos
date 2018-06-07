package fr.wildcodeschool.poker;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination implements Comparable<Combination> {

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public CombinationType getType() {
        return type;
    }

    public void setType(CombinationType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Combination candidate) {
        int res = getType().compare(candidate.getType());
        if (res == 0) {
            List<List<Card>> sameValueCards = CombinationType.getSameValueCards(getCards());
            List<List<Card>> candidateSameValueCards = CombinationType.getSameValueCards(candidate.getCards());

            CardsListSizeComparator cardsListComparator = new CardsListSizeComparator();
            Collections.sort(sameValueCards, cardsListComparator);
            Collections.sort(candidateSameValueCards, cardsListComparator);

            Collections.reverse(sameValueCards);
            Collections.reverse(candidateSameValueCards);

            for (int i = 0; i < sameValueCards.size(); i++) {
                res = Card.compareCards(sameValueCards.get(i), candidateSameValueCards.get(i));
                if (res != 0) {
                    break;
                }
            }
        }
        return res;
    }



}
