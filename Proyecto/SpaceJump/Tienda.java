import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tienda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tienda extends ScrollWorld
{
    private Shop tienda;

    /**
     * Constructor for objects of class Tienda.
     * 
     */
    public Tienda(Player Jugador)
    {
        super(1500,1300,950,670,0,0);
        setJugador(Jugador);
        tienda = new Shop(500,350,getJugador());
        CreaBarras();
        MuestraTienda();
    }
    
    /**
     * 
     */
    public void act()
    {
        if(tienda.buy())
        {
            
        }
     }
     
    /**
     * hace visible la tienda
     */
    private void MuestraTienda()
    {
        Boton a;
        setPaintOrder(Boton.class,Shop.class);
        addObject(tienda,500,350);
        
        for(int i=1;i<5;i++)
        {
            a = tienda.getBotons(i);
            addObject(a);
        }
     }
}