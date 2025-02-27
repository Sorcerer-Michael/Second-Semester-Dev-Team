import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Player () {

    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
    }

    public void movement() {
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 4, getY()); // Move left
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 4, getY()); // Move right
        }
    }
}
