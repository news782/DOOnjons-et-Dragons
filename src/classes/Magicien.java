package classes;

import equipements.Equipement;
import equipements.GestionEq;
import entite.Personnages.Joueur;
import java.util.List;

public class Magicien extends Classe {
    public Magicien() {
        super("Magicien", 12);
    }

    @Override
    public void genererEquipementDeBase(Joueur joueur) {
        List<Equipement> equipementsDisponibles = GestionEq.initialiserEquipements();
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
}