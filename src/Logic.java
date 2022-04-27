import java.awt.event.MouseEvent;
import java.util.Random;

public class Logic extends GameOfFifteen{
    public Random RANDOM = new Random();

    public void shuffle(){
        int  n = nbTiles;

        while (n > 1){
            int r = RANDOM.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }
}
