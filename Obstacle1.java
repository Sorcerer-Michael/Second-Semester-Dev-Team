import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle1 extends Actor implements Obstacle
{
    private int scrollspeed;
    
    
    /**
     * Constructor for Obstacle1; Takes Scroll Speed as Input in RoadWorld;
     */
    public Obstacle1(int scrollspeed){
        this.scrollspeed = scrollspeed;
        setImage("images/man.png");
    }
    
    /**
     * Act - do whatever the Obstacle1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        update();
    }
    
    @Override
    public void update() {
        checkCollision();
        move();
        addNewObstacle();
    }
    
    @Override
    public void move(){
        setLocation(getX(), getY() + scrollspeed);
    }
    
    @Override
    public void checkCollision() {
        if (isTouching(Player.class)) { //Player collides with Obstacle
            Greenfoot.stop();
            System.out.println("You Crashed");
        }
    }

    @Override 
    public void destroy() {
        World world = getWorld();
        world.removeObject(this);
    }
    
    // extra spawning for RoadWorld level
    // Create a obstacle manager that handles spawning of obstacles
    // Use the manager to determine how obstacles spawn depending on the level
    // deprecated method (keep method for reference)
    private void addNewObstacle() {
        if (isAtEdge()) {
            World world = getWorld();  // Get the world instance
            
            if (world instanceof RoadWorld) { 
                RoadWorld roadWorld = (RoadWorld) world; 
                if (roadWorld.isScrollComplete()) { 
                    
                    Obstacle1 lastObstacle = (Obstacle1) world.getObjects(Obstacle1.class).get(0);
                    if (lastObstacle != null){
                        
                        world.removeObject(lastObstacle);
                    }
                    return;
                }

                world.removeObject(this);
                //int randomX = Greenfoot.getRandomNumber(world.getWidth());
                //world.addObject(new Obstacle1(scrollspeed), randomX, -50);
            }
        }
    }
}
