package donjon;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Personnage;
import java.util.ArrayList;

public class Donjon {
    private int m_largeur, m_hauteur;
    private Case[][] m_carte;
    private ArrayList<Personnage> m_personnages;
    private ArrayList<Monstre> m_monstres;
    private ArrayList<Equipement> m_equipements;
    private String description;

    public Donjon(int largeur, int hauteur) {
        this.m_largeur = largeur;
        this.m_hauteur = hauteur;
        this.m_carte = new Case[hauteur][largeur];
        this.m_personnages = new ArrayList<>();
        this.m_monstres = new ArrayList<>();
        this.m_equipements = new ArrayList<>();
        initialiserCarteVide();
    }

    private void initialiserCarteVide() {
        for(int y = 0; y < m_hauteur; y++) {
            for(int x = 0; x < m_largeur; x++){
                m_carte[y][x] = new Case(x,y,false);
            }
        }
    }

    public Case getCase(int x, int y) {
        if(x>=0 && x< m_largeur && y>=0 && y< m_hauteur){
            return m_carte[y][x];
        }
        return null;
    }

    public void ajouterObstacle(int x, int y) {
        Case c = getCase(x,y);
        if(c!=null) c.setobstacle(true);
    }

    public void ajouterMonstre(Monstre monstre, int x, int y) {
        m_monstres.add(monstre);
        getCase(x, y).setmonstre(monstre);
    }

    public void ajouterEquipement(Equipement equipement, int x, int y) {
        m_equipements.add(equipement);
        getCase(x, y).setequipement(equipement);
    }

    public void afficher() {
        System.out.print("    ");
        for (int x = 0; x < m_largeur; x++) {
            char colonne = (char) ('a' + x);
            System.out.print(colonne + "    ");
        }
        System.out.println();
        for (int y = 0; y < m_hauteur; y++) {
            System.out.printf("%2d  ", y + 1);
            for (int x = 0; x < m_largeur; x++) {
                System.out.print(m_carte[y][x].toString() + "   ");
            }
            System.out.println();
        }
    }

    public ArrayList<Personnage> getPersonnages() {return m_personnages;}

    public ArrayList<Monstre> getMonstres() { return m_monstres; }

    public ArrayList<Equipement> getEquipements() {return m_equipements;}

    public int getLargeur() {return m_largeur;}
}
