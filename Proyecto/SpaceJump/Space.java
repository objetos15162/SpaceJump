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
    private ArrayList<Moon> Lunas;
    private ArrayList<Planet> Planetas;
    private Player Jugador;
    private GreenfootImage Scenario;
    
    /**
    * Create space.
    */
    public Space()
    {
        super(1500,1300,950,670,0,0);
        Jugador = new Player(400,400);
        addObject(Jugador);
        CreaNivel("test.txt");
        Inicializas();
    }
    
    /**
     * Crea los niveles del juego
     */
    private void CreaNivel(String arch)
    {
        setPaintOrder(Body.class,Moon.class,Planet.class);   
        int type,x,y,index;
        String nombre,txt;
        double masa,rad,speed,rv,tv;
        float dist;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(arch));
            while((txt = br.readLine()) != null)
            {
                type = Integer.parseInt(txt);
                switch(type)
                {               
                    case 1:
                    x = Integer.parseInt(br.readLine());
                    y = Integer.parseInt(br.readLine());
                    masa = Double.parseDouble(br.readLine());
                    rad = Double.parseDouble(br.readLine());
                    speed = Double.parseDouble(br.readLine());
                    index = Integer.parseInt(br.readLine());
                    nombre = br.readLine();
                    Planetas.add(new Planet(x,y,masa,rad,speed,nombre));
                    addObject(Planetas.get(index));
                    break;
                    
                    case 2:
                    x = Integer.parseInt(br.readLine());
                    y = Integer.parseInt(br.readLine());
                    masa = Double.parseDouble(br.readLine());
                    rad = Double.parseDouble(br.readLine());
                    rv = Double.parseDouble(br.readLine());
                    tv = Double.parseDouble(br.readLine());
                    dist = Float.parseFloat(br.readLine());
                    index = Integer.parseInt(br.readLine());
                    nombre = br.readLine();
                    Moon nueva = new Moon(x,y,masa,rad,rv,tv,Planetas.get(index),dist,nombre);
                    addObject(nueva);
                    break;
                    
                    case 3:
                    x = Integer.parseInt(br.readLine());
                    y = Integer.parseInt(br.readLine());
                    Enemy ene = new Enemy(x,y);
                    addObject(ene);
                    break;
                }
                
            }
            br.close();
        }
        catch(Exception ex)
        {
            
        }
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void Inicializas()
    {
      setPaintOrder(Image.class,LeftUI.class,Body.class,Moon.class,Planet.class);   
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
         LeftUI izq=new LeftUI();
        addObject(izq,40,335);
    }
}
