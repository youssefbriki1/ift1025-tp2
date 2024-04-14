package mvc.entity;

public abstract class Hero {
    // Attributes
    protected double x;
    protected double y;
    protected String imgUrl;
    protected double w;
    protected double h;
    protected boolean isAlive = true;

    public Hero(double x, double y, String imgUrl){
        this.x = x;
        this.y = y;
        this.imgUrl = imgUrl;
    }
    

    public abstract void touched(Enemy enemy);
    public abstract void isKilled(Enemy enemy);
    public abstract void moving();    
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public double getW() {
        return w;
    }
    
    public double getH() {
        return h;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setW(double w) {
        this.w = w;
    } 

    public void setH(double h) {
        this.h = h;
    }
    public void update(double dt, double vx ){
        this.x -= dt * vx;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

}