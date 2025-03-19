import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoButton extends Actor
{
    /**
     * Act - do whatever the GoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage stage1;
    private GreenfootImage stage2;
    
    private boolean counting;
    private int counter;
    
    public GoButton(){
        stage1 = new GreenfootImage("beginOne.png");
        stage2 = new GreenfootImage("beginTwo.png");
        
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
                Greenfoot.setWorld(new RoadWorld());
            }
        }
        if(Greenfoot.mouseClicked(this)){
            setImage(stage2);
            counting = true;
            counter = 0;
        }
    }
}
