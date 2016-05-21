import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import java.io.*;

/**
 * Space. The final frontier. 
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends ScrollWorld
{
    /**
    * Create space.
    */
    public Space()
    {
        super(1500,1300,950,670,0,0);
     
        Nivel1();
    }
   
    /**
     * Crea el nivel 1 del juego
     */
    private void Nivel1()
    {
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class,Enemy.class);   
        
        Planet p1 = new Planet(700,240,90,150,.9,"1P1.png");
        addObject(p1);
        Moon m1 = new Moon(1000,300,10,48,.2,.5,p1,300,"1M1.png");
        addObject(m1);
        Moon m2 = new Moon(940,300,13,29,.2,.4,p1,240,"1M2.png");
        addObject(m2);
        Planet p2 = new Planet(1800,450,100,150,.9,"1P2.png");
        addObject(p2);
        Planet p3 = new Planet(2000,1300,100,150,.3,"1P3.png");
        addObject(p3);
        
        Planet p5 = new Planet(800,1200,150,180,.5,"P18.png");
        addObject(p5);
        Enemy1 ene = new Enemy1(1000,700);
        addObject(ene);
        Enemy1 ene1 = new Enemy1(950,1700);
        addObject(ene1);
        Enemy2 ene2 = new Enemy2(1600,900);
        addObject(ene2);
        Turbine turbine=new Turbine(900,1700);
        Money dinero= new Money(800,700);
        addObject(dinero);
        addObject(turbine);
        super.CreaBarras();
    }
     
}
