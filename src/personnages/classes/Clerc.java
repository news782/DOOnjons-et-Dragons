package personnages.classes;

import Utils.Util;
import personnages.*;
import personnages.Races;
import personnages.equipement.*;

import java.util.ArrayList;


public class Clerc implements Personnage
{
    private String _nom;
    private Races _race;
    private int _pv;
    private int _force;
    private int _dexterite;
    private int _vitesse;
    private int _initiative;
    private ArrayList<Arme> _armes;
    private ArrayList<Armure> _armures;
    private Arme _arme;
    private Armure _armure;

    public Clerc(String nom, Races race)
    {
        this._nom = nom;
        this._race = race;
        this._pv = 16 + Util.jeterDeDes(4,4) + 3;
        this._force = Util.getForcePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._dexterite = Util.getDexteritePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._vitesse = Util.getVitessePerRace(race) + Util.jeterDeDes(4,4) + 3;

        /* Ajouter dans les constructeurs les armes, armure et équipements*/
    }

}
