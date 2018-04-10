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


    char[] charRef = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public char checkMissingLetter(char[] suiteDeLettre){
        //recup indice de la 1ere lettre du param dans le CherRef
        //parcour de suite de lettres (param)
        //compare   la val suite de lettre indice I avec valeur de Char Ref indice J
        // si Val[i] = Val[j] on incremente I et J
        // sinon val[i] != val[j], on la lettre manquante
        // return val[i]
        char premiereLettreATester = suiteDeLettre[0];
        int indice1erLettre = -1;
        /*
        for(int k = 0; k < charRef.length; k++) {
            char lettreRefCourante = charRef[k];
            if (lettreRefCourante ==  premiereLettreATester) {
                indice1erLettre = k;
                break; //sort immediatement de la boucle for
            }
        } */
        indice1erLettre = charRef.toString().indexOf(premiereLettreATester);

        for (int j = indice1erLettre, i =0; j < charRef.length - 1; j++, i++) {
            //char lettreCouranteDans
        }
        return 'a';
    }
    public char checkMissingLetterBis(char[] suiteDeLettre) {
        boolean lettreEgale = true;
        char lettreManquante = '0';
        for (int i = 0; i < suiteDeLettre.length - 1 && lettreEgale ; i++) {

            if ((int) suiteDeLettre[i] + 1 != (int) suiteDeLettre[i + 1]) {
                lettreManquante = (char) (suiteDeLettre[i] + 1);
                lettreEgale = false;
            }
        }
        return lettreManquante;
    }

}
