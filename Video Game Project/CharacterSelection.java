import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelection extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public CharacterSelection()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("garagebackround.png");
        BackButton backButton = new BackButton();
        nextCharacter right = new nextCharacter();
        previousCharacter left = new previousCharacter();
        
        addObject(backButton, 550, 80);
        addObject(left, 180, 370);
        addObject(right, 400, 373);
    }
}
