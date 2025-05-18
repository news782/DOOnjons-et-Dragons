package donjon;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Personnage;
import java.util.ArrayList;

public class Donjon {
    private int largeur, hauteur;
    private Case[][] carte;
    private ArrayList<Personnage> personnages;
    private ArrayList<Monstre> monstres;
    private ArrayList<Equipement> equipements;
    private String description;

    public Donjon(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.carte = new Case[hauteur][largeur];
        this.personnages = new ArrayList<>();
        this.monstres = new ArrayList<>();
        this.equipements = new ArrayList<>();
        initialiserCarteVide();
    }

    private void initialiserCarteVide() {
        for(int y = 0; y < hauteur; y++) {
            for(int x = 0; x < largeur; x++){
                carte[y][x] = new Case(x,y,false);
            }
        }
    }

    public Case getCase(int x, int y) {
        if(x>=0 && x<largeur && y>=0 && y<hauteur){
            return carte[y][x];
        }
        return null;
    }

    public void ajouterObstacle(int x, int y) {
        Case c = getCase(x,y);
        if(c!=null) c.setobstacle(true);
    }

    public void ajouterMonstre(Monstre monstre, int x, int y) {
        monstres.add(monstre);
        getCase(x, y).setmonstre(monstre);
    }

    public void ajouterEquipement(Equipement equipement, int x, int y) {
        equipements.add(equipement);
        getCase(x, y).setequipement(equipement);
    }

    public void afficher() {
        System.out.print("    ");
        for (int x = 0; x < largeur; x++) {
            char colonne = (char) ('a' + x);
            System.out.print(colonne + "    ");
        }
        System.out.println();
        for (int y = 0; y < hauteur; y++) {
            System.out.printf("%2d  ", y + 1);
            for (int x = 0; x < largeur; x++) {
                System.out.print(carte[y][x].toString() + "   ");
            }
            System.out.println();
        }
    }

    public ArrayList<Personnage> getPersonnages() {return personnages;}
    public ArrayList<Monstre> getMonstres() { return monstres; }
    public ArrayList<Equipement> getEquipements() {return equipements;}
    public int getLargeur() {return largeur;}
}
