import greenfoot.Actor;
import greenfoot.Greenfoot;

public class GenericTeleporter extends Actor implements Teleporter{
    public void act(){
        teleport();
    }
    @Override
    public void teleport() {
        int random_x = Greenfoot.getRandomNumber(getWorld().getWidth()+1);
        int random_y = Greenfoot.getRandomNumber(getWorld().getHeight()+1);

        Actor player = getOneIntersectingObject(MovingActor.class); //alles was ihn betritt
        if(player != null) {
            player.setLocation(random_x, random_y);
        }
    }
}
