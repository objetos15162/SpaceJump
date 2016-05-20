import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends ScrollWorld
{
    
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3(Player Jugador)
    {
        super(1500,1300,950,670,0,0);
        setJugador(Jugador);
        Nivel3();
    }
    
    /**
     * crea el nivel 3
     */
    public void Nivel3()
    {
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class,Enemy.class);   
        addObject(getJugador());
        
        Planet p1 = new Planet(1400,900,300,440,.5,"P38.png");
        addObject(p1);
        Moon m1 = new Moon(2100,900,40,75,.2,.5,p1,700,"1P4.png");
        addObject(m1);
        Moon m2 = new Moon(2500,900,40,75,.2,.4,p1,1100,"1P4.png");
        addObject(m2);
        
        CreaBarras();
    }
}
