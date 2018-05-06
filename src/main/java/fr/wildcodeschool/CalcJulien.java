package fr.wildcodeschool;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class CalcJulien {


    public double calcule(String operation) {

        List<String> additionParts = Arrays.asList(operation.split("([+])"));
        ListIterator addIterator = additionParts.listIterator();

        while(addIterator.hasNext()) {
            List<String> substractionParts = Arrays.asList(String.valueOf(addIterator.next()).split("([-])"));
            ListIterator subIterator = substractionParts.listIterator();

            while (subIterator.hasNext()) {
                List<String> multiplicationParts = Arrays.asList(String.valueOf(subIterator.next()).split("([*])"));
                ListIterator multIterator = multiplicationParts.listIterator();

                while (multIterator.hasNext()) {
                    List<String> divisionParts = Arrays.asList((String.valueOf(multIterator.next()).split("([/])")));
                    multIterator.set(String.valueOf(solveDivisions(divisionParts)));
                }
                subIterator.set(String.valueOf(solveMultiplications(multiplicationParts)));
            }
            addIterator.set(String.valueOf(solveSubstractions(substractionParts)));
        }
        return solveAdditions(additionParts);
    }


    private double solveAdditions(List<String> terms) {
        ListIterator iterator = terms.listIterator();
        double premierTerme = Double.parseDouble(String.valueOf(iterator.next()));
        while(iterator.hasNext()) {
            premierTerme += Double.parseDouble(String.valueOf(iterator.next()));
        }
        return premierTerme;
    }

    private double solveSubstractions(List<String> terms) {
        ListIterator iterator = terms.listIterator();
        double premierTerme = Double.parseDouble(String.valueOf(iterator.next()));
        while(iterator.hasNext()) {
            premierTerme -= Double.parseDouble(String.valueOf(iterator.next()));
        }
        return premierTerme;
    }

    private double solveMultiplications(List<String> terms) {
        ListIterator iterator = terms.listIterator();
        double premierTerme = Double.parseDouble(String.valueOf(iterator.next()));
        while(iterator.hasNext()) {
            premierTerme *= Double.parseDouble(String.valueOf(iterator.next()));
        }
        return premierTerme;
    }

    private double solveDivisions(List<String> terms) {
        ListIterator iterator = terms.listIterator();
        double premierTerme = Double.parseDouble(String.valueOf(iterator.next()));
        while(iterator.hasNext()) {
            premierTerme /= Double.parseDouble(String.valueOf(iterator.next()));
        }
        return premierTerme;
    }

    /*

    private double additionner(double premierTerme, double deuxiemeTerme) {
        return premierTerme + deuxiemeTerme;
    }

    private double soustraire(double premierTerme, double deuxiemeTerme) {
        return premierTerme - deuxiemeTerme;
    }

    private double multiplier(double premierTerme, double deuxiemeTerme) {
        return premierTerme * deuxiemeTerme;
    }

    private double diviser(double premierTerme, double deuxiemeTerme) {
        return premierTerme / deuxiemeTerme;
    }

    */


}
