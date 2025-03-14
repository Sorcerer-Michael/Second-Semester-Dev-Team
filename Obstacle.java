
public interface Obstacle {
    public String statusEffect = null;
    public void update();
    public void checkCollision();
    public void move();
    public void destroy();
}