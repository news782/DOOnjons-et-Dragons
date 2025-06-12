package classes;

import equipements.Equipement;
import equipements.Gestion;
import entite.Personnages.Joueur;

import java.util.List;

public class Roublard extends Classe {
    public Roublard() {
        super("Roublard", 16);
    }

    @Override
    public void EquipementClasse(Joueur joueur) {
        List<Equipement> equipementsDisponibles = Gestion.initialiserEquipements();
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