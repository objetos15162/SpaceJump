import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Body
{
    private int direction;
    private double damage;

    /**
     * 
     */
    public Bullet(double x ,double y, double mass, Vector move,Vector rot,String imagefile,double damage)
    {
        super(x,y,mass,move,rot,imagefile);
        direction=0;
        this.damage=damage;
    }
    
    /**
     * 
     */
    public void act()
    {
        super.act();
        
        lookAt();
    }
    
    /**
     * @return el valor de damage
     */
    public double getDamage()
    {
        return damage;
    }
    
    /**
     * remueve una clase
     */
    public void elimina(Class clss)
    {
        removeTouching(clss);
    }
    
    /**
     * Rotates the bullet according to the direction where it is going
     */
    private void lookAt(){
        
    this.setRotation(getMovement().getDirection());
    }
    
    
    
    
}
