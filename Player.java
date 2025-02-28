import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author Jonathan Washington
 * @version 1.0
 * 
 * Player class 
 */
public class Player extends Actor
{
    // player variables 
    public String sprite = "images/player1_side.png"; // sprite is a 2d image
    public int rotationSpeed = 2;
    public int moveSpeed = 3;
    public int initialRotation = 270;
    
    
    
    
    // Movement keys
    private boolean pressD;
    private boolean pressA;
    private boolean pressW;
    private boolean pressS;
    
    // no limited rotation movement controls
    final int RIGHTROTATIONLIMIT = 360; // default: 315 - limited controls
    final int LEFTROTATIONLIMIT = -360; // default: 225 - limited controls
    

    
    
    // 3 Overloaded Player constructors
    public Player () {

        setImage(sprite);
        setRotation(initialRotation);

        // set player sprite to imagee
        setImage("images/player1.png");

    }
    public Player(String sprite) {
        setImage(sprite);
        setRotation(initialRotation);
    }
    // Full control over player variables
    public Player(String sprite, int moveSpeed, int rotationSpeed, int initialRotation) {
        setImage(sprite);
        setRotation(initialRotation);
        this.moveSpeed = moveSpeed;
        this.rotationSpeed = rotationSpeed;
        this.initialRotation = initialRotation;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Player Movement
        pressD = Greenfoot.isKeyDown("d");
        pressA = Greenfoot.isKeyDown("a");
        pressW = Greenfoot.isKeyDown("w");
        pressS = Greenfoot.isKeyDown("s");
        movement(pressD, pressA, pressW, pressS);
        
        // reset variables
        
    }
    
    
    public void movement(boolean pressD, boolean pressA, boolean pressW, boolean pressS) {
        // turn(int amount) : Turn this actor by the specified amount (in degrees).
        // move(int distance) : Move this actor the specified distance in the direction it is currently facing.
    
        // clockwise rotation
        if (pressD) {
            if (getRotation() < RIGHTROTATIONLIMIT && getRotation() < (360-1)) {
                turn(rotationSpeed);
            }
        }
        // counter-clockwise rotation
        if (pressA) {
            if (getRotation() > LEFTROTATIONLIMIT && getRotation() < (360-1)) {
                turn(-rotationSpeed);
            } 
        }
        
        // move forwards
        if (pressW) {
            move(moveSpeed);
        }
        // move backwards
        if (pressS) {
            move(-moveSpeed);
        }
        
    }
    
    
}
