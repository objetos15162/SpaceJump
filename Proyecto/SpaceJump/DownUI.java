import java.util.ArrayList;
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
private ArrayList<Collectable>collectables;
Image generator,turbine,solarModule, amortiguador;

public DownUI(ArrayList<Collectable>ship_pieces, String playerName){

this.collectables=ship_pieces;
this.playerName=new Label(playerName,28);  
setImage("bar_up.png");
playerScore=new Label(0,26);

generator= new Image();
generator.setImage(ship_pieces.get(0).getCurrent());

 turbine=new Image();
turbine.setImage(ship_pieces.get(1).getCurrent());

 solarModule= new Image();
solarModule.setImage(ship_pieces.get(2).getCurrent());

 amortiguador=new Image();
amortiguador.setImage(ship_pieces.get(3).getCurrent());




}

public void update(ArrayList<Collectable> lista,int playerScore){
    this.collectables=lista;
    this.playerScore.setValue(playerScore);
    generator.setImage(collectables.get(0).getCurrent());

 
turbine.setImage(collectables.get(1).getCurrent());


solarModule.setImage(collectables.get(2).getCurrent());


amortiguador.setImage(collectables.get(3).getCurrent());



}


protected void addedToWorld(World world){
    
    
    world.addObject(playerName,800,600);
    world.addObject(playerScore,800,630);
    world.addObject(generator,200,630);
    world.addObject(turbine,300,630);
    world.addObject(solarModule,400,630);
    world.addObject(amortiguador,500,630);
    


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
