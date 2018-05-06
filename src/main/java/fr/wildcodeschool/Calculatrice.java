package fr.wildcodeschool;
// lire le string en entrée pour détecter les symbole marthématiques
// on split la chaine
// on priorise les multi et divisions
// on retourne le résultat


public class Calculatrice {

    public double calcule (String operation){

        // split sur les + pour créer des morceaux d'additions

        String regAdd = "(\\+)";
        String regMinus = "([-])";
        String[] tabPourAddition = operation.split(regAdd);

        double resultat = 0;

        for (String addition : tabPourAddition) {
            // split les morceaux de soustraction
            // il faut garder le premier resultat en passant par une boucle avec index
            String[] tabPourSoustraction = addition.split(regMinus);

            for (int i = 0 ; i < tabPourSoustraction.length ; i++) {
                double resultSoustraction;
                if (i == 0) {
                    resultSoustraction = parseMultiplication(tabPourSoustraction[i]);
                    //creer un methode pour parser les multiplications et soustractions
                }
                else {
                    resultSoustraction = parseMultiplication(tabPourSoustraction[i]);
                    resultSoustraction -= resultSoustraction;
                }
            }
            resultat += resultat;
        }


        //\-


        return resultat;
    }


    public double parseMultiplication(String operation){
        return Double.parseDouble(operation);
    }

    public double parseDivision(String operation) {
        String[] division = operation.split("([/])");
        if (division.length == 1)
            return Double.parseDouble(division[0]);
        else
            return Double.parseDouble(operation);


    }


}
