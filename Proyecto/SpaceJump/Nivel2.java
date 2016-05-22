import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends ScrollWorld
{
    
    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2()
    {
        super(1500,1300,950,670,0,0);
       
        Nivel2();
    }
        
    /**
     * crea el nivel 2
     */
    public void Nivel2()
    {
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class,Enemy.class);   
        
        
        Planet p1 = new Planet(800,900,100,130,.5,"P11-0.png");
        addObject(p1);
        Planet p2 = new Planet(1500,300,100,125.5,.5,"P13.png");
        addObject(p2);
        Moon m1 = new Moon(1700,300,13,75,.2,.5,p2,200,"1M4.png");
        addObject(m1);
        Moon m2 = new Moon(1950,400,13,75,.2,.4,p2,250,"1M5.png");
        addObject(m2);
        Planet p3 = new Planet(600,240,60,77.5,.5,"P14.png");
        addObject(p3);
        Planet p4 = new Planet(1900,1240,60,312.5,.5,"P37.png");
        addObject(p4);
        
        Enemy1 ene = new Enemy1(1200,1800);
        addObject(ene);
        SolarModule modu = new SolarModule(1250,1750);
        addObject(modu);
        Enemy1 ene1 = new Enemy1(1000,800);
        addObject(ene1);
        Amortig amor = new Amortig(950,750);
        addObject(amor);
        Enemy2 ene2 = new Enemy2(600,400);
        addObject(ene2);
        Enemy2 ene3 = new Enemy2(1600,1400);
        addObject(ene3);
        
        Money dinero= new Money(800,700);
        addObject(dinero);
        Money dinero6= new Money(1200,1650);
        addObject(dinero6);
        Money dinero1= new Money(1400,1600);
        addObject(dinero1);
        Money dinero2= new Money(1600,1300);
        addObject(dinero2);
        Money dinero3= new Money(1400,150);
        addObject(dinero3);
        Money dinero4= new Money(850,400);
        addObject(dinero4);
        Money dinero5= new Money(600,1400);
        addObject(dinero5);
        
        CreaBarras();
    }
}
