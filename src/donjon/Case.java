package donjon;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Personnage;

public class Case {
    private int x,y;
    private boolean obstacle;
    private Monstre monstre;
    private Equipement equipement;
    private Personnage joueur;

    public Case(int x, int y, boolean obstacle) {
        this.x=x;
        this.y=y;
        this.obstacle=obstacle;
    }

    public boolean estLibre() {return !obstacle && monstre==null;}
    public void setObstacle(boolean obstacle) {this.obstacle=obstacle;}
    public void setMonstre(Monstre monstre) {this.monstre=monstre;}
    public void setJoueur(Personnage joueur) {this.joueur=joueur;}
    public void setEquipement(Equipement equipement) {this.equipement=equipement;}
    public Personnage getJoueur(Personnage joueur) {return joueur;}
    public Monstre getMonstre(Monstre monstre) {return  monstre;}

    @Override
    public String toString() {
        if (obstacle) {return "# ";}         // Obstacle présent
        if (monstre != null) {return "M ";}     // Monstre présent
        if (equipement != null) {return "E ";}  // Équipement présent
        if (joueur != null) {return "J ";}      // Joueur présent
        return ". ";                            // Case vide
    }
}
