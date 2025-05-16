package DD;

import donjon.*;
import equipements.*;
import monstres.*;
import personnages.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    Scanner sc = new Scanner(System.in);
    int nombreJoueurs;
    ArrayList<Personnage> personnages;

    public void setNombreJoueurs(){
        System.out.print("Saisir le nombre de joueurs : ");
        nombreJoueurs = sc.nextInt();
        System.out.print("\n");
        while(nombreJoueurs<2) {
            System.out.print("Il faut être au moins 2 pour jouer. Veuillez réessayer : ");
            nombreJoueurs = sc.nextInt();
            System.out.print("\n");
        }
    }

    public void creePersonnage() {
        personnages = new ArrayList<>();
        for (int i = 0; i < nombreJoueurs; i++) {
            System.out.print("Saisir le nom du joueur " + (i + 1) + ": ");
            String nom = sc.next();
            System.out.print("\n");
            System.out.println("1. Humain");
            System.out.println("2. Nain");
            System.out.println("3. Elfe");
            System.out.println("4. Halfelin");
            System.out.print("Saisir la Race du personnage: ");
            int race = sc.nextInt();
            System.out.print("\n");
            System.out.println("1. Guerrier");
            System.out.println("2. Clerc");
            System.out.println("3. Magicien");
            System.out.println("4. Roublard");
            System.out.print("Saisir la classe du personnage: ");
            int classe = sc.nextInt();
            System.out.print("\n");
            Personnage personnage = new Personnage(nom, race, classe);
            personnages.add(personnage);
        }
    }

    public void lancerTourParTour(List<Personnage> personnages) {
        for (int i = 0; i < personnages.size() - 1; i++) {
            for (int j = 0; j < personnages.size() - i - 1; j++) {
                if (personnages.get(j).getInitiative() < personnages.get(j + 1).getInitiative()) {
                    Personnage tmp = personnages.get(j);
                    personnages.set(j, personnages.get(j + 1));
                    personnages.set(j + 1, tmp);
                }
            }
        }
        boolean partieEnCours = true;
        while (partieEnCours) {
            for (Personnage p : personnages) {
                if(p.getPointsDeVie() <= 0) {
                    System.out.println("\nFin de partie : 1 des personnages est morts");
                    break;
                }
                System.out.println("-----");
                System.out.println("Au tour de " + p.getNom());
                // À compléter : actions du joueur (attaquer, se déplacer, etc.)
            }
            // À compléter : conditions de victoire/défaite
            partieEnCours = false; // Pour l'exemple, on arrête après un tour
        }
    }

    public void afficherPersonnages() {
        for (Personnage personnage : personnages) {
            System.out.println("Nom: " + personnage.getNom());
            System.out.println("Race: " + personnage.getRace().getNom());
            System.out.println("Classe: " + personnage.getClasse().getNom());
            System.out.println("Points de vie: " + personnage.getClasse().getPointsDeVie());
            System.out.println("Inventaire: ");
            for(int i=0; i<personnage.getInventaire().size(); i++){
                System.out.println(" - " + personnage.getInventaire().get(i).getNom());
            }
            System.out.print("\n");
        }
    }

    public static void lancerJeu(MaitreDuJeu maitreDuJeu) {
        System.out.println("Lancement du jeu...");

        // Récupérer la liste des donjons
        ArrayList<Donjon> donjons = maitreDuJeu.getDonjons();

        // Pour chaque tour afficher ca :
        // '-' fois la largeur du donjon
        // Donjon i
        // Tour i : Au Tour de <nom du personnage>
        // '-' fois la largeur du donjon
        // \n
        // ->  J1 Joueur1 (Race, Classe, PVActuels/PvDeBase)
        //     J2 Joueur2 (Race, Classe, PVActuels/PvDeBase)
        //     M1 Monstre1 (PVActuels/PvDeBase)
        //     M2 Monstre2 (PVActuels/PvDeBase)
        //     E1 Equipement1 (Nomdel'Equipement)
        //     E2 Equipement2 (Nomdel'Equipement)
        // \n
        // La carte du donjon
        // \n
        // nom du personnage a qui c'est le tour
        // Vie du personnage
        // Armure
        // Arme
        // Inventaire :
        // Force
        // Dextérité
        // Vitesse
        // \n
        // <Nom du personnage> : Il vous reste x action Que voulez-vous faire ?
        //   - attaquer (att <Case>)
        //  - se déplacer (dep <Case>)
        //  - s'équiper (equ <numero equipement>)

        for(Donjon donjon : donjons) {
            System.out.println("-".repeat(donjon.getLargeur()));
            System.out.println("Donjon " + (donjons.indexOf(donjon) + 1));
            System.out.println("Tour " + (donjons.indexOf(donjon) + 1) + ":");
            System.out.println("-".repeat(donjon.getLargeur()));

            // Afficher les personnages
            for (Personnage personnage : donjon.getPersonnages()) {
                System.out.println(personnage.getNom() + " (" + personnage.getRace().getNom() + ", " +
                        personnage.getClasse().getNom() + ", " +
                        personnage.getPointsDeVie() + "/" +
                        personnage.getClasse().getPointsDeVie() + ")");
            }

            // Afficher les monstres
            for (Monstre monstre : donjon.getMonstres()) {
                System.out.println(monstre.getNom() + " (" +
                        monstre.getPointsDeVie() + "/" +
                        monstre.getPointsDeVieMax() + ")");
            }

            // Afficher les équipements
            for (Equipement equipement : donjon.getEquipements()) {
                System.out.println(equipement.getNom());
            }

            donjon.afficher();
        }
    }


}
