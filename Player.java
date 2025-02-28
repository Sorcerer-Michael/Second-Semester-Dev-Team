import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 1;
    
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
            setLocation(getX() - 5, getY()); // Move left
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 5, getY()); // Move right
        }
        if (Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 5); // Move down
        }
        if (Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 5); // Move Up
        }
    }
    
    public void DrivePlayer(){
        if(speed > 0){
            setLocation(getX(), getY() - speed); // Update by "Speed" pixel UP
        } else {
            setLocation(getX(), getY()); // stays in position
        }
    }
}
