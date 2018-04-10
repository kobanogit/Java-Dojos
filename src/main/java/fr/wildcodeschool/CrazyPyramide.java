package fr.wildcodeschool;

public class CrazyPyramide {
    String[] lignesPyramide;
    public String[] buildPyramide(int taille) {
        // si taille 1 nbLigne 3
        // taille 2 nbLigne 7  +4
        // taille 3 nbLigne 12  +5
        // taille 4 nbLigne 18  +6
        // taille n nbLigne
        int nbLignes = (taille *  (taille + 5)) / 2;
        lignesPyramide = new String[nbLignes];

        // Les étages du dessus restent identiques
        //la porte sera au n niveau du niveau n
        for(int i=0; i<nbLignes;i++){
            // appel methode qui dessine la ligne courante

        }


        return lignesPyramide;
    }
    public String buildLigne(int nbLigne, int numLigne){
        // Calcul du nombre d'espaces
        // selon le num. de lignes et le nb lignes total

        String sLigne="";
        //for (int i=0; i<nbLigne;i++){
        int nbEspaces = nbLigne - numLigne;
        int nbEtoile = numLigne+(numLigne-1); //calculer le nbEtoile en fonction du numero de ligne
        return sLigne;
    }

}
