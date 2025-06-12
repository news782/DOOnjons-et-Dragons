package classes;

import Sort.BoogieWoogie;
import entite.Entite;
import equipements.Equipement;
import equipements.Gestion;
import entite.Personnages.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magicien extends Classe {
    public Magicien() {
        super("Magicien", 12);
    }

    @Override
    public void EquipementClasse(Joueur joueur) {
        List<Equipement> equipementsDisponibles = Gestion.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Bâton") ||
                    equipement.getNom().equals("Fronde")){
                joueur.ajouterEquipement(equipement);
            }
        }
    }
    @Override
    public String toString() {
        return "Classe Magicien: " + super.toString();
    }

    @Override
    public boolean Boogie(Scanner scanner, Joueur joueur, ArrayList<Entite> participants) {
        System.out.println("Cibles disponibles pour Bougie-Woogie :");
        for (int i = 0; i < participants.size(); i++) {
            System.out.println((i + 1) + " - " + participants.get(i).getNom());
        }

        System.out.print("Entrez le numéro de la première cible à échanger : ");
        try {
            int choix1 = Integer.parseInt(scanner.nextLine()) - 1;
            if (choix1 < 0 || choix1 >= participants.size()) {
                System.out.println("Numéro invalide.");
                return false;
            }
            Entite cible1 = participants.get(choix1);

            System.out.print("Entrez le numéro de la deuxième cible à échanger : ");
            int choix2 = Integer.parseInt(scanner.nextLine()) - 1;
            if (choix2 < 0 || choix2 >= participants.size()) {
                System.out.println("Numéro invalide.");
                return false;
            }
            Entite cible2 = participants.get(choix2);

            BoogieWoogie sort = new BoogieWoogie();
            sort.utilisermap(cible1, cible2);
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide.");
        }

        return true;
    }
}