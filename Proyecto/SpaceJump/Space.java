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
    private Player Jugador;
    private Shop tienda;
    
    /**
    * Create space.
    */
    public Space()
    {
        super(1500,1300,950,670,0,0);
        Jugador = new Player(400,400);
        tienda = new Shop(500,350);
        Nivel1();
        //Inicializas();
    }
    
    /**
     * hace visible la tienda
     */
    private void MuestraTienda()
    {
        addObject(tienda,500,350);
    }
    
    /**
     * Crea el nivel 1 del juego
     */
    private void Nivel1()
    {
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class,Planet.class);   
        addObject(Jugador);
        Planet p1 = new Planet(700,240,90,150,.9,"1P1.png");
        addObject(p1);
        Moon m1 = new Moon(200,300,10,48,.2,.5,p1,300,"1M1.png");
        addObject(m1);
        Moon m2 = new Moon(200,300,13,29,.2,.4,p1,240,"1M2.png");
        addObject(m2);
        Planet p2 = new Planet(1200,450,80,150,.9,"1P2.png");
        addObject(p2);
        Planet p3 = new Planet(700,700,20,240,.3,"1P3.png");
        addObject(p3);
                
        LeftUI izq=new LeftUI();
        addObject(izq,40,335);
        DownUI upInterface=new DownUI();
        addObject(upInterface,475,640);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void Inicializas()
    {
      setPaintOrder(Image.class,LeftUI.class,DownUI.class,Body.class,Moon.class,Planet.class);   
        Planet nuebo=new Planet(250,250,70,126,.5,"deathStar.png");
        addObject(nuebo);
        Enemy ene = new Enemy(700,400);
        addObject(ene);
        Moon nueba = new Moon(400,400,10,48,.2,.5,nuebo,200,"tierra.png");
        addObject(nueba);
        Planet otro=new Planet(650,450,70,98,.5,"sun.png");
        addObject(otro);
        addObject(Jugador);
        Planet nuebo1=new Planet(1000,1200,70,126,.5,"deathStar.png");
        addObject(nuebo1);
         
    }
}
