import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to create an object that reacts to gravity, and has movement in a certain direction, its based on the class Body made of the project Newton´s lab made by Michael Koolling
 * 
 * 
 * @author Alfredo granja, Gerardo enriquez
 * @version  may of 2016
 */
public class Body extends ScrollActor

{
    
    private static final double GRAVITY =5.8;
 
    private static final double WALKING_SPEED = 5.0;
    

    private double mass;
    private Vector movement;
    private Vector rotationVector;
    private Planet planet_over;
    
    
    /**
     * Construct a Body with default size, mass, movement.
     */
    public Body()
    {
        this (0,0, 30, new Vector(0, 0),new Vector((int)0,(double)1),"lemur.png");
    }
    
    public Body(double x ,double y, double mass, Vector move,Vector rot,String imagefile)
    {   super(x,y);
        this.mass = mass;
        movement=new Vector(0,0);
        rotationVector=new Vector((int)0,(double)1);
        addForce(move);
        GreenfootImage image = new GreenfootImage (imagefile);
      setImage (image);
       planet_over=null;
    }
    
    /**
     * Act. That is: apply  the gravitation forces from
     * all other bodies around, and then move.
     */
    public void act() 
    {
        
       
        planet_over=applyNormalForce();
        //if(planet_over==null)
        aplicaGravedad();
        //else
    
       move();
       super.act();
    }
   /**
    * checks the objects around to calculate the gravity
    */ 
   public void aplicaGravedad()
    {
        List<Planet> Listaplanetas = getWorld().getObjects(Planet.class);
        for (Planet otro : Listaplanetas)
        {
           daleGravedad(otro);
        }
    }
    /**
     *Apllies gravity force to the body object. 
     */
    private void daleGravedad(Planet otro)
    {
        Vector distancia=getDistance(otro);
        double fuerza = ((otro.getMass() * this.mass) / (distancia.getLength() * distancia.getLength())) * GRAVITY;
        Vector vector = new Vector(distancia.getX(),distancia.getY());
        double aceleracion = fuerza/this.mass;
        vector.setLength(aceleracion);
        addForce(vector);
    }
    /**
     * @return the movement vector
     */
    
    public Vector getMovement(){
    return movement;}
    
    
    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
    
  
    
    /**
     * ads a force to the body.
     *@param force a vector that describes the direction and magnitude of the force
     */
      public void addForce(Vector force) 
    {
        movement.add(force);
    }
    /**
     * makes the body move to the next position according to its movement vector
     */
     public void move() 
    {
         setLocation((float)(getWorldX()+movement.getX()),(float)(getWorldY()+movement.getY()));
        
    }
    /**
     * sets the location using the global cordinates
     */
     public void setLocation(int x, int y) 
    {
        setLocation((getWorldX()+movement.getX()),(getWorldY()+movement.getY()));
      }
    
    
       
   /**
         * @Override   sets the rotation and the direction of the rotation vector
         */
        public void setRotation(int rotation){
            rotationVector.setDirection(rotation);
            super.setRotation((int)rotationVector.getDirection());
        
        } 
        
        /**
         * @return the rotation vector
         */
        public Vector getRotationVector(){
    return rotationVector;
}
        

/**
 * applies a normal force to the body when it touches the planets
 */
  private Planet applyNormalForce(){
     Planet apllies=null;  
     List <Planet> planets ;    
     planets= getObjectsInRange(600,Planet.class);
    
     for (Planet p:planets){
         
         if(getDistance(p).getLength()<=p.getRadio()){
             Vector unitario_mi_aceleracion=new Vector();
             unitario_mi_aceleracion.setLength(1);
             unitario_mi_aceleracion.setDirection(movement.getDirection());
             Vector unitario_distancia_planeta=new Vector();
             unitario_distancia_planeta.setLength(1);
             unitario_distancia_planeta.setDirection(getDistance(p).getDirection());
             unitario_distancia_planeta.revertHorizontal();
             unitario_distancia_planeta.revertVertical();
             unitario_distancia_planeta.add(unitario_mi_aceleracion);
             unitario_distancia_planeta.scale(.2);
             movement=unitario_distancia_planeta;
             apllies=p;
            
        }
       }
        return(apllies);
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
        Actor actor = getOneObjectAtOffset( 0, 0, clss);
        return actor != null;        
    }
}



