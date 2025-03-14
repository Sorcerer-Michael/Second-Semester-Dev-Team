import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * Basic Player controller
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
        
        
        // Logging methods
        //movementLog(); // logging movements in terminal
        checkPlayerValues(); // press ` : to check player initial values
    }
    
    
    public void movement(boolean pressD, boolean pressA, boolean pressW, boolean pressS) {
        // turn(int amount) : Turn this actor by the specified amount (in degrees).
        // move(int distance) : Move this actor the specified distance in the direction it is currently facing.
    
        
        // clockwise rotation / right rotation
        if (pressD) {
            if (getRotation() < RIGHTROTATIONLIMIT && getRotation() < (360-1)) {
                turn(rotationSpeed);
            }
        }
        // counter-clockwise rotation / left rotation
        if (pressA) {
            if (getRotation() > LEFTROTATIONLIMIT && getRotation() < (360-1)) {
                turn(-rotationSpeed);
            } 
        }
        
        // move forwards : relative to player's rotation
        if (pressW) {
            move(moveSpeed);
        }
        // move backwards : relative to player's rotation
        if (pressS) {
            move(-moveSpeed);
        }
        
    }
    // DEBUG Methods (only used for testing)
    public void checkPlayerValues() {
        if (Greenfoot.isKeyDown("`")) {
            System.out.printf("player sprite used: %s\n", sprite);
            System.out.printf("Player initial rotation: %d\n", initialRotation);
            System.out.printf("Player move speed: %d\n", moveSpeed);
            System.out.printf("Player rotation speed: %d\n", rotationSpeed);
            
            Greenfoot.delay(20); // Stops from logging constantly
        }
        
    }
    public void movementLog() {
        if (pressD != false) System.out.printf("Turning right: %b\n", pressD);
        if (pressA != false) System.out.printf("Turning left: %b\n", pressA);
        if (pressW != false) System.out.printf("Moving forward: %b\n", pressW);
        if (pressS != false) System.out.printf("Moving backwards: %b\n", pressS);

    }
}
