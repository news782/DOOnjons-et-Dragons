package classes;

import entite.Entite;
import entite.Personnages.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Classe {
    private String m_nom;
    private int m_pvMax;

    public Classe(String nom, int pvDeBase) {
        this.m_nom = nom;
        this.m_pvMax = pvDeBase;
    }

    public boolean utiliserBoogieWoogie(Scanner scanner, Joueur joueur, ArrayList<Entite> participants)
    {
        return false;
    }

    public abstract void genererEquipementDeBase(Joueur joueur);

    public String getNom() {
        return m_nom;
    }

    public int getPvDeBase() {
        return m_pvMax;
    }


    @Override
    public String toString() {
        return "Classe: " + m_nom + ", PV de base : " + m_pvMax;
    }
}
