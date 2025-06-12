package interfacejeu;

import entite.Entite;

import java.util.List;


public class BarreHaut {
    private static final String barre = "--------------------------------------------------------------------------------"; // 1

    /**
     * Affiche la barre supérieure du jeu avec les informations du joueur actif, du donjon, des participants et du tour.
     *
     * @param joueurActif  L'entité représentant le joueur actif.
     * @param donj         Le numéro du donjon actuel.
     * @param participants La liste des entités participantes.
     * @param tour         Le numéro du tour actuel.
     */
    public void Affichage(Entite joueurActif, int donj, List<Entite> participants, int tour) {
        System.out.println(barre);
        System.out.println("Donjon " + donj + ":");
        SAL(2);

        System.out.println(joueurActif.getAffichageLong());

        SAL(2);
        System.out.println(barre);
        System.out.println("Tour " + tour + ":");

        for (Entite obj : participants) {
            String prefixe = (obj == joueurActif) ? "-> " : "   ";
            System.out.println(prefixe + obj.getAffichageCourt() + "   " + obj.getAffichageLong());
        }



    }

    public void SAL(int nb){
        for (int n = 0; n<nb;n++) {
            System.out.println();
        }
    }
}
