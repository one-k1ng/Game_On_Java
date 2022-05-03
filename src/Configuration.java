import java.awt.*;

public class Configuration {
    public int size;
    public int margin;
    public int dimension;
    public int[] tiles;
    public int gridSize;
    public int tileSize;
    public boolean gameOver;
    public int blankPos;
    public static Color Foreground_Color;
    public int nbTiles;

    public Configuration(){
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
