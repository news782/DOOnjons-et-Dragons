package classes;

import java.util.List;
import equipements.Equipement;
import equipements.Gestion;
import entite.Personnages.Joueur;

public class Clerc extends Classe{

    public Clerc() {
        super("Clerc", 16);
    }

    @Override
    public void EquipementClasse(Joueur joueur) {
        List<Equipement> equipementsDisponibles = Gestion.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Masse d'armes") ||
                    equipement.getNom().equals("Armure d'écailles") ||
                    equipement.getNom().equals("Arbalète légère")) {
                joueur.ajouterEquipement(equipement);
            }
        }
    }
}
