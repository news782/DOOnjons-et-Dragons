package entite.Monstres;

import Des.Des;
import entite.Personnages.Joueur;
import interfacejeu.ContenuCase;
import interfacejeu.map;
import entite.Entite;

public class Monstre implements ContenuCase, Entite {
    private String m_espece;
    private int m_numero;
    private int m_pointDeVie;
    private int m_force;
    private int m_dexterite;
    private int m_initiative;
    private int m_classeArmure;
    private String m_typeAttaque;
    private int m_portee;
    private String m_degats;
    private int posX;
    private int posY;
    private String icone;
    private final int m_PvMax;

    public Monstre(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                   int classeArmure, String typeAttaque, int portee, String degats, String icone) {
        m_espece = espece;
        m_numero = numero;
        m_pointDeVie = pointDeVie;
        m_force = force;
        m_dexterite = dexterite;
        m_initiative = initiative;
        m_classeArmure = classeArmure;
        m_typeAttaque = typeAttaque;
        m_portee = portee;
        m_degats = degats;
        this.icone = icone;
        this.m_PvMax = pointDeVie;
    }

    public void attaquer(Joueur cible) {
        CombatResultat resultat = calculerAttaque(cible);
        afficherResultatAttaque(resultat, cible);
    }

    private CombatResultat calculerAttaque(Joueur cible) {
        int jetAttaque = Des.lancerDes("1d20");
        int modificateur = (getPortee() == 1) ? getForce() : getDexterite();
        jetAttaque += modificateur;
        int classeArmureCible = cible.getClasseArmureActuelle();

        boolean succes = jetAttaque > classeArmureCible;
        int degatsInfliges = 0;
        if (succes) {
            degatsInfliges = Des.lancerDes(getDegats());
            cible.addPdV(-degatsInfliges);
        }

        return new CombatResultat(jetAttaque, modificateur, succes, degatsInfliges, classeArmureCible);
    }

    private void afficherResultatAttaque(CombatResultat resultat, Joueur cible) {
        System.out.println(getEspece() + " n°" + getNumero() + " attaque " + cible.getNom() + " avec " + getTypeAttaque() + " !");
        System.out.println("Jet d'attaque : " + resultat.jetAttaque + " (modificateur : " + resultat.modificateur + ")");
        if (getPortee() == 1) {
            System.out.println("Attaque corps à corps.");
        } else {
            System.out.println("Attaque à distance.");
        }
        if (resultat.succes) {
            System.out.println("Attaque réussie !");
            System.out.println("Dégâts infligés : " + resultat.degatsInfliges);
            System.out.println(cible.getNom() + " PV restants : " + cible.getPointDeVie());
        } else {
            System.out.println("Attaque échouée !");
        }
    }

    private static class CombatResultat {
        int jetAttaque;
        int modificateur;
        boolean succes;
        int degatsInfliges;
        int classeArmureCible;

        public CombatResultat(int jetAttaque, int modificateur, boolean succes, int degatsInfliges, int classeArmureCible) {
            this.jetAttaque = jetAttaque;
            this.modificateur = modificateur;
            this.succes = succes;
            this.degatsInfliges = degatsInfliges;
            this.classeArmureCible = classeArmureCible;
        }
    }

    // --- Getters et Setters ---

    public int getPointDeVie() { return m_pointDeVie; }
    public int getPvDeBase() { return m_PvMax; }
    public String getDegats() { return m_degats; }
    public int getForce() { return m_force; }
    public int getPortee() { return m_portee; }
    public String getTypeAttaque() { return m_typeAttaque; }
    public String getEspece() { return m_espece; }
    public int getNumero() { return m_numero; }
    public int getDexterite() { return m_dexterite; }
    public int getClasseArmure() { return m_classeArmure; }
    public int getInitiative() { return m_initiative; }
    public boolean estMort() { return this.getPointDeVie() <= 0; }
    public int getPosX() { return this.posX; }
    public int getPosY() { return this.posY; }
    public String getIcone() { return icone; }
    public void setIcone(String ico) { icone = ico; }

    public int subirDegats(int degatsSubis) {
        if (degatsSubis < 0) throw new IllegalArgumentException("Les dégâts subis doivent être positifs");
        m_pointDeVie -= degatsSubis;
        if (m_pointDeVie < 0) m_pointDeVie = 0;
        return m_pointDeVie;
    }

    public void addPdV(int pv) { m_pointDeVie += pv; }

    public boolean setPosXY(int x, int y, map map) {
        if (map.isValidPositionAndFree(x, y)) {
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }

    public void setPosSansVerif(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    // --- Méthodes d'affichage ---

    @Override
    public String afficher() {
        return getIcone();
    }

    @Override
    public String getTypeContenu() {
        return "Monstre";
    }

    @Override
    public String affichageClass() {
        return getClass().toString();
    }

    @Override
    public String getAffichageCourt() {
        return afficher();
    }

    @Override
    public String getAffichageLong() {
        return getEspece() + " (" + getPointDeVie() + "/" + getPvDeBase() + " HP)";
    }

    @Override
    public String getNom() {
        return getEspece() + " n°" + getNumero();
    }

    @Override
    public String AfficherPVDB() {
        System.out.print(getPointDeVie() + "/" + getPvDeBase());
        return "";
    }

    @Override
    public void setPV(int degats) {
        this.addPdV(degats);
    }
}