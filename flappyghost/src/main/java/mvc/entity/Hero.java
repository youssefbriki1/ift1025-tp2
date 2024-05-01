package mvc.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Hero {
    // Attributes
    protected double x;
    protected double y;
    protected String imgUrl;
    protected double w;
    protected double h;
    protected boolean isAlive = true;
    protected double vx;
    protected double vy;

    protected Image heroImage;
    protected ImageView heroView;

    protected boolean addedToView;

    private boolean isTouched;
    private boolean isDisabled;
    private int id;



    public Hero(double x, double y, String imgUrl, double vx, double vy, double w){
        this.x = x;
        this.y = y;
        this.imgUrl = imgUrl;
        this.vx = vx;
        this.vy = vy;
        this.addedToView = false;
        this.isTouched = false;
        this.w = w;
        this.h = w;
        this.isDisabled = false;

        this.heroImage = new Image(imgUrl);
        this.heroView = new ImageView();
        heroView.setImage(heroImage);
        heroView.setX(x);
        heroView.setY(y);
        heroView.setFitWidth(w);
        heroView.setPreserveRatio(true);
        System.out.println("hero width " + this.w + "hero height " + this.h);
        this.id = 0;
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
    public double getVx() {
        return vx;
    }
    public void setVx(double vx) {
        this.vx = vx;
    }
    public double getVy() {
        return vy;
    }
    public void setVy(double vy) {
        this.vy = vy;
    }

    public ImageView getHeroView() {
        return heroView;
    }

    public void moveHero(double newX, double newY){
        heroView.setX(newX);
        heroView.setY(newY);
    }

    public boolean isAdded(){
        return this.addedToView;
    }

    public void setAdded(){
        this.addedToView = true;
    }

    public boolean isTouched(){
        return this.isTouched;
    }

    public void setTouched(){
        this.isTouched = true;
    }

    public void setIsDisabled(boolean state){
        this.isDisabled = state;
    }

    public boolean isDisabled(){
        return this.isDisabled;
    }

    public void setId(int id){
        this.id = id;
    }

}
