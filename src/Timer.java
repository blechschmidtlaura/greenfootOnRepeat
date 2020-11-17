import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.util.GreenfootUtil;

public class Timer extends Actor {

    long startTime;
    long endTime;

    public Timer(long endTime){
        startTime = System.currentTimeMillis();
        this.endTime = endTime;
    }

    public void act(){
        ticking();
    }

    public void ticking(){
        if(this.checkTime(endTime)){
            //todo
        }
    }

    public boolean checkTime(long endTime){
        long newTime = System.currentTimeMillis();
        if(endTime == newTime){
            return true;
        } else{
            return false;
        }
    }
}
