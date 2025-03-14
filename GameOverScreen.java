import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends Actor
{
    private GreenfootImage box;
    //private RestartButton restartButton;
    //private HomeButton homeButton;
    
    
    /**
     * Act - do whatever the GameOverScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public GameOverScreen(){
        int boxWidth = 300;
        int boxHeight = 200;
        
        box = new GreenfootImage(boxWidth, boxHeight);
        box.setColor(new Color(0,0,0,180));
        box.fillRect(0, 0, boxWidth, boxHeight);
        
        setImage(box);        
        
    }
    
}
