package Utils;

import personnages.Races;

import java.util.Random;

public class Util
{
    /***
     * @param nbr nombre de jets
     * @param faces nombre de faces des dés
     * @return le total des jets de dés
     */
    public static int jeterDeDes(int nbr, int faces)
    {
        int total = 0;
        int lancer = 0;

        for(int i = 0; i < nbr; i++)
        {
            lancer = new Random().nextInt(faces) + 1;
            //System.out.println("Vous avez eu " + lancer);
            total += lancer;
        }
        return total;
    }

    /***
     *
     * @param race la race du personnage
     * @return Le bonus de dexterité par rapport à sa Race
     */
    public static int getDexteritePerRace(Races race)
    {
        if(race == Races.ELFES)
        {
            return 6;
        }

        else if(race == Races.HALFELINS)
        {
            return 4;
        }

        else if(race == Races.HUMAINS)
        {
            return 2;
        }
        return 0;
    }


    /***
     *
     * @param race La race du personnage
     * @return Le bonus de Force par rapport à sa Race
     */
    public static int getForcePerRace(Races race)
    {
        if(race == Races.NAINS)
        {
            return 6;
        }

        else if(race == Races.HUMAINS)
        {
            return 2;
        }

        return 0;
    }


    /**
     *
     * @param race la Race du personnage
     * @return Le bonus de Vitesse par rapport à la Race du personnage
     */
    public static int getVitessePerRace(Races race)
    {
        if(race == Races.HALFELINS || race == Races.HUMAINS)
        {
            return 2;
        }
        return 0;
    }
}
