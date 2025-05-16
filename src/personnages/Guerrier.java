package personnages;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;

import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Classe {
    public Guerrier() {
        super("Guerrier", 20, new ArrayList<Equipement>(List.of(
                new Armure("Cotte de mailles", 11, false),
                new Arme("Épée longue", "1d8", 1, false),
                new Arme("Arbalète légère", "1d8", 16, true)
        )));
    }
}