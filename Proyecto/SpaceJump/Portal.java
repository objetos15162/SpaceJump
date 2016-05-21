import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends ScrollActor
{
    
    public Portal (int x, int y){
    super(x,y);
    setImage("portal.png");
    }
    
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn(1);
        transportPlayer();
        
    }    
    
    private void transportPlayer(){
    
    List<Player> nueva=getObjectsInRange(45,Player.class);
    if(!nueva.isEmpty()){
    Player jugador=nueva.get(0);
    
    
       if(jugador.getCurrentWorld()instanceof Space){
         jugador.goToWorld(new Nivel2());
         return;
        
        }
    
         if(jugador.getCurrentWorld()instanceof Nivel2){
         jugador.goToWorld(new Nivel3());
        return;
        }
        
    
    
    }
    
    
    
    
    }
}
