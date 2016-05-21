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
    public Nivel3()
    {
        super(1500,1300,950,670,0,0);
        
        Nivel3();
    }
    
    /**
     * crea el nivel 3
     */
    public void Nivel3()
    {
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class,Enemy.class);   
        
        
        Planet p1 = new Planet(1400,900,300,440,.5,"P38.png");
        addObject(p1);
        Moon m1 = new Moon(2100,900,40,75,.2,.5,p1,700,"1P4.png");
        addObject(m1);
        Moon m2 = new Moon(2500,900,40,75,.2,.4,p1,1100,"1P4.png");
        addObject(m2);
        Generator moderato = new Generator(1000,1900);
        addObject(moderato);
        Enemy1 ene = new Enemy1(1900,1200);
        addObject(ene);
        Enemy1 ene1 = new Enemy1(900,200);
        addObject(ene1);
        Enemy2 ene2 = new Enemy2(600,400);
        addObject(ene2);
        Enemy2 ene3 = new Enemy2(1600,1400);
        addObject(ene3);
        CreaBarras();
    }
}
