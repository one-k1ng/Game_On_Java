import java.awt.*;

public class Main extends GameOfFifteen{
    private GameOfFifteen gof = new GameOfFifteen();
    public void Main() {
        public static Configuration configuration;
        static{
            configuration = new Configuration(4,550,30);
        }

        nbTiles = size * size - 1;
        tiles = new int[size * size];

        gridSize = (dim - 2 * margin);
        tileSize = gridSize / size;

        setPreferredSize(new Dimension(dimension, dimension + dimension));
        setBackground(Color.WHITE);
        setForeground(Foreground_Color);
        setFont(new Font("SansSerif", Font.BOLD, 60));

        gameOver = true;
    }
}
