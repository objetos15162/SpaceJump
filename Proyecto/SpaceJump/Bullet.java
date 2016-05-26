import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * class that describes a bullet
 * 
 * @author (Alfredo granja, Gerardo enriquez) 
 * @version (may of 2016)
 */
public class Bullet extends Body
{
    private int direction;
    private int damage;

    /**
     * 
     */
    public Bullet(double x ,double y, double mass, Vector move,Vector rot,String imagefile,int damage)
    {
        super(x,y,mass,move,rot,imagefile);
        direction=0;
        this.damage=damage;
    }

    /**
     * **
     *calls the super class act method, and the lookAt method.
     */

    public void act()
    {damage();
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
     * substracts life when bullet impacts, kills enemy too.
     */

    public void damage(){
        List <Enemy>enem=getObjectsInRange(40,Enemy.class);
        for(Enemy eAux:enem){
            if(eAux.reduceLife(damage)==true){
                removeTouching(Enemy.class); 
                getScrollWorld().getJugador().addPoints(50);
            }
        }

    }

    /**
     * Rotates the bullet according to the direction where it is going
     */
    private void lookAt(){

        this.setRotation(getMovement().getDirection());
    }

}
