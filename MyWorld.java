import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Player object
    public Player player = new Player("images/player1_side.png"); // Player(String sprite, int moveSpeed, int rotationSpeed, int initialRotation)
    
    // assuming world dimensions wont change after starting : change if needed to regular int variable
    final int WORLDWIDTH = getWidth();
    final int WORLDHEIGHT = getHeight();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // background image setup
        GreenfootImage bg = new GreenfootImage("Placeholder", 60, Color.BLACK, Color.GRAY);
        bg.scale(WORLDWIDTH, WORLDHEIGHT);
        setBackground(bg);
        
        
        // Add Actors 
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT/2);
        
        
    }
    
    public Player returnPlayer() {
        return player;
    }
}
