import greenfoot.*;  // (World, Image, Image, Greenfoot and MouseInfo)

/**
 * This class is made to implement a part of the user interface which shows the amount of fuel and helat that the player has.
 * 
 * @author (Alfredo Granja) 
 * @version (2016, may)
 */
public class LeftUI extends Actor
{

    private Image healthBar;
    private Image fuelBar;
    private Image playerIcon;
    private Image gasIcon;

    private int healthMax;
    private int fuelMax;

    /**
     * Constructor- initializes the variables of images used by the bar and sets the maximum health and fuel to 200.
     */

    public LeftUI(){
        setImage("leftsidebar.png");
        healthBar=new Image();
        healthBar.setImage("health_bar2.png");
        fuelBar=new Image();
        fuelBar.setImage("fuel_bar.png");
        playerIcon=new Image();
        playerIcon.setImage("player_ico.png");
        gasIcon=new Image();
        gasIcon.setImage("gas_ico.png");
        healthMax=200;
        fuelMax=200;}

    /**
     * Constructor- initializes the variables of images used by the bar.
     */

    public LeftUI(int fuelMaximum, int healthMaximum){
        setImage("leftsidebar.png");
        healthBar=new Image();
        healthBar.setImage("health_bar.png");
        fuelBar=new Image();
        fuelBar.setImage("fuel_bar.png");
        playerIcon=new Image();
        playerIcon.setImage("player_ico.png");
        gasIcon=new Image();
        gasIcon.setImage("gas_ico.png");
        healthMax=healthMaximum;
        fuelMax=fuelMaximum;

    }

    /**
     * @Override overriden to add all the images contained on the bar to the world.
     * 
     */
    protected void addedToWorld(World world){
        world.addObject(fuelBar,19,327);    
        world.addObject(healthBar,48,327);   
        world.addObject(playerIcon,53,553);   
        world.addObject(gasIcon,20,555);   
    }

    /**
     * Changes the size of the helat bar calculating the size with te value given and the maximum of the bar  
     * 
     */
    private void setHealthSize(float lifeAmount){
        if(lifeAmount<=healthMax){

            float scale;
            scale=(float)lifeAmount/healthMax*480;  //480 is the actual size of the bar image in pixels
            float movY=480-scale;
            healthBar.getImage().clear();
            healthBar.getImage().drawImage(new GreenfootImage("health_bar2.png"),0,(int)movY);
        }
    }

    /**
     * Changes the size of the fuek bar calculating the size with te value given and the maximum of the bar  
     * 
     */
    private void setFuelSize(float fuelAmount){
        if(fuelAmount<=fuelMax){

            float scale;
            scale=(float)fuelAmount/fuelMax*480;  //480 is the actual size of the bar image in pixels
            float movY=480-scale;
            fuelBar.getImage().clear();
            fuelBar.getImage().drawImage(new GreenfootImage("fuel_bar.png"),0,(int)movY);
        }      

    }

    /**
     * updates the user interface acording to the fuel and health levels.
     * @param fuel The amount of fuel.
     * @param health The amount of health.
     */ 

    public void updateValues(float fuel, float health ){
        setHealthSize(health);
        setFuelSize(fuel);

    }

}
