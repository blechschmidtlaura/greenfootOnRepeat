import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Star extends Actor {
	
	public Star(){
		getImage().scale(40, 40);
		
	}
	
	public void act(){		
		Greenfoot.delay(1);
		getWorld().removeObject(this);
	}

}
