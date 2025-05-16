package personnages;

import equipements.Arme;
import equipements.Equipement;

import java.util.ArrayList;
import java.util.List;

public class Roublard extends Classe {
    public Roublard() {
        super("Roublard", 16, new ArrayList<Equipement>(List.of(
                new Arme("Rapière", "1d8", 1, false),
                new Arme("Arc court", "1d6", 16, true)
        )));
    }
}