import java.util.TimerTask;

public class IncrementTimerTask extends TimerTask {
    public void run(){
        Game_Control.incrementTimer();
    }
}
