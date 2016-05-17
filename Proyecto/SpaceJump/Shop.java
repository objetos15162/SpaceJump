import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    /**
     * Constructor for objects of class Shop
     */
    public Shop(int x,int y)
    {
        GreenfootImage gas = new GreenfootImage("gas_ico.png");
        gas.drawImage(gas,x+10,y+200);
    }
    
    /**
     * Act - do whatever the Shop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * 
     */
    public void buy()
    {
        
    }
}
