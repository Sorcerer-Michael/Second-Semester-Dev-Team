import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class backButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    /**
     * Act - do whatever the backButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButton(){
        setImage("backarrow1.png");
    }
    
    public void act()
    {
        if(){
            setImage("backarrow2.png");
        }
        else{
            setImage("backarrow1.png");
        }
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu());
        }
    } 
}
