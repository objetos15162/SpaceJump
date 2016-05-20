import java.util.List;
import java.util.ArrayList;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to manage the behavior of the player in Space jump, the controls, the animations showed while
 * the player acts and other parameters needed for the player
 *
 * @author Alfredo Granja && Gerardo Enriquez
 * @version 2016
 */
public class Player extends Body
{   private ArrayList <Collectable>pieces;
    private int vida,dinero,score;
    private String name;
    private Jetpack jetpack;
    private boolean on_feet,impulsing,lookingAt,isDown;
    private double direction;
    private Pistol pistol;

    /**
     * Creates a player with a position in the global world.
     * @param x The coordinate x in the global world.
     * @param y The coordinate y in the global world.
     */
    public Player(int x, int y, String name)
    {

        super(x,y,13,new Vector(0,0),new Vector((int)0,(double)1),"skullRightN.png");
        this.name=name; 
        pistol = new Pistol(this);
        isDown=false;
        lookingAt=true;
        jetpack=new Jetpack();
        jetpack.equipar(this);
        on_feet=false;
        direction=0;
        impulsing=false;
        dinero=150;
        setVida();
        pieces=new ArrayList<Collectable>(); 
        pieces.add(new Generator());
        pieces.add(new Turbine());
        pieces.add(new SolarModule());
        pieces.add(new Amortig());

    }

    /**
     * @Override.
     * this method overrides the Greenfoot method and calls the methods needed for the player to act.
     *
     */
    public void act()
    { updateUI();
        impulsing=false;
        controls();
        scrollAdjust();
        image();
        super.act();
        impactos();
        collect();
    }

    /**
     * Suma el valor de A al valor de vida
     * @param A valor que sumara a dinero
     */
    public void cambiaVida(int A)
    {
        vida+=A;
    }

    /**
     * Asigna un valor a vida
     */
    public void setVida()
    {
        vida=200;
    }

    /**
     * agrega mas balas a la pistola
     */
    public void addBullets()
    {
        pistol.addBullets();
    }

    /**
     * Aumenta el valor de gas
     */
    public void aumentaGas()
    {
        jetpack.cambiaGas(30);
    }

    /**
     * Suma el valor de i al valor de dinero
     * @param i valor que se sumara a dinero
     */
    public void cambiaDinero(int i)
    {
        dinero+=i;
    }

    /**
     * @return regresa el valor de dinero
     */
    public int getDinero()
    {
        return dinero;
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

        if(Greenfoot.isKeyDown("V"))
        {
            if(lookingAt)
            {
                turnLeft();
            }
            else turnRight();

        }

        if(Greenfoot.isKeyDown("X"))
            rotateLeft();

        if(Greenfoot.isKeyDown("C"))
            rotateRight();

        if(Greenfoot.isKeyDown("B"))
            pistol.setType(2);

        if(Greenfoot.isKeyDown("N"))
            pistol.setType(1);

        if(Greenfoot.isKeyDown("M"))
            pistol.setType(3);

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
     * shoot a bullet
     */
    private void shoot()
    {
        if(pistol.getBullets()>0  && !isDown && Greenfoot.isKeyDown("space"))
        {
            isDown=true;
            if(lookingAt)
                getScrollWorld().addObject(pistol.getNewBullet(2,getRotationVector()));
            else
            {
                Vector juan = getRotationVector();
                juan.setDirection((int)(direction+180));
                getScrollWorld().addObject(pistol.getNewBullet(2,juan));

            }
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
            cambiaVida(-5);
        }

        if(atWorldEdge())
            stop();
        if(vida<=0)
            Greenfoot.stop();
    }

    private void stop(){
        Vector vAux=getMovement();
        vAux.revertHorizontal();
        vAux.revertVertical();
        vAux.scale(.5);

    }

    private void updateUI(){
        List<LeftUI>leftUIList=getWorld().getObjects(LeftUI.class);
        if(!leftUIList.isEmpty()){
            LeftUI leftUIAux=leftUIList.get(0);
            leftUIAux.updateValues((float)jetpack.getGas(),(float)vida);

        } 

    
        List<DownUI>DownUIList=getWorld().getObjects(DownUI.class);
        if(!DownUIList.isEmpty()){
            DownUI DownUIAux=DownUIList.get(0);
            DownUIAux.update(pieces,score);

        } 

    }

    public ArrayList<Collectable> getPieces(){

        return pieces;}

    public String getName()
    {return name;}

    private void collect(){
        List<Collectable> collected=getObjectsInRange(50,Collectable.class);
        for (Collectable cAux: collected){

            if(cAux instanceof Generator ){
                pieces.get(0).found();
                score+=200;

            }
            if(cAux instanceof Turbine ){
                pieces.get(1).found();
                score+=200;

            }
            if(cAux instanceof SolarModule ){
                pieces.get(2).found();
                score+=200;

            }
            if(cAux instanceof Amortig ){
                pieces.get(3).found();
                score+=200;

            }
            if(cAux instanceof Money){
                dinero++;
            }
            removeTouching(Collectable.class);

        }
    }
    
}
