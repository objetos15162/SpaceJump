import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    private Player jugador;
    private int a,b;
    private Boton Bg,Bh,Bb,Exit;
	private ArrayList<Boton> botones;
    
    /**
     * Constructor for objects of class Shop
     */
    public Shop(int x,int y,Player jugador)
    {
        this.jugador=jugador;
        this.a=x;
        this.b=y;
		botones = new ArrayList<Boton>();
        Bg = new Boton(a-110,b-10,"gasShop.png");
        Bh = new Boton(a+5,b-10,"lifeShop.png");
        Bb = new Boton(a+110,b-10,"bullet.png");
        Exit = new Boton(a+160,b-195,"flecha.png");
    }

    /**
     * @param selecciona el objeto a regresar
     * @return un objeto de tipo Boton
     */
    public Boton getBotons(int c)
    {
        Boton a;
        if(c == 1)
            a=Bg;
            else if (c == 2)
                a=Bh;
                else if (c == 3)
                    a=Exit;
                    else a= Bb;
        return a;
    }
	
    /**
     * 
     */
    public boolean buy()
    {
        boolean c=false;
        
        if(Greenfoot.mouseClicked(Bg) && jugador.getDinero()>=20)
        {
            jugador.cambiaDinero(-20);
            jugador.aumentaGas();
        }
        
        if(Greenfoot.mouseClicked(Bh) && jugador.getDinero()>=100)
        {
            jugador.cambiaDinero(-100);
            jugador.setVida();
        }
        
        if(Greenfoot.mouseClicked(Bb) && jugador.getDinero()>=50)
        {
            jugador.cambiaDinero(-50);
            jugador.setVida();
        }
         
        if(Greenfoot.mouseClicked(Exit))
        {
            c=true;
        }
        
        return c;
        
    }


}
