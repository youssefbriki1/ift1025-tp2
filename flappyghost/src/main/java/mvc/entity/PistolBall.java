package mvc.entity;
public class PistolBall {
    private double x, y;
    private boolean hasKilled = false;



    public PistolBall(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void update(double dt, double vx){
        double newX = x + vx * dt;
        this.x = newX ;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public boolean isHasKilled() {
        return hasKilled;
    }

    public void setHasKilled(boolean hasKilled) {
        this.hasKilled = hasKilled;
    }
}
