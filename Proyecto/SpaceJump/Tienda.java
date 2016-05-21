import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Tienda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tienda extends ScrollWorld
{
 
   
    private Boton Bg,Bh,Bb,Exit,fondo;


    /**
     * Constructor for objects of class Tienda.
     * 
     */
    public Tienda()
    {
        super(1500,1300,950,670,0,0);
 setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class,Enemy.class); 
		fondo=new Boton(510,300,"Tienda.png");
		
        Bg = new Boton(400,300,"gasShop.png");
        Bh = new Boton(510,300,"lifeShop.png");
        Bb = new Boton(620,300,"bullet.png");
        
        Exit = new Boton(655,135,"flecha.png");
        
        CreaBarras();
        MuestraTienda();
        setBackground("tiendabg.png");
    }
    
    /**
     * 
     */
    public void act()
    {
        buy();
        
            
        
     }
     
    /**
     * hace visible la tienda
     */
    private void MuestraTienda()
    {
           addObject(fondo,fondo.getsX(),fondo.getsY());
           addObject(Bg,Bg.getsX(),Bg.getsY());
             addObject(Bh,Bh.getsX(),Bh.getsY());
              addObject(Bb,Bb.getsX(),Bb.getsY());
               addObject(Exit,Exit.getsX(),Exit.getsY());
        
     }
     
      public void buy()
    {
        
        
        if(Greenfoot.mouseClicked(Bg) && getJugador().getDinero()>=20)
        {
            getJugador().cambiaDinero(-20);
            getJugador().aumentaGas();
        }
        
        if(Greenfoot.mouseClicked(Bh) && getJugador().getDinero()>=100)
        {
            getJugador().cambiaDinero(-100);
            getJugador().setVida();
        }
        
        if(Greenfoot.mouseClicked(Bb) && getJugador().getDinero()>=50)
        {
            getJugador().cambiaDinero(-50);
            getJugador().setVida();
        }
         
        if(Greenfoot.mouseClicked(Exit))
        {
            getJugador().goToWorld(getJugador().getPreviousWorld());
            System.out.println("dsds");
        }
        
        
        
    }
}