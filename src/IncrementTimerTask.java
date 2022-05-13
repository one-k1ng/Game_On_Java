import java.util.TimerTask;

public class IncrementTimerTask extends TimerTask {
    public void run(){
        Game_Control.gameStats.timerCounters.set(Game_Control.gameStats.timerCounters.size() - 1, Game_Control.gameStats.timerCounters.get(Game_Control.gameStats.timerCounters.size() - 1) + 1);
    }
}
