import greenfoot.*;

import java.lang.reflect.Array;
import java.util.*;

public class PlayerRabbit extends MovingActor {
    //TODO: canhit interface, enum direction, blocks interface, canpick/put interface, Methoden mit Doku-String, Begrenzung (private od. public?),
    //TODO: final bei attributen, github/lab verwenden, Klasse Item, und fun :)
    
    //Attribute
    private final int total_life = 100;

    private boolean alive = true;


    private boolean isInWorld = true;


    private int life; //Attribut
    //private int carrot_stack; //Attribut
    //private List<Carrot> carrots = new LinkedList<>(); //version mit Liste
    private Carrot[] carrots = new Carrot[10];
    //Konstruktoren
    public PlayerRabbit(){
        this.life = this.total_life; //wenn im Setter noch Bedingungen festgelegt sind --> Fehler
        //this.carrot_stack = 20;

        //andere Möglichkeit des Aufrufs
        //a: mit Setter: setLife(100);
        //b: anderen Konstuktor aufrufen: this(100,10);
    }
    
    public PlayerRabbit(int life, int stack){
        this.life = life;
        carrots = new Carrot[stack];
        //this.carrot_stack = stack;
    }
    //Methoden
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        if(life <= 0){
            this.alive = false;
        }
        performMovement();
        putCarrot();
        getCarrot();
        eatCarrot();
        destroyRock();
    }

    public void hit(int damage){
        this.life = life - damage;
    }
    
    public void destroyRock(){
       if(Greenfoot.isKeyDown("E")){
           List <Rock> rocks = getWorld().getObjectsAt(getNextX(1), getNextY(1), Rock.class);
           List <Rock> rocks2 = getWorld().getObjectsAt(getNextX(-1), getNextY(1), Rock.class); //geht nicht
           List <Rock> rocks3 = getWorld().getObjectsAt(getNextX(-1), getNextY(-1), Rock.class);
           List <Rock> rocks4 = getWorld().getObjectsAt(getNextX(1), getNextY(-1), Rock.class); //geht nicht
           if(rocks.size() > 0) {
               Rock rock = rocks.get(0);
               rock.hit();
               if(rock.getLife() <= 0) {
                   getWorld().removeObject(rock);
               }
           } else if(rocks2.size() > 0) {
               Rock rock = rocks2.get(0);
               rock.hit();
               if(rock.getLife() <= 0) {
                   getWorld().removeObject(rock);
               }
           } else if(rocks3.size() > 0) {
               Rock rock = rocks3.get(0);
               rock.hit();
               if(rock.getLife() <= 0) {
                   getWorld().removeObject(rock);
               }
           } else if(rocks4.size() > 0) {
               Rock rock = rocks4.get(0);
               getWorld().removeObject(rock); //getWorld(): gibt eine Referenz auf ein Objekt zurück
           }
       }
    }
    
    public void putCarrot(){
        if(Greenfoot.isKeyDown("P")){
            /*if(carrot_stack > 0){
                getWorld().addObject(new Carrot(), getX(), getY());
                carrot_stack = carrot_stack -1;
            }*/
            /*if(carrots.size() > 0){
                getWorld().addObject(carrots.get(0), getX(), getY());
                carrots.remove(0);
            }*/ //Liste
            if(carrots.length > 0 && carrots[0] != null){ //durch Festlegung auf Größe 10 des Array kann es dazu kommen, dass zwar Carrots drin sind, aber auch null-Referenzen, anders möglich?

                getWorld().addObject(carrots[0], getX(), getY());
                Carrot[] newArray = new Carrot[carrots.length-1];
                for(int i = 0; i < newArray.length; i++){
                    newArray[i] = carrots[i+1]; //[i+1] eine Art Entfernung des ersten Elements; auch möglich = null
                }
                carrots = newArray;
            } //Array
        }
    }
    
    public void getCarrot(){ //Methoden, nur einen Zweck; hier mehrere - Sachen auslagern(zB Keyabfrage, neues Array...)
        if(Greenfoot.isKeyDown("G")){
            World world = getWorld();
            List <Carrot> carrotList = world.getObjectsAt(getX(), getY(), Carrot.class);
            if(carrotList.size() > 0){
                Carrot carrot = carrotList.get(0);
                //this.carrots.add(carrot); // Liste
                Carrot[] newArray = new Carrot[carrots.length+1];
                newArray[0] = carrot;
                for(int i = 0; i < newArray.length-1; i++){
                    newArray[i+1] = carrots[i]; //[i+1]: da vorne ein Element hinzugefügt wird
                }
                newArray[newArray.length-1] = carrot;
                carrots = newArray; //Array
                world.removeObject(carrot);
            }
        }
    }
    
    public void eatCarrot(){
       if(Greenfoot.isKeyDown("Q")){
            World world = getWorld();
            List <Carrot> carrotList = world.getObjectsAt(getX(), getY(), Carrot.class);
            if(carrotList != null && carrotList.size() > 0){
                Carrot carrot = carrotList.get(0);
                world.removeObject(carrot);
                if(this.life != this.total_life){
                    this.life = this.life + carrot.getWeight();
                }
            }
        } 
    }

    //TODO: Steuerung über die Tasten W - A - S - D realisieren
    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turnLeft();
            move();
            turnRight();
        }   
        if (Greenfoot.isKeyDown("A")) {
            turnLeft();
            turnLeft();
            move();
            turnRight();
            turnRight();
        } 
        if (Greenfoot.isKeyDown("S")) {
            turnRight(); //move(-1)
            move();
            turnLeft();
        } 
        if (Greenfoot.isKeyDown("D")) {
            move();
        } 
    }
    
    
     /**
     * moves one step forward
     */
    public void move(){
        if(canMove()){
            move(1);
        } else if(getObjectsAtOffset(1, 1, Rock.class).size() > 0){
            life= life-3;
        } else if(getNextX(1) == getWorld().getWidth()){
            isInWorld = false;
        }
    }//Überladen von Methoden, Compiler erkennt es am Methodennamen und am Parameter (nicht am Rückgabetyp)

    public int getLife(){
        return this.life;
    }

    public boolean isInWorld() {
        return isInWorld;
    }

    public boolean isAlive() {
        return alive;
    }
}
//getter/setter: Zugriff auf die Attribute von anderen Klassen, Zugriffskontrolle, da Attribut private ist; logische Abfragen innerhalb der Methode (z.B.life nicht unter null setzen)

//Array:schneller Zugriff O(1), schlecht ein weiteres Element hinzufügen wegen fester Länge(neues erstellen und kopieren) O(n)
//Liste: langsamer Lesezugriff O(n), leicht ein weiteres Element hinzufügbar, Referenz O(1)
//Stack: Zugriff aufs oberste Element O(1), ein unteres Element O(n)
