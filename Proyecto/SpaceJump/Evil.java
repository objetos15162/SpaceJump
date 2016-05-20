import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Evil here.
 * 
 * @author ink
 * @version (a version number or a date)
 */
public class Evil extends Bullet
{
    /**
     * Constructor de la clase
     */
    public Evil(double x ,double y, Vector move)
    {
        super(x,y,30,move,new Vector(),"fire_bullet.png",5);
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