package equipements;

import java.util.Arrays;
import java.util.List;

public class Armures {
    public static final Armure Armure_Ecailles = new Armure("Armure d'écailles", 9, true);
    public static final Armure Demi_Plate = new Armure("Demi-plate", 10, true);
    public static final Armure Cotte_Maille = new Armure("Cotte de mailles", 11, false);
    public static final Armure Harnois = new Armure("Harnois", 12, false);

    public static List<Armure> getToutesLesArmures() {
        return Arrays.asList(Armure_Ecailles, Demi_Plate, Cotte_Maille, Harnois);
    }
}
