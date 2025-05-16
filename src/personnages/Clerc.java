package personnages;

import equipements.Arme;
import equipements.Armure;
import equipements.Equipement;
import java.util.ArrayList;
import java.util.List;

public class Clerc extends Classe {
    public Clerc() {
        super("Clerc", 16, new ArrayList<Equipement>(List.of
                (new Armure("Armure d'écailles", 9, true),
                new Arme("Masse d'armes", "1d6", 1, false),
                new Arme("Arbalète légère", "1d8", 16, true)
        )));
    }
}
