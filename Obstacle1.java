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
    }
    
    public Obstacle1(int scrollspeed){
        this.scrollspeed = scrollspeed;
    }
    
    private void InPosition(){
        setLocation(getX(), getY() - scrollspeed);
    }
    
    private void checkCollision(){
        if (isTouching(Player.class)){
            Greenfoot.stop();
            System.out.println("You Crashed");
        }
    }
}
