package fr.wildcodeschool.poker;

import java.util.Comparator;
import java.util.List;

public class CardsListSizeComparator implements Comparator<List<Card>> {
    @Override
    public int compare(List<Card> cards1, List<Card> cards2) {
        return cards1.size() - cards2.size();
    }
}
