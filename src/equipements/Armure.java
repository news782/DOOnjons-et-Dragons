package equipements;

public class Armure extends Equipement{
    private int classeArmure;
    private boolean estLegere;

    public Armure(String nom, int classeArmure, boolean estLegere) {
        super(nom);
        this.classeArmure=classeArmure;
        this.estLegere=estLegere;
    }

    public int getClasseArmure() {return classeArmure;}
    public boolean EstLegere() {return estLegere;}
}
