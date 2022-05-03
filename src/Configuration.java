//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;

public class Configuration {
    public static int size = 4;
    public static int margin = 30;
    public static int dimension = 550;
    public static int[] tiles;
    public static int gridSize;
    public static int tileSize;
    public static int blankPos;
    public static Color Foreground_Color;
    public static int nbTiles;
    public static boolean gameOver;

    public Configuration() {
    }

    static {
        tiles = new int[size * size];
        Foreground_Color = new Color(240, 80, 80);
        gridSize = dimension - 2 * margin;
        tileSize = gridSize / size;
        nbTiles = size * size - 1;
        gameOver = true;
    }
}
