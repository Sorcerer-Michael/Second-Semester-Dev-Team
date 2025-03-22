import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    private GreenfootSound ballballball;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //ballballball = new GreenfootSound("ballballball.mp3");
        //ballballball.playLoop();
        
        setBackground("menu_background.png");
        
        
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth() / 2, getHeight() / 2 - 50);
    }
}
