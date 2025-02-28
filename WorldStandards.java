import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldStandards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldStandards extends World
{

    /**
     * Constructor for objects of class WorldStandards.
     * 
     */
    
    private SimpleTimer time = new SimpleTimer();
    Counter timer = new Counter();
    public WorldStandards()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Greenfoot.setSpeed(50);
        
        timer.setValue(30);
        time.mark();
        showText("Timer", 40, 20);
        addObject(timer, 40, 50);
        
    }
    
    public void act(){
        timer.setValue(30 - time.millisElapsed()/1000);
        if(timer.getValue() == 0){
            Greenfoot.stop();
        }
    }
    
}
