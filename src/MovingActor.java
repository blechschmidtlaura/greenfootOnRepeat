import java.util.List;

// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * Ac
 * 
 */
public class MovingActor extends Actor {
    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int localRotation; // aktuelle Richtung
    
    private GreenfootImage imageRight;
    private GreenfootImage imageLeft;
    private GreenfootImage currentImage;
    

    /**
     * Erzeuge einen Hasen
     */
    public MovingActor() {
        imageRight = new GreenfootImage(getImage());
        imageLeft = new GreenfootImage(getImage());
        currentImage = imageRight;
        imageLeft.mirrorVertically();

        setImageRotationAndImage(RIGHT);
    }
    

    
    /**
     * Überprüft ob der Hase einen Schritt nach vorne laufen kann ohne auf ein Hindernis (Wand/Stein) zu treffen.
     */
    public boolean canMove(){
        return canMove(1);
    }

    /**
     * Überprüft, ob sich in distance Schritten vor dem Hasen kein Hindernis (Wand/Stein) befindet. 
     */
    public boolean canMove(int distance) {
        World myWorld = getWorld();
        int x = getNextX(distance);
        int y = getNextY(distance);

        if (x >= myWorld.getWidth() || y >= myWorld.getHeight() - 1) {
            return false;
        } else if (x < 0 || y < 0) {
            return false;
        }

        List<Rock> rocks = myWorld.getObjectsAt(x, y, Rock.class);
        if (rocks.isEmpty()) {
            return true;
        }

        return false;

    }

    /**
     * Returns the x coordinate of the next field, 
     * that lays <b>distance</b> steps in the current direction.
     */
    public int getNextX(int distance) {
        int x = getX();
        switch (localRotation) {
        case RIGHT:
            x = x + distance;
            break;
        case LEFT:
            x = x - distance;
            break;
        }
        return x;
    }

    
    /**
     * Returns the y coordinate of the next field, 
     * that lays <b>distance</b> steps in the current direction.
     */
    public int getNextY(int distance) {

        int y = getY();
        switch (localRotation) {
        case DOWN:
            y = y + distance;
            break;
        case UP:
            y = y - distance;
            break;
        }
        return y;
    }

    /**
     * Nach links drehen.
     */
    public void turnLeft() {
        switch (localRotation) {
        case DOWN:
            setImageRotationAndImage(RIGHT);
            break;
        case RIGHT:
            setImageRotationAndImage(UP);
            break;
        case UP:
            setImageRotationAndImage(LEFT);
            break;
        case LEFT:
            setImageRotationAndImage(DOWN);
            break;
        }
    }

    /**
     * Nach rechts drehen
     */
    public void turnRight() {
        switch (localRotation) {
        case DOWN:
            setImageRotationAndImage(LEFT);
            break;
        case RIGHT:
            setImageRotationAndImage(DOWN);
            break;
        case UP:
            setImageRotationAndImage(RIGHT);
            break;
        case LEFT:
            setImageRotationAndImage(UP);
            break;
        }
    }

    /**
     * Setze Richtung des Hasen.
     */
    public void setImageRotationAndImage(int direction) {
        this.localRotation = direction;
        switch (direction) {
        case DOWN:
            setImage(imageRight);
            setRotation(90);
            break;
        case RIGHT:
            setImage(imageRight);
            setRotation(0);
            break;
        case UP:
            setImage(imageLeft);
            setRotation(-90);
            break;
        case LEFT:
            setImage(imageLeft);
            setRotation(180);
            break;
        default:
            break;
        }
    }

    /**
     * Tu, was ein Hase so tut
     */
    public void act() {
        super.act();
    }
    
     /**
     * Gibt den Text über dem Character aus.
     */
    public void say(boolean text){
        say(String.valueOf(text));
    }
    
     /**
     * Gibt den Text über dem Character aus.
     */
    public void say(int text){
        say(String.valueOf(text));
    }
    
     /**
     * Gibt den Text über dem Character aus.
     */
    public void say(double text){
        say(String.valueOf(text));
    }
    
    /**
     * Gibt den Text über dem Character aus.
     */
    public void say(String text){
        int y = getY() - 1;
        if (y < 0){
            y = 1;
        }
        getWorld().showText(text, getX(), y);
        System.out.println("a " + this.getClass().getName() + " says: " + text); 
        Greenfoot.delay(1);
    }
    
    /**
	* Liefert das Objekt vom Typ RabbitWorld in dem der Hase sich befindet.
	**/
    public RabbitWorld getRabbitWorld(){
        return getWorldOfType(RabbitWorld.class);
    }
    
    public void setImage(GreenfootImage image){
        currentImage = image;
        super.setImage(new GreenfootImage(currentImage));
    }
    
    
    /**
     * Zeichnet den übergebenen Text auf das aktuelle Bild der Figur.
     */
    public void draw(String text){
        super.setImage(new GreenfootImage(currentImage));
        getImage().drawString(text, 0, 10);
    }
    
    /**
     * Zeichnet den Wert auf das aktuelle Bild der Figur.
     */
    public void draw(int value){        
        draw(String.valueOf(value));
    }
    
}
