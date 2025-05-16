package personnages;

import equipements.Equipement;
import java.util.ArrayList;

public abstract class Classe {
    private String nom;
    private int pointsDeVie;
    private ArrayList<Equipement> equipement;

    public Classe(String nom, int pointsDeVie, ArrayList<Equipement> equipement) {
        this.nom=nom;
        this.pointsDeVie=pointsDeVie;
        this.equipement=equipement;
    }

    public String getNom() {return nom;}
    public int getPointsDeVie() {return pointsDeVie;}
    public ArrayList<Equipement> getEquipement() {return equipement;}


}
