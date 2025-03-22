import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoadWorld extends World
{
    private SimpleTimer time = new SimpleTimer();
    private Counter timer = new Counter();
    private final int WORLDWIDTH = getWidth();
    private final int WORLDHEIGHT = getHeight();
    private GreenfootImage backgroundImage;
    
    private int backgroundY;
    private boolean scrollComplete = false;
    private int lastY;
    
    private Player player = new Player("images/player1_side.png"); // Player object

    private final int TOP_BOUNDARY = 250;
    private final int BOTTOM_BOUNDARY = 400;

    private List<Actor> obstacles = new ArrayList<>();

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public RoadWorld()
    {
        super(500, 600, 1);
        Meth.collisionCount = 0; // band aid fix to resetting collision count
        backgroundImage = new GreenfootImage("road.png");
        backgroundY = -backgroundImage.getHeight() + getHeight(); // Bottom Y-Coordinate

        Greenfoot.setSpeed(50);

        timer.setValue(30);
        time.mark();
        showText("Timer", 40, 20);
        addObject(timer, 40, 50);

        setBackground(backgroundImage);

        // add obstacles to obstacle manager (List) ! probably want to create a separate obstacle manager class w/ allows for more control of what level gets what enemies.
        //obstacles.add(new Obstacle1(this.scrollspeed));
        //obstacles.add(new Obstacle1(this.scrollspeed));
        for (int count = 0; count < 5; count++) {
            obstacles.add(new Meth(2));
        }

        // Add Actors
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT-200);
        lastY = player.getY();

        // loops through obstacle list and spawns them
        for (Actor obstacle : obstacles) {
            SpawnObstacle(obstacle);
        }

        //System.out.println("Meth Collision Count: " + Meth.collisionCount);
    }

    public void act() {

        timer.setValue(30 - time.millisElapsed()/1000);
        if(timer.getValue() == 0){
            Greenfoot.stop();
        }

        isGameFinished();
        scrollBackground();
    }

    /**
     * this method does player movement at boundaries,
     * updates background position and image
     */
    private void scrollBackground(){
        int playerY = player.getY();
        int playerMovement = lastY - playerY;

        // if background at top, scroll is done
        if (backgroundY >= 0){
            backgroundY = 0;
            scrollComplete = true;
        }

        // if scroll not done, adjust background when player at boundary
        if (!scrollComplete && ((playerY <= TOP_BOUNDARY && playerMovement > 0) || (playerY >= BOTTOM_BOUNDARY && playerMovement < 0))){
            backgroundY += playerMovement;
            //Makes sure player doesnt go below at start
            if(backgroundY < -backgroundImage.getHeight() + WORLDHEIGHT){
                backgroundY = -backgroundImage.getHeight() + WORLDHEIGHT;
            }
            //keep player inside of boundary
            if (playerY <= TOP_BOUNDARY && playerMovement > 0){
                player.setLocation(player.getX(), TOP_BOUNDARY);
            } else {
                player.setLocation(player.getX(), BOTTOM_BOUNDARY);
            }
        }
        
        // update background
        updateBackground();
        lastY = player.getY();
        
    }
    
    
    /**
     * Update background image (when game intialzes)
     *
     */
    public void updateBackground(){
        GreenfootImage newBg = new GreenfootImage(WORLDWIDTH, WORLDHEIGHT);
        newBg.drawImage(backgroundImage, 0, backgroundY);
        setBackground(newBg);
        }
    
    public boolean isScrollComplete(){
        return scrollComplete;
    }

    private void SpawnObstacle(Actor obstacle){ //Random Spawn per Run
        int randomX = Greenfoot.getRandomNumber(getWidth());
        int randomY = Greenfoot.getRandomNumber(200);
        addObject(obstacle, randomX, randomY);
    }  

    private void isGameFinished(){
        if (player.getY() <= 0 && scrollComplete){
            System.out.println("You Win");
            Greenfoot.stop();
        }
    }
}