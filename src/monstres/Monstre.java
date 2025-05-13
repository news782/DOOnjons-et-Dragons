package monstres;

public class Monstre {
    private String espece;
    private int numero; // utile s'il y a plusieurs monstres de la même espèce
    // Caractéristiques
    private int pointsDeVie;
    private int force;
    private int dexterite;
    private int classeArmure;
    private int initiative;
    // Attaque
    private int porteeAttaque;
    private int degatsAttaque;

    public Monstre(String espece, int numero, int pointsDeVie, int force, int dexterite,
                   int classeArmure, int initiative, int porteeAttaque, int degatsAttaque) {
        this.espece = espece;
        this.numero = numero;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.classeArmure = classeArmure;
        this.initiative = initiative;
        this.porteeAttaque = porteeAttaque;
        this.degatsAttaque = degatsAttaque;
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        System.out.println(getNomComplet() + " subit " + degats + " points de dégâts !");
    }

    public String getNomComplet() {
        return espece + " #" + numero;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getForce() {
        return force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public int getClasseArmure() {
        return classeArmure;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getPorteeAttaque() {
        return porteeAttaque;
    }

    public int getDegatsAttaque() {
        return degatsAttaque;
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}


