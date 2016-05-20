import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Container;

/**
 * Write a description of class Boton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boton extends Actor
{
    private GreenfootImage imagen;
    private int x,y;
    
    /**
     * Constructor de Actor
     */
    public Boton(int x, int y, String name)
    {
        this.x=x;
        this.y=y;
        imagen = new GreenfootImage(name);
        setImage(imagen);
    }
    
    /**
     * @return regresa el valor de y
     */
    public int getsY()
    {
        return y;
    }
    
    /**
     * @return regresa el valor de x
     */
    public int getsX()
    {
        return x;
    }
    
    /**
     * Act - do whatever the Boton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
