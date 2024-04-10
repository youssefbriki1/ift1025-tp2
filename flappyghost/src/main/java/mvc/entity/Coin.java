package mvc.entity;

public class Coin {
    private double x;
    private double y;

    private double w;
    private double h;



    public Coin(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void update(double dt, double vx ){
        this.x -= dt * vx;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }



}
