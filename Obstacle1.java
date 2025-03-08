import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle1 extends Actor
{
    private int scrollspeed;  

    /**
     * Act - do whatever the Obstacle1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkCollision();
        InPosition();
    }

    /**
     * Constructor for Obstacle1; Takes Scroll Speed as Input in RoadWorld;
     */
    public Obstacle1(int scrollspeed){
        this.scrollspeed = scrollspeed;
    }

    private void InPosition(){
        setLocation(getX(), getY() + scrollspeed);
        
        RoadWorld world = (RoadWorld) getWorld();
        if (getY() >= getWorld().getHeight()){ //If obstacle touches the bottom screen
            System.out.println("Obstacle reached bottom");
            getWorld().removeObject(this); 
            addNewObstacle();
        }
    }

    private void checkCollision(){
        if (isTouching(Player.class)){ //Player collides with Obstacle
            Greenfoot.stop();
            System.out.println("You Crashed");
        }
    }

    private void addNewObstacle(){
        RoadWorld world = (RoadWorld) getWorld();
        int randomX = Greenfoot.getRandomNumber(world.getWidth());

        Obstacle1 newObstacle = new Obstacle1(scrollspeed);
        world.addObject(newObstacle, randomX, -100);
    }
}
