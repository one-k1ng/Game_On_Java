import java.awt.*;

public class Main extends GameOfFifteen{
    private GameOfFifteen gof = new GameOfFifteen();
    public void Main() {
        this.size = size;
        dimension = dim;
        margin = mar;

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
