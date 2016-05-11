import java.util.List;
import java.util.ArrayList;
import greenfoot.*;  


public class ScrollWorld extends World{


    private ArrayList<ScrollActor> worldElements;
    private int totalWidth, totalHeigth, windowWidth,windowHeigth, scroll_x,scroll_y;
    private int scroll_size;

    public ScrollWorld(){
        super(600,400,1);
        scroll_size=100;
        totalWidth=1000;
        totalHeigth=1000;
        windowWidth=600;
        windowHeigth=400;
        worldElements=new ArrayList<ScrollActor>();
        scroll_x=0;
        scroll_y=0;}

    public ScrollWorld(int realx, int realy, int windowedx, int windowedy,int  scrl_x,int scrl_y)
    {
        super(windowedx,windowedy,1);
        scroll_size=2;
        totalWidth=realx;
        totalHeigth=realy;
        windowWidth=windowedx;
        windowHeigth=windowedy;
        worldElements=new ArrayList<ScrollActor>();

        if(scrl_x+windowedx<=realx&&scrl_x+windowedx>=0)
            scroll_x=scrl_x;
        else
            System.out.println("Valores incorrectos para el ancho de ventana o mundo");

        if(scrl_y+windowedy<=realy&&scrl_y+windowedy>=0)
            scroll_y=scrl_y;
        else
            System.out.println("Valores incorrectos para el alto de ventana o mundo");

    }
    /**
     * @Overwrite
     */
    public void addObject(Actor object){
        ScrollActor scAux=(ScrollActor)(object);
        scAux.setScrollWorld(this);
        scAux.updateMyCoords();
        worldElements.add(scAux);

    }

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

    public void act(){
        actores();
        adjustActorCoords();
        manageActors();
        pruebaScroll();

    
    }
    
    private void adjustActorCoords(){
        for (ScrollActor scAux: worldElements){
            scAux.updateMyCoords();
        }

    }
    
     private void actores(){
        for (ScrollActor scAux: worldElements){
            if(scAux instanceof Planet&&scAux.getWorld()==null)
            scAux.act();
        }

    }
   
    

    public void scrollDown(){
        if(scroll_y+scroll_size<=totalHeigth)
            scroll_y+=scroll_size;
    }

    public void scrollUp(){
        if(scroll_y-scroll_size>=0)
            scroll_y-=scroll_size;

    }

    public void scrollRight(){
        if(scroll_x+scroll_size<=totalWidth)
            scroll_x+=scroll_size;

    }

    public void scrollLeft(){
        if(scroll_x-scroll_size>=0)
            scroll_x-=scroll_size;

    }

    private void manageActors(){
        for(ScrollActor object: worldElements)
            if(object.getCameraX()>=0&&object.getCameraX()<=windowWidth&&object.getCameraY()>=0&&object.getCameraY()<=windowHeigth)
                showActor(object);
            else
                hideActor(object);
    }

    public int getScrollX(){
        return scroll_x;}

    public int getScrollY(){
        return scroll_y;}
        
    public int getWindowWidth(){
    return windowWidth;
    }
    
    public int getWindowHeight(){
    return windowHeigth;
    }    


    private void hideActor(ScrollActor object){
        super.removeObject(object);
        object.setVisibility(false);

    }

    private void showActor(ScrollActor object){

        super.addObject(object,object.getCameraX(),object.getCameraY());
        object.setVisibility(true);
    }  
    
    public ArrayList<ScrollActor>getElements(){
    return worldElements;
    }



}