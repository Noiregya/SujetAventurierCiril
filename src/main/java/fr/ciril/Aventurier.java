package fr.ciril;

/**
 * Une classe aventurier qui as conaissance de la carte et peut s'y déplacer
 */
public class Aventurier {
    private int posX;
    private int posY;

    public Aventurier(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    /**
     * Déplace l'aventurier sur la carte
     *
     * @param carte
     * @param direction
     * @return true si l'aventurier a pu se déplacer
     */
    public boolean move(Carte carte, char direction) {
        switch (direction) {
            case 'N':
                if (carte.isEmpty(posX, posY - 1)) {
                    posY--;
                    return true;
                }
                break;
            case 'O':
                if (carte.isEmpty(posX - 1, posY)) {
                    posX--;
                    return true;
                }
                break;
            case 'S':
                if (carte.isEmpty(posX, posY + 1)) {
                    posY++;
                    return true;
                }
                break;
            case 'E':
                if (carte.isEmpty(posX + 1, posY)) {
                    posX++;
                    return true;
                }
                break;
        }
        return false;
    }
}
