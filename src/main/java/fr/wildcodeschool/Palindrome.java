package fr.wildcodeschool;
/*
Ecrire une fonction qui teste si une chaîne est un palindrome.
Un palindrome est un mot ou une phrase que l’on peut lire dans les deux sens.Ex: ABBA, kayak

 */
public class Palindrome {
    public boolean isPalindrome(String word){
        char[] wordArray = word.toLowerCase().toCharArray();

        for (int i = 0 , j = wordArray.length-1 ; i <= wordArray.length/2 ; i++ , j-- ){
            if(wordArray[i]!=wordArray[j]){
                return false;
            }

        }
        return true;
    }
}
