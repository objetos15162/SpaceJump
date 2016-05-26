import java.util.ArrayList;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * parto of the user interface in Space Jump it shows the name of the player, score and objects collected
 * 
 * @author (Alfredo Granja) 
 * @version (may of 2016)
 */
public class DownUI extends Actor
{
    private Label playerName;
    private Label playerScore;
    private Image generator,turbine,solarModule, amortiguador, tienda,bala;
    private Label bullets;

    public DownUI(){

        this.playerName=new Label("player",28);  
        setImage("bar_up.png");
        playerScore=new Label(0,26);

        generator= new Image();
        generator.setImage("generatorBN.png");

        turbine=new Image();
        turbine.setImage("turbineBN.png");

        solarModule= new Image();
        solarModule.setImage("solar_moduleBN.png");

        amortiguador=new Image();
        amortiguador.setImage("amortiguadorBN.png");

        tienda=new Image();
        tienda.setImage("tiendai.png");

        bala = new Image();
        bala.setImage("b1.png");

        bullets= new Label(0,28);

    }

    /**
     * updates the graphics shown by the graphic interface.
     */
    public void update(ArrayList<Collectable> lista,int playerScore, String name){

        this.playerScore.setValue(playerScore);
        for(Collectable cAux:lista){
            if(cAux instanceof Generator){
                generator.setImage("generator.png");

            }

            if(cAux instanceof Turbine){
                turbine.setImage("turbine.png");
            }
            if(cAux instanceof SolarModule)
                solarModule.setImage("solar_module.png");

            if(cAux instanceof Amortig){
                amortiguador.setImage("amortiguador.png");}
        }
        playerName.setValue(name);

    }

    /**
     * @Override to add all the objects that are part of the interface
     */
    protected void addedToWorld(World world){

        world.addObject(playerName,800,600);
        world.addObject(playerScore,800,630);
        world.addObject(generator,200,630);
        world.addObject(turbine,300,630);
        world.addObject(solarModule,400,630);
        world.addObject(amortiguador,100,630);
        if(world instanceof Tienda==false){
            world.addObject(tienda,500,630);}
        world.addObject(bala,600,630);
        world.addObject(bullets,650,630);

    }

    /**
     * Act - do whatever the UpUI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        goShop();
        changeBullets();
    }   

    /**
     * changes the current bullet used by the player 
     */
    private void changeBullets()
    {
        ScrollWorld w = (ScrollWorld)getWorld();

        if(w.getJugador().getAType() == 1)
            bala.setImage("b1.png");
        else if (w.getJugador().getAType() == 2)
            bala.setImage("fire_bullet.png");
        else bala.setImage("bala_blue.png");
        bullets.setValue(w.getJugador().getABullet());
    }

    /**
     * sends the player to the shop
     * 
     */
    private void goShop(){

        if(Greenfoot.mouseClicked(tienda)){
            ScrollWorld scAux=(ScrollWorld)getWorld();
            Tienda t=new Tienda();
            scAux.getJugador().goToWorld(t);

        }

    }
}
