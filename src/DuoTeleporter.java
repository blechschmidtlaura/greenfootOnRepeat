import greenfoot.Actor;

import java.util.List;

public class DuoTeleporter extends Actor implements Teleporter {

    private boolean isOn = false;

    private boolean isOn() {
        return isOn;
    }

    @Override
    public void act() {
        teleport();
    }

    @Override
    public void teleport(){
        List<DuoTeleporter> objects = getWorld().getObjects(DuoTeleporter.class);
        PlayerRabbit player = (PlayerRabbit) this.getOneIntersectingObject(PlayerRabbit.class);
        if(player != null) {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i) != this) {
                    player.setLocation(objects.get(i).getX(), objects.get(i).getY());
                    //player.move();
                    return;
                }
            }
        }
    }
    /*public void teleport() {
        List<Teleporter> objects = getWorld().getObjects(Teleporter.class);
        int count = 0;
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i) instanceof DuoTeleporter){
                count++;
            } else{
                objects.remove(i);
            }
        }
        if(count==2){
            DuoTeleporter object1 = (DuoTeleporter) objects.get(0);
            DuoTeleporter object2 = (DuoTeleporter) objects.get(1);

            PlayerRabbit player = (PlayerRabbit) this.getOneIntersectingObject(PlayerRabbit.class);
            if(player != null){
                isOn = true;
                if(object1 != this) {
                    if(object1.isOn()) {
                        player.setLocation(object1.getX(), object1.getY());
                    }
                } else{
                    if(object2.isOn()) {
                        player.setLocation(object2.getX(), object2.getY());
                    }
                }
            }
        } else{
            return;
        }
    }*/
}
