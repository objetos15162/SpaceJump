import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* This class is used to manage the behavior of the player in Space jump, the controls, the animations showed while
* the player acts and other parameters needed for the plyer
*
* @author Alfredo Granja && Gerardo Enriquez
* @version 2016
*/
public class Player extends Body
{
    private int vida;
    private String Name;
    private Jetpack jetpack;
    private boolean on_feet,impulsing,lookingAt;
    private double direction;
    private Pistol pistol;
    private boolean isDown;
    
    /**
    * Creates a player with a position in the global world.
    * @param x The coordinate x in the global world.
    * @param y The coordinate y in the global world.
    */
    public Player(int x, int y)
    {
        super(x,y,13,new Vector(0,0),new Vector((int)0,(double)1),"skullRightN.png");
        pistol = new Pistol(this);
        isDown=false;
        lookingAt=true;
        jetpack=new Jetpack();
        jetpack.equipar(this);
        on_feet=false;
        direction=0;
        impulsing=false;
        vida=300;
    }
    
    /**
    * @Override.
    * this method overrides the Greenfoot method and calls the methods needed for the player to act.
    *
    */
    public void act()
    { 
        impulsing=false;
        controls();
        scrollAdjust();
        image();
        super.act();
        impactos();
    }
    
    /**
     * Suma el valor de A al valor de vida
     */
    public void aumentaVida(int A)
    {
        vida+=A;
    }
    
    /**
     * Resta el valor de vida con el valor de B
     */
    public void restaVida(int B)
    {
        vida-=B;        
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
        if(getCameraX()>=getScrollWorld().getWindowWidth()-600)
        getScrollWorld().scrollRight();
        
        if(getCameraY()>=getScrollWorld().getWindowHeight()-250)
        getScrollWorld().scrollDown();
        
        if(getCameraX()<=600)
        getScrollWorld().scrollLeft();
        
        if(getCameraY()<=250)
        getScrollWorld().scrollUp();
    }
    
    /**
    * Captures the inputs of the keyboard and calls the apropiated methods according to make the player act.
    */
    
    public void controls()
    {
        if(Greenfoot.isKeyDown("Z")){
        boolean gas= jetpack.impulse();
        if(gas){
        impulsing=true;;
        }
        
        }
        if(Greenfoot.isKeyDown("A"))
        turnLeft();
        
        if(Greenfoot.isKeyDown("D"))
        turnRight();
        
        if(Greenfoot.isKeyDown("Q"))
        rotateLeft();
        
        if(Greenfoot.isKeyDown("E"))
        rotateRight();
        
        shoot();
    }
    
    /**
    * makes the player rotate to the left.
    */
    private void rotateLeft()
    {
        direction-=1.2;
        setRotation((int)direction);
        jetpack.getAim().setDirection((int)(direction-90));
    }
    
    /**
     * 
     */
    private void shoot()
    {
        if(pistol.getBullets()>0  && !isDown && Greenfoot.isKeyDown("space"))
        {
            isDown=true;
            getScrollWorld().addObject(pistol.getNewBullet(getWorldX(),getWorldY(),20,getRotationVector(),new Vector(),"lemur.png"));
        }
        if(isDown && !Greenfoot.isKeyDown("space"))
            isDown=false;
                    
    }
    
    /**
    * Makes the player rotate to the right.
    *
    */
    private void rotateRight()
    {
        direction+=1.2;
        setRotation((int)direction);
        jetpack.getAim().setDirection((int)(direction-90));
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
    
    /**
     * 
     */
    private void impactos()
    {
        if(canSee(Moon.class))
        {
            restaVida(10);
        }
            
        if(atWorldEdge())
            turn(50);
        /*if(vida<=0)
            Greenfoot.stop();*/
    }
}
