package fr.wildcodeschool;

public class TableauEntier {
    /*Ecrire une fonction retourne le minimum et le maximum d’un tableau d’entier*/
    public int[] minmax(int[] tableau) {
        int[] result = {tableau[0], tableau[0]};
        int valeurCourante;
        for (int i = 0; i < tableau.length; i++) {
            valeurCourante = tableau[i];

            if (valeurCourante < result[0]) {
                result[0] = valeurCourante;
            }
            if (valeurCourante > result[1]) {
                result[1] = valeurCourante;
            }
        }
        return result;
    }

}
