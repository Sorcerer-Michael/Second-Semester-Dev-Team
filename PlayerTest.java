import greenfoot.Actor;

/**
 * Write a description of class PlayerTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTest
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class PlayerTest
     */
    
    public static void main(String[] args) {
        Player player = new Player();
        int initialRotation = player.getRotation();
        int playerSpeed = player.moveSpeed;
        int playerRotationSpeed = player.rotationSpeed;
        
        
        // Print initial rotation and position
        System.out.println("Initial Rotation: " + initialRotation);
        
        
        // Simulate pressing 'd' to turn right
        System.out.println("\nSimulating 'd' key press...");
        player.movement(true, false, false, false);
        System.out.println("Rotation after 'd' key press: " + player.getRotation());
                if (player.getRotation() != (initialRotation + playerRotationSpeed)) {
            System.out.println("Test Failed!");
        }
        
        // Simulate pressing 'a' to turn left
        System.out.println("\nSimulating 'a' key press...");
        player.movement(false, true, false, false);
        System.out.println("Rotation after 'a' key press: " + player.getRotation());
        if (player.getRotation() != (270)){
            System.out.println("Test Failed!");
        }

        // Simulate pressing 'w' to move forward
        System.out.println("\nSimulating 'w' key press...");
        player.movement(false, false, true, false);
        System.out.println("Player moved forward.");
        
        // Simulate pressing 's' to move backward
        System.out.println("\nSimulating 's' key press...");
        player.movement(false, false, false, true);
        System.out.println("Player moved backward.");
    }
    
    
}
