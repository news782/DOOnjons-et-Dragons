package donjon;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Personnage;

public class Case {
    private int m_x,m_y;
    private boolean m_obstacle;
    private Monstre m_monstre;
    private Equipement m_equipement;
    private Personnage m_joueur;

    public Case(int x, int y, boolean obstacle) {
        this.m_x=x;
        this.m_y=y;
        this.m_obstacle =obstacle;
    }

    public boolean estLibre() {return !m_obstacle && m_monstre ==null;}
    public void setobstacle(boolean obstacle) {this.m_obstacle = obstacle;}
    public void setmonstre(Monstre monstre) {this.m_monstre = monstre;}
    public void setJoueur(Personnage joueur) {this.m_joueur =joueur;}
    public void setequipement(Equipement equipement) {this.m_equipement = equipement;}
    public Personnage getJoueur(Personnage joueur) {return joueur;}
    public Monstre getMonstre(Monstre monstre) {return  monstre;}

    @Override
    public String toString() {
        if (m_obstacle) {return "# ";}         // Obstacle présent
        if (m_monstre != null) {return "M ";}     // Monstre présent
        if (m_equipement != null) {return "E ";}  // Équipement présent
        if (m_joueur != null) {return "J ";}      // Joueur présent
        return ". ";                            // Case vide
    }
}
