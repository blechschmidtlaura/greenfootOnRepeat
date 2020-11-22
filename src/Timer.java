import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.util.GreenfootUtil;

public class Timer extends Actor {

    private int tickingTime;

    public int getTimeValue() {
        return timeValue;
    }

    private final int timeValue = 3;

    public Timer(int time){
        this.tickingTime = time;
    }

    public void ticking(){
        if(tickingTime>0){
            tickingTime--;
        }
    }

    public boolean isTicking(){
        if(getTickingTime() > 0){
            return true;
        } else{
            return false;
        }
    }

    public int getTickingTime(){
        return tickingTime;
    }

    public void setTickingTime(int tickingTime){
        this.tickingTime = tickingTime;
    }
}
