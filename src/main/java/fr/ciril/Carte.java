package fr.ciril;

/**
 * Une carte passive qui contient une matrice de deux dimensions pour les murs
 */
public class Carte {
    private final char[][] walls;

    public Carte(char[][] walls) {
        this.walls = walls;
    }

    /**
     * @param x
     * @param y
     * @return true si les coordonnées sont dans les limites et qu'elles correspondent à un espace vide
     */
    public boolean isEmpty(int x, int y) {
        boolean inBounds = x >= 0 && x < this.walls.length && y >= 0 && y < this.walls[0].length;
        return inBounds && this.walls[y][x] == ' ';
    }
}
