import java.awt.*;

public class Configuration {
    public static int size;
    public static int margin;
    public static int dimension;
    public static int[] tiles;
    public static int gridSize;
    public static int tileSize;
    public static int blankPos;
    public static Color Foreground_Color;
    public static int nbTiles;
    public static boolean gameOver;

    static {
        size = 4;
        margin = 30;
        dimension = 550;

        tiles = new int[size * size];

        Foreground_Color = new Color(239,80,80);

        gridSize = (dimension - 2 * margin);
        tileSize = gridSize / size;

        nbTiles = size * size - 1;

        gameOver = true;
    }
}
