import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* This class is used to manage the behavior of the player in Space jump, the controls, the animations showed while
* the player acts and other parameters needed for the plyer
*
* @author Alfredo Granja && Gerardo Enriquez
* @version 2016
*/
public class Enemy extends Body
{
    private int vida,puntos;
    private boolean on_feet,impulsing,lookingAt;
    private double direction;
    
    /**
    * Creates a player with a position in the global world.
    * @param x The coordinate x in the global world.
    * @param y The coordinate y in the global world.
    */
    public Enemy(int x, int y)
    {
        super(x,y,13,new Vector(0,0),new Vector((int)0,(double)1),"skullRightN.png");
        lookingAt=false;
        on_feet=false;
        direction=0;
        impulsing=false;
        vida=300;
        puntos=0;
    }
    
    /**
    * @Override.
    * this method overrides the Greenfoot method and calls the methods needed for the player to act.
    *
    */
    public void act()
    { 
        image();
        super.act();
    }
    
    /**
    * This method is used for setting the current image to be shown of the player based on the action
    * and orientation of the player.
    */
    private void image()
    {
        if(lookingAt&&!impulsing)
        setImage("skullRightN.png");
        
        if(!lookingAt&&!impulsing)
        setImage("skullLeftN.png");
        
        if(lookingAt&&impulsing)
        setImage("skullRight.png");
        
        if(!lookingAt&&impulsing)
        setImage("skullLeft.png");
    }
    
    /**
    * method used to set the scroll of the world based on the coordinates in the window of the player
    */
    
    public void scrollAdjust()
    {
        if(getCameraX()>=getScrollWorld().getWindowWidth()-110)
        getScrollWorld().scrollRight();
        
        if(getCameraY()>=getScrollWorld().getWindowHeight()-110)
        getScrollWorld().scrollDown();
        
        if(getCameraX()<=110)
        getScrollWorld().scrollLeft();
        
        if(getCameraY()<=110)
        getScrollWorld().scrollUp();
    }
    
     /**
    * makes the player rotate to the left.
    */
    private void rotateLeft()
    {
        direction-=1.2;
        setRotation((int)direction);
    }
    
    /**
    * Makes the player rotate to the right.
    *
    */
    private void rotateRight()
    {
        direction+=1.2;
        setRotation((int)direction);
    }
    
    /**
    * makes the player rotate by -180 degrees
    *
    */
    private void turnLeft()
    {
        // esta parte del codigo debe cambiar la direccion hacia donde mira el jugador para que dispare en esa direccion
        //
        lookingAt=false;
    }
    
    /**
    * makes the player rotate by 180 degrees
    *
    */
    private void turnRight()
    {
        // esta parte del codigo debe cambiar la direccion hacia donde mira el jugador para que dispare en esa direccion
        //
        lookingAt=true;    
    }
}
