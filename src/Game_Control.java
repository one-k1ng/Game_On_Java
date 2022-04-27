import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameOfFifteen{
    public Random RANDOM = new Random();


    public void newGame(){
        do {
            reset();
            logic.shuffle();
        }while(!isSolvable());
        gameOver = false;
    }

    public boolean isSolvable() {
        int countInversion = 0;

        for (int i = 0; i < nbTiles; i++){
            for (int j = 0; j < i; j++){
                if (tiles[j] > tiles[i])
                    countInversion++;
            }
        }

        return countInversion % 2 == 0;
    }

    public boolean isSolved(){
        if (tiles[tiles.length - 1] != 0)
            return false;

        for (int i = nbTiles - 1; i >= 0; i--){
            if (tiles[i] != i + 1)
                return false;
        }
        return true;
    }

    public void reset(){
        for (int i = 0; i < tiles.length; i++){
            tiles[i] = (i + 1) % tiles.length;
        }

        blankPos = tiles.length - 1;
    }

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