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
        Bull_2=0;
        Bull_3=0;
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
     * 
     */
    public Bullet getNewBullet(double x ,double y, double mass, Vector move,Vector rot,String imagefile)
    {
        changeBullets();
        return new Bullet(x,y,mass,move,rot,imagefile);
    }
    
}
