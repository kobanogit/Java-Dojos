package fr.wildcodeschool.poker;

import java.util.*;

public enum CombinationType implements Comparable<CombinationType> {

    HIGH_HAND(1, false, false),
    PAIR(2, false, new Integer[]{2}, false),
    TWO_PAIR(3, false, new Integer[]{2, 2}, false),
    THREE_OF_A_KIND(4, false, new Integer[]{3}, false),
    STRAIGHT(5, false, true),
    FLUSH(6, true, false),
    FULL_HOUSE(7, false, new Integer[]{3, 2}, false),
    FOUR_OF_A_KIND(8, false, new Integer[]{4}, false),
    STRAIGHT_FLUSH(9, true, true),
    ROYAL_FLUSH(10, true, true);

    private int value = 0;
    private boolean sameSuit;
    private List<Integer> cardsRepetitions;
    private boolean sequenceValue;


    CombinationType(int value, boolean sameSuit, boolean sequenceValue) {
        this(value, sameSuit, new Integer[]{}, sequenceValue);
    }

    CombinationType(int value, boolean sameSuit, Integer[] sameValues, boolean sequenceValue) {
        this.value = value;
        this.sameSuit = sameSuit;
        this.cardsRepetitions = Arrays.asList(sameValues);
        this.sequenceValue = sequenceValue;
    }

    public static CombinationType fromPokerHand(PokerHand hand) {
        List<CombinationType> allCombinations = Arrays.asList(CombinationType.values());
        //on trie les combinaisons par ordre de valeur
        //pour que le premier match soit la meilleure des combinaisons
        Collections.sort(allCombinations, new CombinationTypeComparator());
        Collections.reverse(allCombinations);
        CombinationType bestCombination = null;
        int i = 0;
        boolean matched = false;
        while (bestCombination == null && i <= (allCombinations.size() - 1) ){
            if (allCombinations.get(i).isMatched(hand)) {
                bestCombination = allCombinations.get(i);
            }
            i++;
        }
        return bestCombination;
    }

    public boolean isMatched(PokerHand hand) {
        boolean match = true;
        if (this.isSameSuit() && !this.isSameSuit(hand)) {
            match = false;
        } else if (this.isSequenceValue() && !isSequence(hand)) {
            match = false;
        } else if (this.cardsRepetitions != null && !this.cardsRepetitions.isEmpty() && !isSameRepetitions(hand)) {
            match = false;
        }
        return match;
    }


    public boolean isSameSuit(PokerHand hand) {
        CardSuit matchingSuit = null;
        for (Card currentCard : hand.getCards()) {
            if (matchingSuit == null) {
                matchingSuit = currentCard.getSuit();
            } else if (!matchingSuit.equals(currentCard.getSuit())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSameRepetitions(PokerHand hand) {
        return isSameRepetitions(hand.getCards());
    }

    public boolean isSameRepetitions(List<Card> cards) {
        List<List<Card>> allSameCards = getSameValueCards(cards);
        List<Integer> multiVals = new ArrayList<>();
        for (List<Card> sameCards: allSameCards) {
            multiVals.add(sameCards.size());
        }

        List<Integer> sortedSameValues = new ArrayList(this.cardsRepetitions);
        Collections.sort(sortedSameValues);
        Collections.sort(multiVals);
        boolean sameValsFound = false;
        if (multiVals.size() == sortedSameValues.size()) {
            for (int i= 0; i < multiVals.size(); i++) {
                if (multiVals.get(i).equals(sortedSameValues.get(i))) {
                    sameValsFound = true;
                } else {
                    sameValsFound = false;
                    break;
                }
            }
        }

        return sameValsFound;
    }


    /**
     * Renvoie les listes de cartes de même valeur
     * @param cards
     * @return
     */
    public static List<List<Card>> getSameValueCards(List<Card> cards) {
        List<List<Card>> allSameCards = new ArrayList<>();

        // On trie les cartes par valeur pour simplifier la comparaison
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards);

        CardValue previousCardValue = null;
        int nbSameValues = 1;
        List<Card> sameVals = new ArrayList<>();
        for (Card card: sortedCards) {
            if (!card.getValue().equals(previousCardValue)) {
                if (sameVals.size() > 1) {
                    allSameCards.add(sameVals);
                }
                sameVals = new ArrayList<>();
                nbSameValues = 1;
            }
            sameVals.add(card);
            previousCardValue = card.getValue();
        }

        if (sameVals.size() > 1) {
            allSameCards.add(sameVals);
        }
        return allSameCards;
    }

    public static boolean isSequence(PokerHand hand) {
        return isSequence(hand.getCards());
    }

    public static boolean isSequence(List<Card> cards) {
        boolean isSeq = false;
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards);
        CardValue previousCardValue = null;
        for (Card card: cards) {
            if (previousCardValue != null) {
                isSeq = card.getValue().follows(previousCardValue);
                if (!isSeq) {
                    break;
                }
            }
            previousCardValue = card.getValue();
        }
        return isSeq;
    }


    public int getValue() {
        return value;
    }

    public boolean isSameSuit() {
        return sameSuit;
    }

    public List<Integer> getCardsRepetitions() {
        return cardsRepetitions;
    }

    public boolean isSequenceValue() {
        return sequenceValue;
    }

    /**
     * Détermine si la combinaison courante est basée sur des valeurs de cartes répétées
     * @return
     */
    public boolean isSameValueBased() {
        return this.getCardsRepetitions() != null && !this.getCardsRepetitions().isEmpty();
    }


    public int compare(CombinationType candidate) {
        return this.value - candidate.getValue();
    }
}
