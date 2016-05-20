import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
* This class is used to manage the behavior of the player in Space jump, the controls, the animations showed while
* the player acts and other parameters needed for the plyer
*
* @author Alfredo Granja && Gerardo Enriquez
* @version 2016
*/
public class Enemy extends Body
{
    private int vida,a,b,cd;
    private double direction;
    private Pistol pistola;
    private Player enemigo;
    private static double radio = 30;
    
    /**
    * Creates a player with a position in the global world.
    * @param x The coordinate x in the global world.
    * @param y The coordinate y in the global world.
    */
    public Enemy(int x, int y,Player jugador)
    {
        super(x,y,13,new Vector(0,0),new Vector((int)0,(double)1),"enemy.png");
        a=x;
        b=y;
        pistola = new Pistol(this);
        direction=0;
        vida=500;
        enemigo=jugador;
    }
    
    /**
    * @Override.
    * this method overrides the Greenfoot method and calls the methods needed for the player to act.
    *
    */
    public void act()
    { 
        super.act();
        atacar();
        sufre();
    }
        
     /**
    * makes the player rotate to the left.
    */
    private void rotateLeft()
    {
        direction-=1.2;
        setRotation((int)direction);
    }
    
    /**
     * cuando detecta al jugador dentro del rango empieza a disparar hacia el
     */
    private void atacar()
    {
         
         if(getObjectsInRange(500,Player.class) != null && cd == 50)
         {
             getScrollWorld().addObject(pistola.getOldBullet(2,getRotationVector()));
             cd=0;
         }
         cd++;
    }
    
    /**
     * 
     */
    private void sufre()
    {
        List<Bullet>bulletsOnSurface=getObjectsInRange((int)radio,Bullet.class);
        getWorld().removeObjects(bulletsOnSurface);
        
        if( isTouching(Snow.class) || isTouching(Laser.class) || isTouching(Fire.class) )
        {
            
        }
    }
    
    /**
    * Makes the player rotate to the right.
    *
    */
    private void rotateRight()
    {
        direction+=1.2;
        setRotation((int)direction);
    }
    }
