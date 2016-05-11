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
     * 
     */
    public ScrollWorld getScrollWorld()
    {
        return world;
    }
    
    /**
     * 
     */
    public void setScrollWorld(ScrollWorld scWorld)
    {
        world=scWorld;
    }
    
    /**
     * 
     */
    public ScrollActor(double x, double y)
    {
        worldX=x;
        worldY=y;
        onCamera=false;
    }
    
    /**
     * 
     */
    public double getWorldX()
    {
        return worldX;
    }
    
    /**
     * 
     */
    public double getWorldY()
    {
        return worldY;
    }
    
    /**
     * 
     */
    public int getCameraX()
    {
        return windowX;
    }
    
    /**
     * 
     */
    public int getCameraY()
    {
        return windowY;
    }
    
    /**
     * 
     */
    protected void addedToWorld(World world)
    {
      
    }
    
    /**
     * @Override 
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
     * 
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
     * 
     */
    public void setVisibility(boolean visibility)
    {
        onCamera=visibility;    
    }
    
    /**
     * 
     */
    public Vector getDistance(ScrollActor otro)
    {
        double dx = otro.getWorldX() - getWorldX();
        double dy = otro.getWorldY() - getWorldY();
        Vector vector = new Vector(dx,dy);
        return vector;
    }
    
    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    

    /**
     * Move forward in the current direction.
     */
    public void move()
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
        
        setLocation(x, y);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    
    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}