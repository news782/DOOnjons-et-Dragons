package entite;

import interfacejeu.map_milieu;

public interface Entite {
    String affichageClass();
    String getAffichageCourt();
    String getAffichageLong();

    int getPosX();
    int getPosY();
    boolean setPosXY(int x, int y, map_milieu map);
    void setPosSansVerif(int x, int y);
    String getNom();
    String AfficherPVDB();
    void setPV(int degats);
}
