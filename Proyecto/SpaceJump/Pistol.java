/**
 * Write a description of class Pistola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pistol  
{
    // instance variables - replace the example below with your own
    private int Bull_1,Bull_2,Bull_3;
    private int type;
    private Player jugador;
    private Enemy enemigo;

    /**
     * Constructor para jugador
     */
    public Pistol(Player jugador)
    {
        this.jugador=jugador;
        Bull_1=55;
        Bull_2=200;
        Bull_3=50;
        type=2;
    }
    
    /**
     * Constructor para enemigo
     */
    public Pistol(Enemy enemigo)
    {
        this.enemigo=enemigo;
    }
    
    /**
     * agrega 10 balas mas de todos los tipos
     */
    public void addBullets()
    {
        Bull_1+=10;
        Bull_2+=15;
        Bull_3+=5;
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
     * @return the type of bullet
     */
    public int getType()
    {
        return type;
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
    public void setType()
    {
        type++;
        if(type>3)
            type=1;
    }
    
    /**
     * @return a old bullet 
     */
    public Bullet getOldBullet(double mass, Vector move)
    {
        double x = enemigo.getWorldX();
        double y = enemigo.getWorldY();
                
        return new Evil(x,y,move);
    }
    
    /**
     * @return a new bullet for aech type
     */
    public Bullet getNewBullet(double mass, Vector move)
    {
        Bullet b;
        double x = jugador.getWorldX();
        double y = jugador.getWorldY();
   
        changeBullets();
        if(type==1){
          
            b = new Laser(x,y,new Vector(move.getDirection(),2));}
            else if(type==2){
              
                b = new Fire(x,y,new Vector(move.getDirection(),3));}
                else{ b = new Snow(x,y,new Vector(move.getDirection(),1));}
        return b;
    }
    
}
