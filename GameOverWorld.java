import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(new Color(0, 0, 0, 100));
        bg.fillRect(0, 0, getWidth(), getHeight());
        setBackground(bg);
        
        GreenfootImage text = new GreenfootImage("GAME OVER", 60, Color.WHITE, new Color(0, 0, 0, 0));
        getBackground().drawImage(text, 100, 100);
        
        
    }
}
