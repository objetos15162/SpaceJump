import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A 'Body' is any kind of object in space that has a mass. It could be a star, or a planet, 
 * or anything else that floats around in space.
 * 
 * @author Michael Kolling 
 * @version 0.1
 */
public class Body extends ScrollActor

{
    // constants
    private static final double GRAVITY =5.8;
    private static final Color defaultColor = new Color(255, 216, 0);
    
    // fields
    private double mass;
    private Vector movement;
    private Vector rotationVector;
    private double exactX;
    private double exactY;
    private Planet planet_over;
    
    
    /**
     * Construct a Body with default size, mass, movement and color.
     */
    public Body()
    {
        this (0,0,20, 30, new Vector(0, 0),new Vector((int)0,(double)1),"lemur.png");
    }
    
    public Body(double x ,double y,int size, double mass, Vector move,Vector rot,String imagefile)
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
         applyFriction();
       move();
       super.act();
    }
    
   public void aplicaGravedad()
    {
        List<Planet> Listaplanetas = getWorld().getObjects(Planet.class);
        for (Planet otro : Listaplanetas)
        {
           daleGravedad(otro);
        }
    }
    
    private void daleGravedad(Planet otro)
    {
        Vector distancia=getDistance(otro);
        double fuerza = ((otro.getMass() * this.mass) / (distancia.getLength() * distancia.getLength())) * GRAVITY;
        Vector vector = new Vector(distancia.getX(),distancia.getY());
        double aceleracion = fuerza/this.mass;
        vector.setLength(aceleracion);
        addForce(vector);
    }
    
    public Vector getMovement(){
    return movement;}
    
    private void applyFriction()
    {
      if (isTouching(Planet.class)){
       // movement.scale(.1);
        
        }
      
    }
    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
    public Planet getPlanetOver(){
    
    return(planet_over);
    }
    public double getExactX() 
    {
        return exactX;
    }

    
    public double getExactY() 
    {
        return exactY;
    }
    
    
      public void addForce(Vector force) 
    {
        movement.add(force);
    }
    
     public void move() 
    {
         setLocation((float)(getWorldX()+movement.getX()),(float)(getWorldY()+movement.getY()));
        
    }
    
     public void setLocation(int x, int y) 
    {
        setLocation((getWorldX()+movement.getX()),(getWorldY()+movement.getY()));
      }
    
    
       
   /**
         * @Override
         */
        public void setRotation(int rotation){
            rotationVector.setDirection(rotation);
            super.setRotation((int)rotationVector.getDirection());
        
        } 
        
        
        public Vector getRotationVector(){
    return rotationVector;
}
        
  private Planet applyNormalForce(){
     Planet apllies=null;  
     List <Planet> planets ;    
     planets= getObjectsInRange(200,Planet.class);
    
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
    
}



