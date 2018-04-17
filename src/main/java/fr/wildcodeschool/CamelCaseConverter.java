package fr.wildcodeschool;


import java.util.ArrayList;
import java.util.List;

/*
Complete the method/function so that it converts dash/underscore
 delimited words into camel casing.
 The first word within the output should be capitalized only if
 the original word was capitalized.

Examples:

// returns "theStealthWarrior"
toCamelCase("the-stealth-warrior")

// returns "TheStealthWarrior"
toCamelCase("The_Stealth_Warrior")
 */
public class CamelCaseConverter {

    public String toCamelCase(String initialWord){

        // split initialWord en substrings
        String [] splitInitialWord = initialWord.split("-|_", 0);
        //splitInitialWord = initialWord.split("_", 0);
        // iterate on substrings
        // for each but the first, convert first char in uppercase
        //
        String result = "";

        for (String currentWord : splitInitialWord){
            if (splitInitialWord[0]!=currentWord) {
                result += capitalize(currentWord);
            }else {
                char premiereLettre = currentWord.charAt(0);
                String reste = currentWord.substring(1).toLowerCase();
                result = premiereLettre + reste;
            }

        }


        return result;
    }

    public String capitalize(String word){
        // Convertir le 1er charactère
        char convertit = Character.toUpperCase(word.charAt(0));
        // Concatener la suite
        String reste = word.substring(1);

        return "" + convertit + reste.toLowerCase();
    }
}
