package equipements;

public class Arme extends Equipement {
    private String degats;
    private int portee;
    private boolean estDistance;

    public Arme(String nom, String degats, int portee, boolean estDistance) {
        super(nom);
        this.degats=degats;
        this.portee=portee;
        this.estDistance=estDistance;
    }

    public String getDegats() {return degats;}
    public int getPortee() {return portee;}
    public boolean EstDistance() {return estDistance;}
}
