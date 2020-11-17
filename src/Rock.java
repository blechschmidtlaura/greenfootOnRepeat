import greenfoot.Actor;

public class Rock extends Actor
{


    private int life;

    public int getLife() {
        return life;
    }

    /**
	 * Will be called on a hit.
	 */
	public Rock(){
	    this.life = 3;
    }

	public void hit(){
		getWorld().addObject(new Star(), getX(), getY()); //Bei einem Treffer wird kurz ein Stern eingeblendet
		life--;
	}

}