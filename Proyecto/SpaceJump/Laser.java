import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *describea
 * 
 * @author (Alfrdo granja, Gerardo enriquez) 
 * @version (a version number or a date)
 */
public class Laser extends Bullet
{
    /**
     * Constructor de la clase
     */
    public Laser(double x ,double y, Vector move)
    {
        super(x,y,1,move,new Vector(),"b1.png",15);
    }
    
    /**
     *calls the super class act method.
     */
    public void act() 
    {
        
        super.act();
    }    
}
