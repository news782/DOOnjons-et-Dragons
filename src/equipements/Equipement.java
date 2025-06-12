package equipements;

import interfacejeu.ContenuCase;

public interface Equipement  extends ContenuCase {
    int getEnchante();
    void setEnchante(int enchante);
    String getNom();
    String getType();
    int getVitesseArme();
    int getForceArme();
    int getPortee();
    String getDegats();
    int getClasseArmure();
    boolean estArme();
    boolean estArmure();

}