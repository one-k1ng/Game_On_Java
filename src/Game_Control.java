import java.awt.event.MouseAdapter;
import java.util.Random;

public class Game_Control{
    public Random RANDOM = new Random();
    Configuration configuration;


    public void newGame(){
        do {
            reset();
            shuffle();
        }while(!isSolvable());
        configuration.gameOver = false;
    }

    public boolean isSolvable() {
        int countInversion = 0;

        for (int i = 0; i < configuration.nbTiles; i++){
            for (int j = 0; j < i; j++){
                if (configuration.tiles[j] > configuration.tiles[i])
                    countInversion++;
            }
        }

        return countInversion % 2 == 0;
    }

    public boolean isSolved(){
        if (configuration.tiles[configuration.tiles.length - 1] != 0)
            return false;

        for (int i = configuration.nbTiles - 1; i >= 0; i--){
            if (configuration.tiles[i] != i + 1)
                return false;
        }
        return true;
    }

    public void reset(){
        for (int i = 0; i < configuration.tiles.length; i++){
            configuration.tiles[i] = (i + 1) % configuration.tiles.length;
        }

        configuration.blankPos = configuration.tiles.length - 1;
    }

    public void shuffle(){
        int  n = configuration.nbTiles;

        while (n > 1){
            int r = RANDOM.nextInt(n--);
            int tmp = configuration.tiles[r];
            configuration.tiles[r] = configuration.tiles[n];
           configuration. tiles[n] = tmp;
        }
    }
}