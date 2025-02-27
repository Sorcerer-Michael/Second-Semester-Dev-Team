import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int WORLDWIDTH = getWidth();
    int WORLDHEIGHT = getHeight();
    
    private GreenfootImage backgroundImage;
    private int scrollY;
    private boolean scrollComplete = false;
    
    Player player = new Player(); // Player object
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        super(500, 600, 1);
        
        setBackground("road.png");
        
        
        // Add Actors 
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT-50);
        
    }
    
    
}
