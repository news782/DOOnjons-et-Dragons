import DD.Jeu;
import DD.MaitreDuJeu;

public class Main {
    public static void main(String args[]){
        System.out.println("Bienvenue dans DOOnjon et Dragons\n");

        Jeu jeu = new Jeu();
        jeu.setNombreJoueurs();
        jeu.creePersonnage();
        jeu.afficherPersonnages();

        MaitreDuJeu maitreDuJeu = new MaitreDuJeu();
        maitreDuJeu.creeDonjon();

        Jeu.lancerJeu(maitreDuJeu);
    }
}
