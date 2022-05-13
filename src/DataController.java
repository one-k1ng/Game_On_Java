import java.io.*;
import java.util.List;

public class DataController {
    private GameStats gameStats;

    public DataController(GameStats newGameStats) {
        gameStats = newGameStats;
    }

    public void serializeGame() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(gameStats);

        objectOutputStream.close();
    }

    public void deserializeGame() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        GameStats gs = (GameStats) objectInputStream.readObject();
    }
}
