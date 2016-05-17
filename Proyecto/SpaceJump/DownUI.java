import java.util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * parto of the user interface in Space Jump it shows the name of the player, score and objects collected
 * 
 * @author (Alfredo Granja) 
 * @version (may of 2016)
 */
public class DownUI extends Actor{


private Label playerName;
private Label playerScore;
private List<Collectable>collectables;

public DownUI(){

playerName=new Label("Juanito",28);  
setImage("bar_up.png");
playerScore=new Label(0,26);


}


protected void addedToWorld(World world){
    
    
    world.addObject(playerName,500,600);
    world.addObject(playerScore,520,630);


}

   /**
     * Act - do whatever the UpUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
