
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
   
   public Vector getAim()
   {
       return aim;
   }
    
   public void equipar(Player usuario)
   {
       player=usuario; 
   }  
    
   public boolean impulse()
   {  
       if(!isEmpty()){   
       Body bAux =(Body)player;
       bAux.addForce(aim);
       player.setImage("skullRight.png");
         gas-=.2;
        return true;
        } 
        return false;
   }  
    
    public boolean isEmpty()
    {
        if(gas<=0)
        return true;
        else return false;    
    }
    
    public double getGas(){
    return gas;}
  
  public void turnLeft()
  {
     direction-=1.2;     
     player.setRotation((int)direction);
     aim.setDirection((int)(direction-90));
  }
  
  public void turnRight()
  {
      direction+=1.2;
      player.setRotation((int)direction);
      aim.setDirection((int)(direction-90));
  }
}
    
    
   
 
  