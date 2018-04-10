package fr.wildcodeschool;

import static java.lang.String.*;

public class FizzBuzz {

    /*Écrire un programme qui renvoie:

            1 - "fizz" dans le cas où le nombre saisi en paramètre de la fonction est un multiple de 3
            2 - "buzz" dans le cas où le nombre saisi en paramètre de la fonction est un multiple de 5
            3 - "fizzbuzz" dans le cas où le nombre saisi est à la fois un multiple de 3 et de 5
            4 - Le nombre dans le cas où ce dernier est ni un multiple de 3, ni un multiple de 5
    */

    public static String fizzbuzz(int nb) {
        String ret = "";
        if(nb % 15 == 0) {
            ret = "fizzbuzz";
        } else if (nb % 3 == 0) {
            ret = "fizz";
        } else if (nb % 5 == 0) {
            ret = "buzz";
        } else {
            ret = valueOf(nb);
        }
        return ret;
    }
}
