import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoadWorld extends World
{
    int WORLDWIDTH = getWidth();
    int WORLDHEIGHT = getHeight();

    private GreenfootImage backgroundImage;
    public int scrollY;
    private boolean scrollComplete = false;
    public int scrollspeed = 4;

    Player player = new Player(); // Player object
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public RoadWorld()
    {
        super(500, 600, 1);

        backgroundImage = new GreenfootImage("road.png");
        scrollY = -backgroundImage.getHeight() + getHeight(); // Bottom Y-Coordinate
        setBackground(backgroundImage);

        // Add Actors
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT-50);
        addNewObstacle();
    }

    public void act() {
        checkScrolling();
    }

    private void scrollBackground(){
        if (scrollY < 0) {
            GreenfootImage background = getBackground();
            background.drawImage(backgroundImage, 0, scrollY);
            scrollY += scrollspeed; // Adds 4 pixels to ScrollY
        } else {
            scrollComplete = true;
        }
    }

    private void checkScrolling(){
        if (!scrollComplete){
            scrollBackground();
        }
    }

    public void addNewObstacle(){
        int randomX = Greenfoot.getRandomNumber(getWidth());
        Obstacle1 newObstacle = new Obstacle1(scrollspeed);
        addObject(newObstacle, randomX, 0);
    }  
    
    public int getScrollY(){
        return scrollY;
    }
}