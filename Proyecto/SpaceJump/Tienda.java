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
    private Label money,text;
    private Boton botonGas,botonLife,botonBullet,exit,fondo;

    /**
     * Constructor for objects of class Tienda.
     * 
     */
    public Tienda()
    {
        super(1500,1300,950,670,0,0);
        setPaintOrder(Image.class,Label.class,LeftUI.class,DownUI.class,Bullet.class,Player.class); 
        fondo=new Boton(510,300,"Tienda.png");
        text = new Label("Disponible:",28);
        money = new Label(0,28);
        botonGas = new Boton(400,300,"gasShop.png");
        botonLife = new Boton(510,300,"lifeShop.png");
        botonBullet = new Boton(620,300,"bullet.png");

        exit = new Boton(655,135,"flecha.png");

        CreaBarras();
        MuestraTienda();
        setBackground("tiendabotonGas.png");
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
        addObject(botonGas,botonGas.getsX(),botonGas.getsY());
        addObject(botonLife,botonLife.getsX(),botonLife.getsY());
        addObject(botonBullet,botonBullet.getsX(),botonBullet.getsY());
        addObject(exit,exit.getsX(),exit.getsY());
        addObject(money,800,300);
        addObject(text,800,250);
    }

    /**
     * makes the transactions of the shop
     */
    public void buy()
    {

        if(Greenfoot.mouseClicked(botonGas) && getJugador().getDinero()>=20)
        {
            getJugador().cambiaDinero(-20);
            getJugador().aumentaGas();
        }

        if(Greenfoot.mouseClicked(botonLife) && getJugador().getDinero()>=100)
        {
            getJugador().cambiaDinero(-100);
            getJugador().setVida();
        }

        if(Greenfoot.mouseClicked(botonBullet) && getJugador().getDinero()>=50)
        {
            getJugador().cambiaDinero(-50);
            getJugador().addB();
        }

        money.setValue(getJugador().getDinero()); 

        if(Greenfoot.mouseClicked(exit))
        {
            getJugador().goToWorld(getJugador().getPreviousWorld());
        }

    }
}