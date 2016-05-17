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
    private int time;
    
    /**
     * 
     */
    public Bullet(double x ,double y, double mass, Vector move,Vector rot,String imagefile)
    {
        super(x,y,mass,move,rot,imagefile);
        direction=0;
        damage=0;
        time=0;
    }
    
    /**
     * 
     */
    public void act()
    {
        super.act();
        Impacto();
        time++;
    }
    
    /**
     * 
     */
    private void Impacto()
    {
        if(isTouching(Planet.class) || time>100);
            //getScrollWorld().removeObject(Bullet.class);
    }
}
