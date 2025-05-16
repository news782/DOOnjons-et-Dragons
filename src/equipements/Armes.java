package equipements;

import java.util.Arrays;
import java.util.List;

public class Armes {
    public static final Arme Baton = new Arme("Baton", "1d6", 1, false);
    public static final Arme Masse_D_Arme = new Arme("Masse d'armes", "1d6", 1, false);
    public static final Arme Epee_Longue = new Arme("Epée Longue", "1d8", 1, false);
    public static final Arme Rapiere = new Arme("Rapière", "1d8", 1, false);
    public static final Arme Arbalete_legere = new Arme("Arbalète légère", "1d8", 16, true);
    public static final Arme Fronde = new Arme("Fronde", "1d4", 6, true);
    public static final Arme Arc_Court = new Arme("Arc court", "1d6", 16, true);

    public static List<Arme> getToutesLesArmes() {
        return Arrays.asList(Baton, Masse_D_Arme, Epee_Longue, Rapiere, Arbalete_legere, Fronde, Arc_Court);
    }
}
