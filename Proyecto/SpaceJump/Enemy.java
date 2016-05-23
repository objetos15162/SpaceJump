import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * enemy used in Space jump project
 * 
 * @author (Alfredo granja) 
 * @version (may of 2016)
 */
public abstract class Enemy extends ScrollActor
{
    private int vida;

    
    public Enemy(int x, int y, int vida){
        super(x,y);
        this.vida=vida;
      
    
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
        getDamage();
    } 
    
    public abstract void attack();
    
    /**
     * @param valor que se asignara a vida
     */
    public boolean reduceLife(int i)
    {
        vida-=i;
        if(vida<=0){
        return true;}
        else return false;
    }
    
    /**
     * recibe el daño que genera cada bala
     */
    protected void getDamage()
    {
        List<Bullet> balas = getObjectsInRange(39,Bullet.class);
        
        for( Bullet b : balas)
        {  if(b instanceof Evil==false){
            removeTouching(Bullet.class);}
       
    }
    
   
    
}

/**
 * shots a bullet.
 * @param direction the direction wher the bullet must go.
 */
 public void shot(Vector direction){
    direction.setLength(3);
    

    
    getScrollWorld().addObject(new Evil(getWorldX(),getWorldY(),direction) );
    
    }
}
