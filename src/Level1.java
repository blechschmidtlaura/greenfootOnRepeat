import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RabbitLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends RabbitWorld
{

    /**
     * Constructor for objects of class RabbitLevel1.
     * 
     */
    private PlayerRabbit player;

    public Level1()
    {
        super();
        this.player = new PlayerRabbit();
        this.addObject(player, 4, 4);
        // b)  Erzeuge einen neuen Fels (Rock). Platziere den Fels auf (5, 5).
        this.addObject(new Rock(), 5,5);
        // c)  Erstelle eine Karotte (Carrot) und platziere sie auf dem Feld (1, 5).
        Carrot carrot = new Carrot();
        this.addObject(carrot, 1, 5);
        // d)  Erstelle eine weitere Karotte mit dem Gewicht 3, hierzu muss ein anderer Konstruktor aufgerufen werden. Platziere sie auf dem Feld (1, 6).
        this.addObject(new Carrot(3), 1, 6);
        //e)  Fülle die komplette 7. Spalte der Welt Level1 mit Felsen auf.
        int k = 7;
        for(int i = 0; i < getWidth(); i++){
            addObject(new Rock(), i, k);
        }
        this.addObject(new Monster(),0,0);
        this.addObject(new Monster(), 3,2);

        //this.addObject(new DuoTeleporter(), 1,1);
        //this.addObject(new DuoTeleporter(), 5,1);
        DuoTeleporter teleporter1 = new DuoTeleporter();
        DuoTeleporter teleporter2 = new DuoTeleporter();
        DuoTeleporter teleporter3 = new DuoTeleporter();
        teleporter1.setPartner(teleporter2);
        teleporter2.setPartner(teleporter3);
        //teleporter3.setPartner(teleporter1);
        addObject(teleporter1, 0,2);
        addObject(teleporter2, 0,4);
        addObject(teleporter3,0,6);

        //PlayerRabbit player2 = new PlayerRabbit();
        //player2.setImage("rock.gif");
        //this.addObject(player2, 5,1);

    }

    @Override
    public void act() {
        this.showText(Integer.toString(player.getLife()), 0,0);
        if(!player.isAlive()){
            Greenfoot.setWorld(new EndWorld());
        }
        if(!player.isInWorld()&&player.getWorld() instanceof Level1){
            Greenfoot.setWorld(new Level2(player));
        }
    }
}
