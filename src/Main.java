import Utils.Util;
import personnages.Races;
import personnages.classes.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bonjour et bienvenue dans le jeu DOOngeon & Dragons !\nPour commencer, veuillez indiquer le nombre de joueur (min 2) : ");
        if(!initGame(sc.nextInt()));
        {
            System.out.println("Une erreur est survenu lors de la création des personnages !");
            System.exit(0);
        }

    }


    public static boolean initGame(int nbrJoueur) {
        Scanner sc = new Scanner(System.in);

        if (nbrJoueur < 2) {
            System.out.println("Le nombre de joueurs doit être supérieur à 2 !");
            return false;
        }

        //Instancier le maitre du jeu

        for (int i = 1; i < nbrJoueur; i++) {
            System.out.println("Joueur " + i + ":");

            System.out.println("Entrez votre pseudo : ");
            String nom = sc.nextLine();


        }

        return true;
    }
}