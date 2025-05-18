package monstres;


public class Monstre {
    private String espece;
    private int numero;
    private String attaqueNom;
    private int porteeAttaque;
    private String degatsAttaque;
    private int pointsDeVie;
    private int force;
    private int dexterite;
    private int classeArmure;
    private int initiative;
    private int pdvMax;

    public Monstre(String espece, int numero, String attaqueNom, int porteeAttaque, String degatsAttaque,
                   int pointsDeVie, int force, int dexterite, int classeArmure, int initiative) {
        this.espece = espece;
        this.numero = numero;
        this.attaqueNom = attaqueNom;
        this.porteeAttaque = porteeAttaque;
        this.degatsAttaque = degatsAttaque;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.classeArmure = classeArmure;
        this.initiative = initiative;
        this.pdvMax = pointsDeVie;
    }

    public String getNom() {return espece + " " + numero;}

    public String getEspece() {return espece;}

    public int getNumero() {return numero;}

    public String getAttaqueNom() {return attaqueNom;}

    public int getPorteeAttaque() {return porteeAttaque;}

    public String getDegatsAttaque() {return degatsAttaque;}

    public int getPointsDeVie() {return pointsDeVie;}

    public int getForce() {return force;}

    public int getDexterite() {return dexterite;}

    public int getClasseArmure() {return classeArmure;}

    public int getInitiative() {return initiative;}

    public int getPointsDeVieMax(){return pdvMax;}
    //string getPointsDeVieMax à implémenter

}


