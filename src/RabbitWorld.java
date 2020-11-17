// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.*;
import java.util.*;
import java.lang.reflect.Array;

/**
 * @author Michael Kolling, changed by Thomas Karp
 * @version 1.0.3
 */
public class RabbitWorld extends World
{
    
    /**
     * Erzeuge eine Welt.
     */
    public RabbitWorld() 
    {
        super(8, 8, 60);
        setBackground("cell.jpg");
        setPaintOrder(PlayerRabbit.class, Star.class, Carrot.class, Rock.class);
    }

    
    /**
     * Returns an array of all Objects at the specified coordinates (x,y)
     * of the given type.
     */
    /*public <A extends Actor> A[] getObjectArrayAt(int x, int y, Class<A> type){
        List<A> objs = getObjectsAt(x, y, type);
        
        A[] objArray = (A[])Array.newInstance(type, objs.size());
        for(int i=0; i < objs.size(); i++){
            objArray[i] = objs.get(i);
        }
        
        return objArray;
    }*/
}