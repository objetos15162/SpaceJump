import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Planet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moon extends Planet
{
    private double translationSpeed;
    private double translation;
    private double transDistance;
    private Planet translateCenter; 

    /**
     * Creates a new moon with the given mass, radio, rotation speed, translation speed and uses the Actor given as translation pivot
     * @Param masa asas
     */

    public Moon(int x, int y,double masa,double rad,double rotationV,double translationV, Planet translateCen,float translate_distance,String imagefile)
    {
        super(x,y,masa,rad,rotationV,imagefile);
        translationSpeed=translationV;
        translateCenter= translateCen;
        transDistance=translate_distance;}

    /**
     * Makes the moon rotate and translate.
     * @Override
     */
    public void act() 
    {
        rotate();
        translate();
        super.act();
    }    

    /**Makes the moon translate around the Actor given
     */
    public void translate()
    {
        double exactX= transDistance*Math.cos(Math.toRadians(translation));
        double exactY= transDistance*Math.sin(Math.toRadians(translation));
        setLocation(exactX+translateCenter.getWorldX(),exactY+translateCenter.getWorldY());
        translation +=translationSpeed;

    }

    /**
     * Set the translation speed to the given parameter.
     * 
     */
    public void setTranslationSpeed(double transSpeed){
        translationSpeed=transSpeed;
    } 

    /**
     * Change the translation speed by the given factor.
     */
    public void changeTranslationSpeed(double factor){
        translationSpeed*=factor;
    } 

}

