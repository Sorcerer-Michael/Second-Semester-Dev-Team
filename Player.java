import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int rotationSpeed = 2;
    boolean changedDirection = false;
    
    
    // no limited movement controls
    final int RIGHTROTATIONLIMIT = 360; // default: 315
    final int LEFTROTATIONLIMIT = -360; // default: 225
    
    // Limited movement controls
    //final int RIGHTROTATIONLIMIT = 315; // default: 315
    //final int LEFTROTATIONLIMIT = 225; // default: 225
    
    public Player () {
        setImage("images/player1_side.png");
        setRotation(270);
        
        
        // DEBUG 
        System.out.println(getRotation());
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
        
        
        // reset variables
        changedDirection = false;
    }
    
    
    public void movement() {
        // turn(int amount) : turns actor in degrees
        // turnTowards(int x, int y) : Turns this actor to face towards a certain location
        // setLocation(int x, int y) : assign a new location to this actor
        // setRotation(int rotation) : set the rotation of this actor
        
        // clockwise rotation
        if (Greenfoot.isKeyDown("d")) {
            
            
            if (getRotation() < RIGHTROTATIONLIMIT && getRotation() < (360-1) && changedDirection == false) {
                turn(rotationSpeed);
            }
            changedDirection = true;
        }
        // counter-clockwise rotation
        if (Greenfoot.isKeyDown("a")) {
            if (getRotation() > LEFTROTATIONLIMIT && getRotation() < (360-1) && changedDirection == false) {
                turn(-rotationSpeed);
            } 
            changedDirection = true;
        }
        
        // up
        if (Greenfoot.isKeyDown("w")) {
            move(3);
            //setLocation(getX(), getY() - 5);
        }
        // down
        if (Greenfoot.isKeyDown("s")) {
            move(-3);
        }
        
        
    }
    
}
