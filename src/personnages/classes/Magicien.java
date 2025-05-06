package personnages.classes;

import Utils.Util;
import personnages.Races;

public class Magicien
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
    //private equipement ?

    public Magicien(String nom, Races race)
    {
        this._nom = nom;
        this._race = race;
        this._pv = 12 + Util.jeterDeDes(4,4) + 3;
        this._force = Util.getForcePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._dexterite = Util.getDexteritePerRace(race) + Util.jeterDeDes(4,4) + 3;
        this._vitesse = Util.getVitessePerRace(race) + Util.jeterDeDes(4,4) + 3;

        /* Ajouter dans les constructeurs les armes, armure et équipements*/
    }
}
