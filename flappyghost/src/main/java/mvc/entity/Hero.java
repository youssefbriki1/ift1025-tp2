package mvc.entity;

public abstract class Hero {
    // Attributes
    private double x;
    private double y;
    

    abstract void touched(Enemy enemy);
    abstract void isKilled(Enemy enemy);
    abstract void moving();    
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}