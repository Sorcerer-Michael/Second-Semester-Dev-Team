import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meth class is an obstacle that debuffs player on collision
 * Uses Obstacle as a base class.
 * Uses composition to implement Obstacle functionality
 * 
 * 
 * @author Jonathan Washington
 * @version 1.0
 */
public class Meth extends Actor
{
    
    // static Class variables
    public static String name = "meth";
    public static String icon = "images/gold-ball.png";
    public static String statusDebuffOnCollision = "confident";
    public static int collisionCount = 0;
    
    
    // Each individual uses Obstacle class to provide base functionality of Obstacles
    private Obstacle meth;
    
    
    public Meth(int moveSpeed) {
        this.meth = new Obstacle(this, moveSpeed, icon, statusDebuffOnCollision, name);
    }
    public void act()
    {
        meth.update(this, getOneIntersectingObject(Player.class));
        /*

        if (this.meth.collided) {
            collisionCount++;
            System.out.println(this.name + " Collision Count: " + collisionCount);
            this.meth.destroy();
        }
        
        if (collisionCount == 3) {
            System.out.println(name + " Max debuff applied");
            collisionCount = 0;
            Greenfoot.stop(); // stops game
            Greenfoot.setWorld(new Menu()); // placeholder after crash sends to main menu
        }
        */
    }
    
    // Additional methods below (unique to Meth class)
    
    
    
}
