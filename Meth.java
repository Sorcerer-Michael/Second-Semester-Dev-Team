import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meth extends Actor implements Obstacle
{
    private int moveSpeed;
    
    public Meth(int moveSpeed) {
        this.moveSpeed = moveSpeed;
        setImage("images/gold-ball.png");
    }
    public void act()
    {
        update();
    }
    @Override
    public void update() {
        move();
        checkCollision();
        destroy();
        
    }
    @Override
    public void checkCollision() {
        if (isTouching(Player.class)) {
            Greenfoot.stop();
            Greenfoot.setWorld(new Menu()); // placeholder after crash sends to main menu
            // change to crashed menu
            // reset game variables
        }
    }
    @Override
    public void move() {
        setLocation(getX(), getY() + moveSpeed);
    }
    @Override
    public void destroy() {
        World world = getWorld();
        if (isAtEdge()) {
            world.removeObject(this);
        }
        
        
    }
    
    
    
}
