import java.util.TimerTask;

public class IncrementTimerTask extends TimerTask {
    public void run(){
        GameStats.timerCounterValues.set(GameStats.timerCounterValues.size() - 1, GameStats.timerCounterValues.get(GameStats.timerCounterValues.size() - 1) + 1);
    }
}
