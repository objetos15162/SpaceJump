import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow extends Bullet
{
    /**
     * Constructor de la clase
     */
    public Snow(double x ,double y, Vector move)
    {
        super(x,y,10,move,new Vector(),"bala_blue.png",25);
    }
    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }     
}
