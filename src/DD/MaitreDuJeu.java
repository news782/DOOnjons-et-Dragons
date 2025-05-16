package DD;

import donjon.Donjon;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Personnage;
import static equipements.Armes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MaitreDuJeu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Donjon> m_donjons;

    public MaitreDuJeu() {
        m_donjons = new ArrayList<>();
    }

    public void creeDonjon() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Création du donjon " + (i + 1) + ":");

            System.out.print("Saisir la largeur du donjon: ");
            int largeur = scanner.nextInt();

            System.out.print("Saisir la hauteur du donjon: ");
            int hauteur = scanner.nextInt();
            scanner.nextLine(); // vider le \n

            if (largeur < 15 || hauteur < 15 || largeur > 25 || hauteur > 25) {
                System.out.println("La largeur et la hauteur doivent être comprises entre 15 et 25.");
                i--;
                continue;
            }

            Donjon donjon = new Donjon(largeur, hauteur);
            m_donjons.add(donjon);
            System.out.println("Donjon " + (i + 1) + " créé avec succès !\n");

            while (true) {
                donjon.afficher();
                System.out.println("- Ajouter un monstre       : monstre");
                System.out.println("- Ajouter un équipement    : equipement(nom,a,1)");
                System.out.println("- Définir spawn personnage : spawn(nom,a,1)");
                System.out.println("- Ajouter un obstacle      : obstacle(a,1)");
                System.out.println("- Terminer l'édition       : fin");
                System.out.print("> ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("fin")) {
                    break;
                }

                try {
                    if (input.equalsIgnoreCase("monstre")) {
                        System.out.print("Espèce du monstre : ");
                        String espece = scanner.nextLine();

                        System.out.print("Numéro du monstre (si plusieurs du même type) : ");
                        int numero = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nom de l'attaque : ");
                        String attaqueNom = scanner.nextLine();

                        System.out.print("Portée de l'attaque (1 = corps-à-corps) : ");
                        int porteeAttaque = Integer.parseInt(scanner.nextLine());

                        System.out.print("Dés de dégâts (ex : 1d6) : ");
                        String degatsAttaque = scanner.nextLine();

                        System.out.print("Points de vie : ");
                        int pointsDeVie = Integer.parseInt(scanner.nextLine());

                        System.out.print("Force (0 si attaque à distance) : ");
                        int force = Integer.parseInt(scanner.nextLine());

                        System.out.print("Dextérité (0 si attaque au corps-à-corps) : ");
                        int dexterite = Integer.parseInt(scanner.nextLine());

                        System.out.print("Classe d'armure : ");
                        int classeArmure = Integer.parseInt(scanner.nextLine());

                        System.out.print("Initiative : ");
                        int initiative = Integer.parseInt(scanner.nextLine());

                        Monstre m = new Monstre(espece, numero, attaqueNom, porteeAttaque, degatsAttaque,
                                pointsDeVie, force, dexterite, classeArmure, initiative);

                        System.out.print("Position (ex: b,2) : ");
                        String pos = scanner.nextLine();
                        int x = pos.toLowerCase().charAt(0) - 'a';
                        int y = Integer.parseInt(pos.substring(2)) - 1;
                        donjon.ajouterMonstre(m, x, y);
                        System.out.println("Monstre ajouté.");
                    } else if (input.startsWith("equipement(")) {
                        String[] params = input.substring(11, input.length() - 1).split(",");
                        String nom = params[0].trim();
                        int x = params[1].trim().toLowerCase().charAt(0) - 'a';
                        int y = Integer.parseInt(params[2].trim()) - 1;
                        Equipement e = null;
                        // Recherche dans les armes
                        e = equipements.Armes.getToutesLesArmes().stream()
                                .filter(a -> a.getNom().equalsIgnoreCase(nom))
                                .findFirst().orElse(null);
                        // Recherche dans les armures si non trouvé
                        if (e == null) {
                            e = equipements.Armures.getToutesLesArmures().stream()
                                    .filter(a -> a.getNom().equalsIgnoreCase(nom))
                                    .findFirst().orElse(null);
                        }
                        // Si toujours pas trouvé, équipement générique
                        if (e == null) {
                            e = new equipements.Equipement(nom) {};
                        }
                        donjon.ajouterEquipement(e, x, y);
                        System.out.println("Équipement ajouté.");
                    } else if (input.startsWith("spawn(")) {
                        String[] params = input.substring(6, input.length() - 1).split(",");
                        String nom = params[0];
                        int x = params[1].toLowerCase().charAt(0) - 'a';
                        int y = Integer.parseInt(params[2]) - 1;
                        System.out.println("Spawn de " + nom + " défini à " + params[1] + "," + params[2]);
                        // tu peux stocker le point de spawn dans une Map si tu veux l'utiliser plus tard
                    } else if (input.startsWith("obstacle(")) {
                        String[] params = input.substring(9, input.length() - 1).split(",");
                        int x = params[0].toLowerCase().charAt(0) - 'a';
                        int y = Integer.parseInt(params[1]) - 1;
                        donjon.ajouterObstacle(x, y);
                        System.out.println("Obstacle ajouté.");
                    } else {
                        System.out.println("Commande non reconnue.");
                    }
                } catch (Exception e) {
                    System.out.println("Erreur de saisie. Format incorrect.");
                }
            }

            System.out.println("Édition du donjon " + (i + 1) + " terminée.\n");
        }
    }

    public ArrayList<Donjon> getDonjons() {
        return m_donjons;
    }
}
