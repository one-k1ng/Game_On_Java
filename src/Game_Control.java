import java.util.Random;

public class Game_Control{
    public Random RANDOM = new Random();


    public void newGame(){
        do {
            reset();
            shuffle();
        }while(!isSolvable());
        Configuration.gameOver = false;
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