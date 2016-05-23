import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * First enemy of the game space jump
 * 
 * @author (Alfredo granja , Gerardo enriquez) 
 * @version (may of 2016)
 */
public class Enemy1 extends Enemy
{
   private int time;
    public Enemy1(int x,int y)
    {
        super(x,y,50);  
        time=0;
        setImage("enemy1.png");
    }
    
    /**
     * makes the enemy atack to the player in a particular way
     */
    public  void attack(){
    List<Player> play =getObjectsInRange(420,Player.class);
   
    if(!play.isEmpty() ){
      time++;
      if(time >=60&&time<=65){
      shot(getDistance(play.get(0)));
      time=0;}
       
    
    }
    
    }
    public void act() 
    {
        attack();
        super.act();
    }
}
