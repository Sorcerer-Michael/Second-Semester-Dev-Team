import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class previousCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class previousCharacter extends Actor
{
    /**
     * Act - do whatever the previousCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage stage1;
    private GreenfootImage stage2;
    
    private boolean counting;
    private int counter;
    
    public previousCharacter(){
        stage1 = new GreenfootImage("redofirstleft.png");
        stage2 = new GreenfootImage("leftchange2.png");
        
        stage1.scale(stage1.getWidth()*4, stage1.getHeight()*4);
        stage2.scale(stage2.getWidth()*4, stage2.getHeight()*4);
        
        setImage(stage1);
    }
    public void act()
    {
        
        if (counting){
            counter++;
            if (counter >= 10){
                setImage(stage1);
                counting = !counting;
            }
        }
        if(Greenfoot.mouseClicked(this)){
            setImage(stage2);
            counting = true;
            counter = 0;
        }
        
    }
}
