import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoadWorld extends World
{
    private SimpleTimer time = new SimpleTimer();
    Counter timer = new Counter();
    
    int WORLDWIDTH = getWidth();
    int WORLDHEIGHT = getHeight();

    private GreenfootImage backgroundImage;

    private int scrollY;
    private boolean scrollComplete = false;
 
    Player player = new Player("images/player1_side.png"); // Player object
 

    public int scrollspeed = 4;

    

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public RoadWorld()
    {
        super(500, 600, 1);

        backgroundImage = new GreenfootImage("road.png");
        scrollY = -backgroundImage.getHeight() + getHeight(); // Bottom Y-Coordinate

        Greenfoot.setSpeed(50);
        
        timer.setValue(30);
        time.mark();
        showText("Timer", 40, 20);
        addObject(timer, 40, 50);

        setBackground(backgroundImage);

        // Add Actors
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT-50);
        addNewObstacle1();
        addNewObstacle1();
    }

    public void act() {

        if (!scrollComplete){
            scrollBackground();
        }
        
        timer.setValue(30 - time.millisElapsed()/1000);
        if(timer.getValue() == 0){
            Greenfoot.stop();
        }

        checkScrolling();
        isGameFinished();

    }

    private void scrollBackground(){
        if (scrollY < 0) {
            GreenfootImage background = getBackground();
            background.drawImage(backgroundImage, 0, scrollY);
            scrollY += scrollspeed; 
        } else {
            scrollComplete = true;
        }
    }

    private void checkScrolling(){
        if (!scrollComplete){
            scrollBackground();
        }
    }

    public boolean isScrollComplete(){
        return scrollComplete;
    }
    
    private void addNewObstacle1(){ //Random Spawn per Run
        int randomX = Greenfoot.getRandomNumber(getWidth());
        Obstacle1 newObstacle = new Obstacle1(scrollspeed);
        addObject(newObstacle, randomX, 0);
    }  
    
    private void isGameFinished(){
        if (player.getY() <= 0 && scrollComplete){
            System.out.println("You Win");
            Greenfoot.stop();
        }
    }
}