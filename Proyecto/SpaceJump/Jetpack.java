
/**
 * Write a description of class Jetpack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jetpack
{
    private double direction;
    private Vector aim;
    private double gas;
    private Player player;

    public Jetpack()
    {
        aim=new Vector();
        aim.setLength(.056);
        aim.setDirection((int)(-90));
        gas=150;
        player=null;
    }

    /**
     *@return the Vector that indicates the aim direction of the jetpack  
     * 
     */
    public Vector getAim()
    {
        return aim;
    }

    /**
     * links the player with the jetpack.
     * @param usuario the player to link the jetpack to.
     */
    public void equipar(Player usuario)
    {
        player=usuario; 
    }  

    /**
     * makes the jetpack impulse the player.
     */
    public boolean impulse()
    {  
        if(!isEmpty()){   
            Body bAux =(Body)player;
            bAux.addForce(aim);
            player.setImage("skullRight.png");
            gas-=.06;
            return true;
        } 
        return false;
    }  

    /**
     * @return true if the jetpack has no fuel, otherwise returns false.
     */
    public boolean isEmpty()
    {
        if(gas<=0)
            return true;
        else return false;    
    }

    /**
     * @param i valor que se sumara a gas
     * Suma i a gas
     */
    public void cambiaGas(int i)
    {
        gas+=i;
    }

    /**
     * @return the amount of gas in the jetpack.
     */
    public double getGas(){
        return gas;}

    /**
     * makes the jetpack and the player turn left
     * 
     */
    public void turnLeft()
    {
        direction-=1.2;     
        player.setRotation((int)direction);
        aim.setDirection((int)(direction-90));
    }

    /**
     * makes the jetpack and the player turn right.
     */
    public void turnRight()
    {
        direction+=1.2;
        player.setRotation((int)direction);
        aim.setDirection((int)(direction-90));
    }
}

  