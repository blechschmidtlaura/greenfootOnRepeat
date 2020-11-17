import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Carrot extends Actor
{
    //TODO: Identifiziere Attribute, Methoden und Konstruktoren 
    //und markiere diese entsprechend durch Kommentare.
    private int weight = 5; //Attribut
    
    public Carrot(){
        setWeight(5);
    }
    
    public Carrot(int weight){
        setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }    
    
    public void setWeight(int newWeight){
        weight = newWeight;
        getImage().drawString(String.valueOf(weight), 0, 10);
    }
}
