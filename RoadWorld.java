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
    private int scrollY;
    private boolean scrollComplete = false;
 
    Player player = new Player(); // Player object
    Obstacle1 obstacle1 = new Obstacle1(); // Add Obstacle1
 
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public RoadWorld()
    {
        super(500, 600, 1);
 
        backgroundImage = new GreenfootImage("road.png");
        scrollY = -backgroundImage.getHeight() + getHeight(); // Bottom Y-Coordinate
 
        // Add Actors
        addObject(player, WORLDWIDTH/2, WORLDHEIGHT-50);
        addObject(obstacle1, 0, 15);
    }
 
    public void act() {
        checkScrolling();
    }
 
    private void scrollBackground(){
        if (scrollY < 0) {
            GreenfootImage background = getBackground();
            background.drawImage(backgroundImage, 0, scrollY);
            scrollY += 4; // Adds 2 pixels to ScrollY
        } else {
            scrollComplete = true;
        }
    }
    
    private void checkScrolling(){
        if (!scrollComplete){
            scrollBackground();
        }
    }
}