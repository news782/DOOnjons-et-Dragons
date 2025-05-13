package personnages.equipement;

public class Arme
{
    private String _nom;
    private int _degat;
    private int _porte;
    private int _faces;

    public Arme(String nom, int degat, int porte, int faces)
    {
        _nom = nom;
        _degat = degat;
        _porte = porte;
        _faces = faces;
    }

    public String get_nom()
    {
        return _nom;
    }

    public int get_degat()
    {
        return _degat;
    }

    public int get_faces()
    {
        return _faces;
    }

    public int get_porte()
    {
        return _porte;
    }
}
