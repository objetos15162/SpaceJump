import java.util.List;
import java.util.ArrayList;
import greenfoot.*;  


public class ScrollWorld extends World{


    private int totalWidth, totalHeigth, windowWidth,windowHeigth, scroll_x,scroll_y;
    private int scroll_size;

    public ScrollWorld(){
        super(600,400,1);
        scroll_size=100;
        totalWidth=1000;
        totalHeigth=1000;
        windowWidth=600;
        windowHeigth=400;
     
        scroll_x=0;
        scroll_y=0;}

    public ScrollWorld(int realx, int realy, int windowedx, int windowedy,int  scrl_x,int scrl_y)
    {
        super(windowedx,windowedy,1,false);
        scroll_size=2;
        totalWidth=realx;
        totalHeigth=realy;
        windowWidth=windowedx;
        windowHeigth=windowedy;
   
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
     * @Override
     */
    public void addObject(Actor object){
        ScrollActor scAux=(ScrollActor)(object);
        scAux.setScrollWorld(this);
        scAux.updateMyCoords();
        super.addObject(scAux,(int)scAux.getWorldX(),(int)scAux.getWorldY());

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
        adjustActorCoords();
        pruebaScroll();

    
    }
    
    private void adjustActorCoords(){
        
        List<ScrollActor>lst=this.getObjects(ScrollActor.class);
        for (ScrollActor scAux: lst){
            scAux.updateMyCoords();
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





}