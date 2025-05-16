package equipements;

public abstract class Equipement {
    private String nom;

    public Equipement(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
