import greenfoot.Greenfoot;

import java.util.List;

public class Monster extends MovingActor{

    private int damage = 10;

    public void act(){
        movement();
        hitPlayer();
    }

    public void movement(){
        int number = Greenfoot.getRandomNumber(4);
        if(number == 0){
            turnLeft();
        } else if(number == 1){
            turnRight();
        } else if (number == 2) {
            turnRight();
            turnRight();
        } //else if (number == 3){
            //move(1);
        //}
        move(1);
    }
    public void hitPlayer(){ //public oder private?
        if(isTouching(PlayerRabbit.class)){
            List<PlayerRabbit> players = getWorld().getObjectsAt(getX(),getY(),PlayerRabbit.class);
            for(int i = 0; i < players.size(); i++){
                players.get(i).hit(damage);
            }
        }
    }
}
