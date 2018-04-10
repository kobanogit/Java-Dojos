package fr.wildcodeschool;

public class MissingLetter {

    /*Missing letter:
#Find the missing letter

Write a method that takes an array of consecutive (increasing) letters as input
and that returns the missing letter in the array.

You will always get an valid array. And it will be always exactly one letter be missing.
The length of the array will always be at least 2.
The array will always contain letters in only one case.

Example:

['a','b','c','d','f'] -> 'e'
['O','Q','R','S'] -> 'P'
(Use the English alphabet with 26 letters!)*/


    public String alphabet ="abcdefghijklmnopqrstuvwxyz";

    /**
     * Renvoie la lettre manquante d'une suite par comparaison avec l'ordre alphabétique
     * @param suiteDeLettre
     * @return
     */
    public char checkMissingLetter(char[] suiteDeLettre){
        String alphabetComplet = alphabet + alphabet.toUpperCase();
        char[] charRef = (alphabetComplet).toCharArray();

        char premiereLettreATester = suiteDeLettre[0];
        int indice1erLettre = alphabetComplet.indexOf(premiereLettreATester);


        for (int j = indice1erLettre, i = 0; i < suiteDeLettre.length; j++, i++) {
            //comparer les deux valeurs
            if (charRef[j] != suiteDeLettre[i]){
                return charRef[j];
            }
        }
        return '0';
    }


    /**
     * Renvoie la première lettre manquante d'une suite en se basant sur son code ASCII
     * @param suiteDeLettre Suite de lettres à tester
     * @return Lettre manquante
     */
    public char checkMissingLetterBis(char[] suiteDeLettre) {
        boolean lettreEgale = true;
        char lettreManquante = '0';
        //on utilise la valeur ascii de la lettre pour trouver la lettre manquante
        for (int i = 0; i < suiteDeLettre.length - 1 && lettreEgale ; i++) {
            if ((int) suiteDeLettre[i] + 1 != (int) suiteDeLettre[i + 1]) {
                lettreManquante = (char) (suiteDeLettre[i] + 1);
                lettreEgale = false;
            }
        }
        return lettreManquante;
    }

}
