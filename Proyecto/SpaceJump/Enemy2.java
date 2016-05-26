import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy2 here.
 * 
 * @author (Alfredo granja, Gerardo enriquez.) 
 * @version (may of 2016)
 */
public class Enemy2 extends Enemy
{

    public Enemy2(int x,int y)
    {
        super(x,y,70);
        setImage("enemy2.png");

    }

    /**
     * makes the enemy attack on a particular way.
     */
    public void attack()
    {
        List<Player> lista=getObjectsInRange(300,Player.class);
        if(!lista.isEmpty()){
            Vector vAux=getDistance(lista.get(0));
            setRotation(vAux.getDirection());
            setLocation(getWorldX()+(vAux.getX()*.01),getWorldY()+(vAux.getY()*.01));

        }

    }

    public void act() 
    {
        attack();
        super.act();
    }    
}
