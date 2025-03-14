import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meth extends Actor implements Obstacle
{
    
    private static String icon = "images/gold-ball.png"; // sets image of all meth objects
    public static int collisionCount = 0; // counts how many times the player has collided with a meth object (class variable)
    
    private String statusDebuffOnCollision = "overconfident"; // When meth collides with player it applies the overconfident debuff to player
    private int moveSpeed;
    
    private boolean notValidState = false;
    
    
    public Meth(int moveSpeed) {
        this.moveSpeed = moveSpeed;
        setImage(icon);
    }
    public void act()
    {
        update();
    }
    @Override
    public void update() {
        move();
        
        if (isAtEdge()) {
            //world.removeObject(this);
            notValidState = true;
            destroy();                
        }
        
        if (!notValidState) { // If object gets destroyed Stop checking for collision
            checkCollision();
        }
        if (collisionCount == 3) {
            System.out.println("Max debuff applied");
            //Greenfoot.stop(); // stops game
            //Greenfoot.setWorld(new Menu()); // placeholder after crash sends to main menu
        }
        
    }
    @Override
    public void checkCollision() {
        
        if (isTouching(Player.class)) {
            collisionCount++;
            if (collisionCount == 1000) {
                System.out.println("Max debuff applied");
                Greenfoot.stop(); // stops game
                Greenfoot.setWorld(new Menu()); // placeholder after crash sends to main menu
            }
            
          
            destroy();
            
            //Greenfoot.stop(); // tests collision
            
        }
    }
    @Override
    public void move() {
        setLocation(getX(), getY() + moveSpeed);
    }
    @Override
    public void destroy() {
        World world = getWorld();
        world.removeObject(this);
       
    }
    
    
    
}
