import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends ScrollWorld
{
   private Label playerInput;
   private Boton jump;
   String playerName;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {super(1500,1300,950,670,0,0);
        playerName=new String();
     setBackground(new GreenfootImage("menu.jpg"));
     Boton salir= new Boton(900,550,"flecha.png");   
     addObject(salir,880,600);
      jump= new Boton(0,0,"jump_button.png");
     addObject(jump,475,300);
     playerInput=new Label("Click here to add your name ",35);
     Label title=new Label("Ready for a space adventure?",50);
     addObject(title,475,80);
     addObject(playerInput,475,530); 
     
    }
    
    public void act(){
    checkButtons();
    
    }
    
    private void checkButtons(){
        
        if(Greenfoot.mouseClicked(playerInput)){
            playerName=Greenfoot.ask("Write your name");
            playerInput.setValue(playerName);
        playerInput.setLocation(475,530);
            
        }

       
        
        
        if(Greenfoot.mouseClicked(jump)&&!playerName.isEmpty()){
        
       Space levelOne=new Space(playerName);
        Greenfoot.setWorld(levelOne);
        }
    
    
    
    }
    
    
}
