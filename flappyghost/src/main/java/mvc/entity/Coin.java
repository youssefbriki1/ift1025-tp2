package mvc.entity;

public class Coin {
    private double x;
    private double y;

    private double w;
    private double h;

    private boolean isEaten;



    public Coin(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isEaten = false;
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

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eatean) {
        isEaten = eatean;
    }
}
