/**
 * Write a description of class Pistola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pistol  
{
    // instance variables - replace the example below with your own
    private Vector direction;
    private int Bull_1,Bull_2,Bull_3;
    private int type;
    private Player jugador;

    /**
     * Constructor for objects of class Pistola
     */
    public Pistol(Player jugador)
    {
        this.jugador=jugador;
        Bull_1=100;
        Bull_2=20;
        Bull_3=10;
        type=1;
        direction = new Vector();
    }
    
    /**
     * @return the number of the bullets
     */
    public int getBullets()
    {
        int bullet;
        if(type == 1)
            bullet = Bull_1;
            else if(type == 2)
            bullet = Bull_2;
            else bullet = Bull_3;
        return bullet;
    }
    
    /**
     * reduces the bullets -1
     */
    private void changeBullets()
    {
        if (type == 1)
            Bull_1--;
            else if (type == 2)
            Bull_2--;
            else Bull_3--;
    }
    
    /**
     * @param t contains the number of avalible bullets
     */
    public void setType(int t)
    {
        type=t;
    }
    
    /**
     * @return a new bullet for aech type
     */
    public Bullet getNewBullet(double x ,double y, double mass, Vector move,Vector rot)
    {
        changeBullets();
        if(type==1)
            return new Bullet(x,y,mass,move,rot,"bala_blue.png");
            else if(type==2)
                return new Bullet(x,y,mass+.5,move,rot,"fire_bullet.png");
                else return new Bullet(x,y,mass+.3,move,rot,"bala_blue.png");
    }
    
}
