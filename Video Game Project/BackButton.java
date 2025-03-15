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
    private GreenfootImage stage1;
    private GreenfootImage stage2;
    
    private boolean counting;
    private int counter;
    
    public BackButton(){
        stage1 = new GreenfootImage("backarrow1.png");
        stage2 = new GreenfootImage("backarrow2.png");
        
        stage1.scale(stage1.getWidth()*2, stage1.getHeight()*2);
        stage2.scale(stage2.getWidth()*2, stage2.getHeight()*2);
        
        setImage(stage1);
        
    }
    
    public void act()
    {
        if (counting){
            counter++;
            if (counter >= 10){
                setImage(stage1);
                counting = !counting;
                Greenfoot.setWorld(new Menu());
            }
        }
        if(Greenfoot.mouseClicked(this)){
            setImage(stage2);
            counting = true;
            counter = 0;
        }
    } 
}
