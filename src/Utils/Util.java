package Utils;

import personnages.Races;

import java.util.Random;

public class Util
{
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

    public static int getVitessePerRace(Races race)
    {
        if(race == Races.HALFELINS || race == Races.HUMAINS)
        {
            return 2;
        }
        return 0;
    }
}
