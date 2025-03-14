/*
public interface Obstacle {
    public String statusEffect = null;
    public void update();
    public void checkCollision();
    public void move();
    public void destroy();
}*/


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle
{
    
    public static int collisionCount = 0; // counts how many times the player has collided with a meth object (class variable)
    private String icon; // sets image of all meth objects
    
    
    private String statusDebuffOnCollision; // When meth collides with player it applies the overconfident debuff to player
    private int moveSpeed;
    
    private boolean isDestroyed = false;
    Actor obstacle;
    
    public Obstacle(Actor obstacle, int moveSpeed, String icon, String statusDebuffOnCollision) {
        this.obstacle = obstacle;
        this.moveSpeed = moveSpeed;
        this.statusDebuffOnCollision = statusDebuffOnCollision;
        this.icon = icon;
    }

    
    public void update(Actor obstacle, Actor other) {
        move();
        
        // if meth reaches bottom of window destroy object
        if (obstacle.isAtEdge()) {
            isDestroyed = true;
            destroy();                
        }
        // If object gets destroyed Stop checking for collision
        if (!isDestroyed) { 
            checkCollision(other);
        }
        // If Player collides with meth objects a specific amount
        if (collisionCount == 3) {
            System.out.println("Max debuff applied");
            collisionCount = 0;
            Greenfoot.stop(); // stops game
            Greenfoot.setWorld(new Menu()); // placeholder after crash sends to main menu
        }
        
    }

    public boolean checkCollision(Actor other) {
        if (other == null) {
            return true;
        }
        
        // Get current actor's position and size
        int x1 = obstacle.getX() - obstacle.getImage().getWidth() / 2;
        int y1 = obstacle.getY() - obstacle.getImage().getHeight() / 2;
        int width1 = obstacle.getImage().getWidth();
        int height1 = obstacle.getImage().getHeight();

        // Get other actor's position and size
        int x2 = other.getX() - other.getImage().getWidth() / 2;
        int y2 = other.getY() - other.getImage().getHeight() / 2;
        int width2 = other.getImage().getWidth();
        int height2 = other.getImage().getHeight();

        // Check for rectangular overlap
        return x1 < x2 + width2 && x1 + width1 > x2 &&
           y1 < y2 + height2 && y1 + height1 > y2;
        
        /*if (true) {
            collisionCount++;
            System.out.println("Meth Collision Count: " + collisionCount);
            destroy();
        }*/
    }
    public World getWorld() {
        return obstacle.getWorld();
    }
    public void move() {
        obstacle.setLocation(obstacle.getX(), obstacle.getY() + moveSpeed);
    }
   
    public void destroy() {
        World world = obstacle.getWorld();
        world.removeObject(obstacle);
       
    }
    
    
    
}
