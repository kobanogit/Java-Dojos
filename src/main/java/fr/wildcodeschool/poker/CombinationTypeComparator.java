package fr.wildcodeschool.poker;

import java.util.Comparator;

public class CombinationTypeComparator implements Comparator<CombinationType> {
    @Override
    public int compare(CombinationType c1, CombinationType c2) {
        return c1.getValue() - c2.getValue();
    }
}
