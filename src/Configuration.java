import java.awt.*;

public class Configuration {
    public int size;
    public int margin;
    public int dimension;
    public int tiles[];
    public int gridSize;
    public int tileSize;
    public boolean gameOver;
    public int blankPos;
    public static Color Foreground_Color;

    public Configuration(int newsize, int mar, int dim){
        size = newsize;
        margin = mar;
        dimension = dim;

        tiles = new int[size * size];

        Foreground_Color = new Color(239,80,80);

        gridSize = (dim - 2 * margin);
        tileSize = gridSize / size;

        gameOver = true;
    }
}
