package classes;

import equipements.Equipement;
import equipements.GestionEq;
import entite.Personnages.Joueur;

import java.util.List;

public class Roublard extends Classe {
    public Roublard() {
        super("Roublard", 16);
    }

    @Override
    public void genererEquipementDeBase(Joueur joueur) {
        List<Equipement> equipementsDisponibles = GestionEq.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Rapière") ||
                    equipement.getNom().equals("Arc court")) {
                joueur.ajouterEquipement(equipement);
            }
        }
    }
    @Override
    public String toString() {
        return "Classe Roublard: " + super.toString();
    }
}