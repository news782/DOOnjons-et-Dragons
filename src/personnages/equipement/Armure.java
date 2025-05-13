package personnages.equipement;

public class Armure
{
    private String _nom;
    private int _classe;

    public Armure(String nom, int classe)
    {
        _nom = nom;
        _classe = classe;
    }

    public String get_nom()
    {
        return _nom;
    }

    private int get_classe()
    {
        return _classe;
    }
}
