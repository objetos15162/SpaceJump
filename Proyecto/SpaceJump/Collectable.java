import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to represent an item that the player must collect, when the player has found the piece it shows a color image in the 
 * interface, while the player has not found the item it shows an grayscale image;
 * 
 * @author this clas (Alfredo Granja) 
 * @version (May of 2016)
 */
public class Collectable extends ScrollActor
{
   
    boolean collected;
    private String name;
    private GreenfootImage found;
    private GreenfootImage notFound;
    private GreenfootImage current;
    
    
    public Collectable(String colorImage,String grayScaleImage, float x,float y){
    super(x,y);    
    collected=false;
    this.name=name;
    found=new GreenfootImage(colorImage);
    notFound=new GreenfootImage(grayScaleImage);
    current=notFound;
    setImage(found);
    }
    
    public Collectable(String colorImage,String grayScaleImage){
    super(0,0);    
    collected=false;
    
    found=new GreenfootImage(colorImage);
    notFound=new GreenfootImage(grayScaleImage);
    current=notFound;
    setImage(found);
    }
    
    /**
     * mark the object as collected and updates its image
     * 
     */
    
    public void found(){
    collected=true;
    current=found;
    
    }
    /**
     * checks if the object has been found by the player 
     * @return true if the object has been found, else returns false.
     * 
     */
    
    public boolean isCollected(){
    return collected;
    
    }
    
    /**
     * @return  the current Greenfoot image
     */
    public GreenfootImage getCurrent(){
    return current;}
    
}
