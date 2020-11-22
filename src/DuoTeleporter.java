import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.List;

public class DuoTeleporter extends Actor implements Teleporter {

    private boolean isOn = false;

    private boolean isOn() {
        return isOn;
    }

    public DuoTeleporter getPartner() {
        return partner;
    }

    public void setPartner(DuoTeleporter partner) {
        this.partner = partner;
    }

    private DuoTeleporter partner;

    private Timer timer = new Timer(0);

    //private int teleportingTime = 0;

    @Override
    public void act() {
        decideTeleportation();
    }

    public void decideTeleportation(){
        if(timer.isTicking()){
            timer.ticking();
        } else if (partner != null) {
                teleportWithPartner();
                timer = new Timer(timer.getTimeValue());
            } else {
                teleport();
                timer = new Timer(timer.getTimeValue());
            }
    }

    @Override
    public void teleport(){
        List<DuoTeleporter> objects = getWorld().getObjects(DuoTeleporter.class);
        PlayerRabbit player = (PlayerRabbit) this.getOneIntersectingObject(PlayerRabbit.class);
        while(player != null) {

            int number = Greenfoot.getRandomNumber(objects.size());
            if(objects.get(number) != this){
                DuoTeleporter chosenTeleporter = objects.get(number);
                player.setLocation(chosenTeleporter.getX(), chosenTeleporter.getY());
                player.move(); //damit keine Endlosschleife entsteht
                return;
            }
            /*for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i) != this) {
                    player.setLocation(objects.get(i).getX(), objects.get(i).getY());
                    player.move(); //damit keine Endlosschleife entsteht
                    System.out.println("2");
                    return;
                }
            }*/
        }
    }

    public void teleportWithPartner(){
        PlayerRabbit player = (PlayerRabbit) this.getOneIntersectingObject(PlayerRabbit.class);
        if (player != null) {
            player.setLocation(partner.getX(), partner.getY());
            //Greenfoot.delay(3); --Alternative zum Timer
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
