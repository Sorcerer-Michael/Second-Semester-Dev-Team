import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    public StartButton() {
        setImage("start_button.png");
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new RoadWorld());
            //Greenfoot.setWorld(new CharacterSelection());
        }
    }
}
