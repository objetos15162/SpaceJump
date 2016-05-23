import java. util.ArrayList;
import java. util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollActor extends Actor
{
    private double worldX;
    private double worldY;
    private int windowY;
    private int windowX;
    private boolean onCamera;
    private ScrollWorld world;
    private static final double WALKING_SPEED = 5.0;
    
    /**
     * Act - do whatever the ScrollActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //      
    } 
    
    /**
     * sets the x and y coordinates
     */
    public void setXY(int x,int y)
    {
        worldX=x;
        worldY=y;
    }
    
    /**
     * @return the ScrollWorld where this actor lives.
     */
    public ScrollWorld getScrollWorld()
    {
        return world;
    }
    
    /**
     * Sets the variable ScrollWorld of this object to the given ScrollWorld variable.
     */
    public void setScrollWorld(ScrollWorld scWorld)
    {
        world=scWorld;
    }
    
    /**
     * Constructor- creates a new ScrollActor with the given world cordinates.
     * @param x the global x cordinate in the world.
     * @param y the global y cordinate in the world.
     */
    public ScrollActor(double x, double y)
    {
        worldX=x;
        worldY=y;
        onCamera=false;
    }
    
    /**
     * @return the global x cordinate.
     */
    public double getWorldX()
    {
        return worldX;
    }
    
    /**
     * @return the global y cordinate.
     */
    public double getWorldY()
    {
        return worldY;
    }
    
    /**
     * @return the cordinate that represents the x position in the window .
     */
    public int getCameraX()
    {
        return windowX;
    }
    
    /**
     * @return the cordinate that represents the y position in the window .
     */
    public int getCameraY()
    {
        return windowY;
    }
    
    /**
     * @Override -overriden to set the position in the global world
     */
    public void setLocation(double x, double y)
    {
         worldX=x;
         worldY=y;
         updateMyCoords();
         if(getWorld()!=null){  
          super.setLocation(windowX,windowY);}
         
    }
  
    /**
     * Updates the world global cordinates and the window cordinates of this object
     */
    public void updateMyCoords()
    {
        int scrlX, scrlY;
        scrlX=((ScrollWorld)getScrollWorld()).getScrollX();
        scrlY=((ScrollWorld)getScrollWorld()).getScrollY();
        windowX=(int)worldX-scrlX;
        windowY=(int)worldY-scrlY;
        if(getWorld()!=null)
         super.setLocation(windowX,windowY);
    }
    
    
    
     /**
     * Calculates the distance between two actors.
     * @param otro the object from where the distance is calculated.
     * @return a Vector class object that represents the distance between the two objects.
     */
    public Vector getDistance(ScrollActor otro)
    {
        double dx = otro.getWorldX() - getWorldX();
        double dy = otro.getWorldY() - getWorldY();
        Vector vector = new Vector(dx,dy);
        return vector;
    }
    
    

}