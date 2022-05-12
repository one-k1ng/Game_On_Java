import java.util.TimerTask;

public class IncrementTimerTask extends TimerTask {
    public void run(){
        GameStats.clickCounters.set(GameStats.clickCounters.size() - 1, GameStats.clickCounters.get(GameStats.clickCounters.size() - 1) + 1);
    }
}
