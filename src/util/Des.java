package util;

import java.util.Random;

public class Des {
    private static final Random random = new Random();

    public static int lancer(String de) {
        //Exemple de format de dé : "2d6" pour deux dés à six faces
        String[] parts = de.toLowerCase().split("d");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Format de dé invalide. Utilisez 'XdY' où X est le nombre de dés et Y le nombre de faces.");
        }

        int nbLancers = Integer.parseInt(parts[0]);
        int nbFaces = Integer.parseInt(parts[1]);
        int total = 0;
        for (int i = 0; i<nbLancers; i++) {
            total += random.nextInt(nbFaces) + 1; // de 1 à nbFaces inclus
        }
        return total;
    }
}
