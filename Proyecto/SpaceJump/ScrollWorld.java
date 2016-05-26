import java.util.List;
import java.util.ArrayList;
import greenfoot.*;  

public class ScrollWorld extends World
{
    private int totalWidth, totalHeigth, windowWidth,windowHeigth, scrollX,scrollY;
    private int scrollSize;
    private Player jugador;

    public ScrollWorld(){
        super(600,400,1);
        scrollSize=100;
        totalWidth=1000;
        totalHeigth=1000;
        windowWidth=600;
        windowHeigth=400;
        scrollX=0;
        scrollY=0;}

    /**
     * añade un objeto tipo Player a la variable Jugador
     * @param Jugador objeto que se asignara a Jugador
     */    
    public void setJugador(Player jugador)
    {
        this.jugador=jugador;
        addObject(jugador);
    }

    /**
     * regresa un objeto tipo Player 
     * @return Jugador objeto que se regresara
     */    
    public Player getJugador()
    {
        return jugador;
    }

    /**
     * class constructor
     */

    public ScrollWorld(int realx, int realy, int windowedx, int windowedy,int  scrl_x,int scrl_y)
    {
        super(windowedx,windowedy,1,false);
        scrollSize=2;
        totalWidth=realx;
        totalHeigth=realy;
        windowWidth=windowedx;
        windowHeigth=windowedy;
        if(scrl_x+windowedx<=realx&&scrl_x+windowedx>=0)
            scrollX=scrl_x;
        else
            System.out.println("Valores incorrectos para el ancho de ventana o mundo");

        if(scrl_y+windowedy<=realy&&scrl_y+windowedy>=0)
            scrollY=scrl_y;
        else
            System.out.println("Valores incorrectos para el alto de ventana o mundo");

    }

    /**
     * Añade las barras auxiliares al mundo
     */
    public void CreaBarras()
    {
        LeftUI izq=new LeftUI();
        addObject(izq,40,335);

        DownUI upInterface=new DownUI();
        addObject(upInterface,475,640);
    }

    /**
     * @Override, overrides the method to add a scrollActor in, the actor is aded in position indicated
     */
    public void addObject(Actor object){
        ScrollActor scAux=(ScrollActor)(object);
        scAux.setScrollWorld(this);
        scAux.updateMyCoords();
        super.addObject(scAux,(int)scAux.getWorldX(),(int)scAux.getWorldY());

    }

    /**
     * Used to scroll the world manually.
     */
    public void pruebaScroll(){
        if (Greenfoot.isKeyDown("left"))
            scrollLeft();
        if (Greenfoot.isKeyDown("right"))
            scrollRight();   
        if (Greenfoot.isKeyDown("up"))
            scrollUp();   
        if (Greenfoot.isKeyDown("down"))
            scrollDown();   
    }

    /**
     * Override to make act the world
     */
    public void act(){
        adjustActorCoords();
        pruebaScroll();}

    /**
     * mrthod that calls the cordinate adjust in all the ScrollActor objects.
     */
    private void adjustActorCoords(){

        List<ScrollActor>lst=this.getObjects(ScrollActor.class);
        for (ScrollActor scAux: lst){
            scAux.updateMyCoords();
        }

    }

    /**
     * Makes the world scroll down.
     * 
     */
    public void scrollDown(){
        if(scrollY+scrollSize<=totalHeigth)
            scrollY+=scrollSize;
    }

    /**
     * Makes the world scroll up
     * 
     */

    public void scrollUp(){
        if(scrollY-scrollSize>=0)
            scrollY-=scrollSize;

    }

    /**
     * makes the world scroll right.
     */
    public void scrollRight(){
        if(scrollX+scrollSize<=totalWidth)
            scrollX+=scrollSize;

    }

    /**
     * makes the world scroll left
     * 
     */
    public void scrollLeft(){
        if(scrollX-scrollSize>=0)
            scrollX-=scrollSize;

    }

    /**
     * 
     * @return the the current scroll in X 
     */

    public int getScrollX(){
        return scrollX;}

    /**
     * 
     * @return the the current scroll in Y 
     */
    public int getScrollY(){
        return scrollY;}

    /**
     * @return the width of the window 
     */
    public int getWindowWidth(){
        return windowWidth;
    }

    /**
     * @return the heigth of the window 
     */
    public int getWindowHeight(){
        return windowHeigth;
    }    


}