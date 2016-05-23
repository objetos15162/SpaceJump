import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author ink
 * @version (a version number or a date)
 */
public class Fire extends Bullet
{
    /**
     * Constructor de la clase
     */
    public Fire(double x ,double y, Vector move)
    {
        super(x,y,5,move,new Vector(),"fire_bullet.png",8);
    }
    
    /**
     *calls the super class act method.
     */
    public void act() 
    {
        
        super.act();
    }     
}
