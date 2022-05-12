import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GameStats implements Serializable {
    public static List<Integer> clickCounters = new ArrayList<>();
    public static List<Integer> timerCounterValues = new ArrayList<>();

    static {
        clickCounters.add(0);
        timerCounterValues.add(0);
    }

    public void serializeGame() throws IOException {
        GameStats gameStats = new GameStats();

        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(gameStats);

        objectOutputStream.close();
    }

    public GameStats deserializeGame() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        GameStats gameStats = (GameStats) objectInputStream.readObject();

        return gameStats;
    }


//    public static int getClickCounter() {
//        return clickCounter;
//    }
//
//    public static void incrementClickCounter() {
//        clickCounter += 1;
//    }
//
//    public static void setClickCounter(int newCounter){
//        clickCounter = newCounter;
//    }
//
//    public static int getTimer(){
//        return timerValue;
//    }
//
//    public static void incrementTimer(){
//        timerValue += 1;
//    }
//
//    public static void setTimer(int newTimerValue){
//        timerValue = newTimerValue;
//    }
}
