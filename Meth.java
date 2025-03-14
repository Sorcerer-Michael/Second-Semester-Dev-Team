import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meth extends Actor
{
    public String icon = "images/gold-ball.png";
    public String statusDebuffOnCollision = "confident";
    // Actor obstacle, int moveSpeed, String icon, String statusDebuffOnCollision
    
    
    public Meth(int moveSpeed) {
        Obstacle meth = new Obstacle(this, moveSpeed, icon, statusDebuffOnCollision);
    }
    public void act()
    {
        //update();
    }
    
    
    
    
    
}
