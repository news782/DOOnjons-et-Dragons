package personnages;

import equipements.Equipement;
import java.util.ArrayList;


public class Personnage {
    private String nom;
    private Race race;
    private Classe classe;
    private ArrayList<Equipement> inventaire;
    private int force;
    private int dexterite;
    private int vitesse;
    private int initiative;
    private int pointsDeVie;

    public Personnage(String nom, int race, int classe) {
        this.nom=nom;
        this.race=intEnRace(race);
        this.classe=intEnClasse(classe);
        ajouterEquipementClasse();
        this.force=quatredequatre() + bonusForce(this.race);
        this.dexterite=quatredequatre() + bonusDexterite(this.race);
        this.vitesse=quatredequatre() + bonusVitesse(this.race);
        this.initiative=quatredequatre() + bonusInitiative(this.race);
        this.pointsDeVie=quatredequatre() + this.classe.getPointsDeVie();
    }

    private int quatredequatre() {
        int total = 0;
        for(int i = 0; i<4; i++) {
            total += (int)(Math.random() * 4) + 1;
        }
        return total + 3;
    }

    private int bonusForce(Race race) {
        if (race.getNom().equalsIgnoreCase("Nain")) return 6;
        if (race.getNom().equalsIgnoreCase("Humain")) return 2;
        return 0;
    }

    private int bonusDexterite(Race race) {
        if (race.getNom().equalsIgnoreCase("Elfe")) return 6;
        if (race.getNom().equalsIgnoreCase("Halfelin")) return 4;
        if (race.getNom().equalsIgnoreCase("Humain")) return 2;
        return 0;
    }

    private int bonusVitesse(Race race) {
        if (race.getNom().equalsIgnoreCase("Halfelin")) return 2;
        if (race.getNom().equalsIgnoreCase("Humain")) return 2;
        return 0;
    }

    private int bonusInitiative(Race race) {
        if (race.getNom().equalsIgnoreCase("Humain")) return 2;
        return 0;
    }

    private Race intEnRace(int race) {
        switch(race) {
            case 1:
                return new Race("Humain");
            case 2:
                return new Race("Elfe");
            case 3:
                return new Race("Nain");
            case 4:
                return new Race("Halfelin");
            default :
                throw new IllegalArgumentException("Erreur : race invalide");
        }
    }

    private Classe intEnClasse(int classe) {
        switch (classe) {
            case 1:
                return new Guerrier();
            case 2:
                return new Clerc();
            case 3:
                return new Magicien();
            case 4:
                return new Roublard();
            default:
                throw new IllegalArgumentException("Erreur : Classe invalide.");
        }
    }

    private void ajouterEquipementClasse() {
        inventaire = new ArrayList<>();
        for (Equipement equipement : classe.getEquipement()) {
            inventaire.add(equipement);
        }
    }

    public void afficherCaracteristiques() {
        System.out.println("Nom : " + nom);
        System.out.println("Race : " + race.getNom());
        System.out.println("Classe : " + classe.getNom());
        System.out.println("Points de vie : " + classe.getPointsDeVie());
        System.out.println("Force : " + force);
        System.out.println("Dextérité : " + dexterite);
        System.out.println("Vitesse : " + vitesse);
        System.out.println("Initiative : " + initiative);
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie=pointsDeVie;
    }

    public void perdrePointsDeVie(int perte) {
        this.pointsDeVie -= perte;
        if(this.pointsDeVie<0) this.pointsDeVie=0;
    }

    public String getNom() {return nom;}
    public Race getRace() {return race;}
    public Classe getClasse() {return classe;}
    public int getPointsDeVie() {return pointsDeVie;}
    public ArrayList<Equipement> getInventaire() {return inventaire;}
    public int getInitiative() {return initiative;}
    public int getForce() {return force;}
    public int getVitesse() {return vitesse;}
    public int getDexterite() {return dexterite;}

}
