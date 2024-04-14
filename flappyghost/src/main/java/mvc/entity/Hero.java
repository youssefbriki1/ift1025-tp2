package mvc.entity;

public abstract class Hero {
    // Attributes
    protected double x;
    protected double y;
    protected String imgUrl;
    protected double w;
    protected double h;

    public Hero(double x, double y, String imgUrl){
        this.x = x;
        this.y = y;
        this.imgUrl = imgUrl;
    }
    

    abstract void touched(Enemy enemy);
    abstract void isKilled(Enemy enemy);
    abstract void moving();    
    
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

}