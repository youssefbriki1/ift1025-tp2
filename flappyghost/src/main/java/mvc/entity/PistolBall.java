package mvc.entity;
public class PistolBall {
    double x, y;



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
}