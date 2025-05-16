package personnages;

import equipements.Arme;
import equipements.Equipement;

import java.util.ArrayList;
import java.util.List;

public class Magicien extends Classe {
    public Magicien() {
        super("Magicien", 12, new ArrayList<Equipement>(List.of(
                new Arme("Bâton", "1d6", 1, false),
                new Arme("Fronde", "1d4", 6, true)
        )));
    }
}