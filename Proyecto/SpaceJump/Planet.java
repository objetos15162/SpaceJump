import java.util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Planet here.
 * 
 * @author (Alfredo granja & Gerardo Enriquez) 
 * @version (2016)
 */
public class Planet extends ScrollActor
{
    private double radio;
    private double rotationSpeed;
    private double rotation; 
    private double mass;
    
    /**
     * Creates a new planet with a the given mass, radio and rotation speed
     */
    public Planet(int x, int y,double masa,double rad,double rotationSpeed )
    {
        super(x,y);  
        radio=rad;
        rotationSpeed=rotationSpeed;
        setImage("default planet.png");
        mass=masa;
    }
     
     public Planet(int x ,int y, double masa,double rad,double rotationSpeed,String imagefile)
     {
        super(x,y);      
        radio=rad;
        rotationSpeed=rotationSpeed;
        mass=masa;
        GreenfootImage imgAux=new GreenfootImage(imagefile); 
        setImage(imgAux);    
     }
    
    /**
     * 
     * makes the planet rotate.
     * @Override.
     */
   public void act() 
    {
      rotate();
      bulletPuff();
     
      super.act();
    
    }    
    
    /**
     * Rotates the planet by the actual rotation velocity
     */
       public void rotate(){
        rotation+=rotationSpeed;
        setRotation((int)rotation);
    
    }
    
    /**
     * Returns the radio of the planet
     */
    public double getRadio(){
    return radio;
}

public double getMass(){
return mass;
}


/**
 * Returns the actual rotation speed
 */

public double getRotationSpeed(){
return rotationSpeed;
} 
    /**
     * Changes the rotation speed by the given factor
     */
public void changeRotationSpeed(double factor){
rotationSpeed*=factor;
}

/**
 * Sets the rotation speed to the given parameter
 */
public void setRotationSpeed(double parameter){
rotationSpeed=parameter;
}

/**
 * removes the bullets from the world when they touch the planet
 * 
 */
public void bulletPuff(){
List<Bullet>bulletsOnSurface=getObjectsInRange((int)radio,Bullet.class);
    getWorld().removeObjects(bulletsOnSurface);
    }
}





