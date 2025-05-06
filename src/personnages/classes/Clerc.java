package personnages.classes;

import Utils.Util;
import personnages.Personnage;
import personnages.Races;
import java.util.Random;

public class Clerc implements Personnage
{
    private String _nom;
    private Races _race;
    private int _pv;
    private int _force;
    private int _dexterite;
    private int _vitesse;
    private int _initiative;
    //private ArrayList<Armes> _armes;
    //private ArrayList<Armure> _armures;

    public Clerc(String nom, Races race)
    {
        this._nom = nom;
        this._race = race;
        this._pv = 16 + Util.jeterDeDes(4,4) + 3;
        this._force = Util.getForcePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._dexterite = Util.getDexteritePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._vitesse = Util.getVitessePerRace(race) + Util.jeterDeDes(4,4) + 3;

    }

}
