package Des;

import java.util.Random;

public class Des {
    private static Random m_random = new Random();

    private static int lancerDes(int nombreFaces, int nombreDes) {
        int resultat = 0;
        for (int i = 0; i < nombreDes; i++) {
            int lance = m_random.nextInt(nombreFaces) + 1;
            resultat += lance;
        }
        return resultat;
    }

    public static int lancerDes(String notation) {
        String[] parts = notation.split("d");
        int nombreDes = Integer.parseInt(parts[0]);
        int nombreFaces = Integer.parseInt(parts[1]);
        return lancerDes(nombreFaces, nombreDes);
    }
}
