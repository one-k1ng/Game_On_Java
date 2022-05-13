import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Random;
import java.util.*;

public class Game_Control {
    public Random RANDOM = new Random();
    private final Timer timer = new Timer();
    public static final GameStats gameStats = new GameStats();

    public Game_Control() {
        if (gameStats.timerCounters.size() == 0) {
            DataController dataController = new DataController(gameStats);
            try {
                dataController.deserializeGame();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void newGame() {
        do {
            reset();
            shuffle();
        }while(!isSolvable());
        System.out.println(gameStats.clickCounters);
        System.out.println(gameStats.timerCounters);
        gameStats.clickCounters.add(0);
        gameStats.timerCounters.add(0);
        Configuration.gameOver = false;
        timer.schedule(new IncrementTimerTask(), 0, 1000);
    }



    public boolean isSolvable() {
        int countInversion = 0;

        for (int i = 0; i < Configuration.nbTiles; i++){
            for (int j = 0; j < i; j++){
                if (Configuration.tiles[j] > Configuration.tiles[i])
                    countInversion++;
            }
        }

        return countInversion % 2 == 0;
    }

    public boolean isSolved(){
        if (Configuration.tiles[Configuration.tiles.length - 1] != 0)
            return false;

        for (int i = Configuration.nbTiles - 1; i >= 0; i--){
            if (Configuration.tiles[i] != i + 1)
                return false;
        }
        return true;
    }

    public void reset(){
        for (int i = 0; i < Configuration.tiles.length; i++){
            Configuration.tiles[i] = (i + 1) % Configuration.tiles.length;
        }

        Configuration.blankPos = Configuration.tiles.length - 1;
    }

    public void shuffle(){
        int  n = Configuration.nbTiles;

        while (n > 1){
            int r = RANDOM.nextInt(n--);
            int tmp = Configuration.tiles[r];
            Configuration.tiles[r] = Configuration.tiles[n];
            Configuration. tiles[n] = tmp;
        }
    }
}