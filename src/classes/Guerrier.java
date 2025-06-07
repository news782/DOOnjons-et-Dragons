package classes;

import equipements.Equipement;
import equipements.GestionEq;
import entite.Personnages.Joueur;
import java.util.List;

public class Guerrier extends Classe {
    public Guerrier() {
        super("Guerrier", 20);
    }

    @Override
    public void genererEquipementDeBase(Joueur joueur) {
        List<Equipement> equipementsDisponibles = GestionEq.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Cotte de mailles") ||
                    equipement.getNom().equals("Épée longue") ||
                    equipement.getNom().equals("Arbalète légère")) {
                joueur.ajouterEquipement(equipement);
            }
        }
    }
    @Override
    public String toString() {
        return "Classe Guerrier: " + super.toString();
    }

}
