package mvc.entity;

public class GameBackground {
    double x;
    double vx;

    String img_url;

    public GameBackground(double x, double vx, String img_url){
        this.x = x;
        this.vx = vx;
        this.img_url = img_url;
    }

    public void update(double dt, double vx){
        double newX = x - vx * dt;
        if(newX < -640){
            newX += 640;
        }
        x = newX;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
