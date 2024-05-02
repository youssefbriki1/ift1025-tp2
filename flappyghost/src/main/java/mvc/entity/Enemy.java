package mvc.entity;

import javafx.scene.image.Image;

import static java.lang.Math.sqrt;

public class Enemy {

    private String img_url;
    private double x, y;
    private double w, h;

    private double vx, vy;

    private double ax, ay;

    private int life = 100;
    private int pieces;

    /**
     * Constructs a new Enemy object.
     *
     * @param x       the initial x-coordinate of the enemy
     * @param y       the initial y-coordinate of the enemy
     * @param vx      the initial velocity in the x-direction of the enemy
     * @param vy      the initial velocity in the y-direction of the enemy
     * @param ax      the acceleration in the x-direction of the enemy
     * @param ay      the acceleration in the y-direction of the enemy
     * @param img_url the URL of the image for the enemy
     */
    public Enemy(double x, double y, double vx, double vy, double ax, 
    double ay, String img_url) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.img_url = img_url;
        this.pieces = 0;
        Image enemyImg = new Image(img_url);
        this.w = enemyImg.getWidth();
        this.h = enemyImg.getHeight();
    }

    /**
     * Makes the enemy jump by changing its vertical velocity.
     */
    public void jump() {
        vy = -300;
    }

    /**
     * Updates the enemy's position and velocity based on the elapsed time.
     *
     * @param dt the elapsed time since the last update
     */
    public void update(double dt) {
        if (-300 <= vy && vy <= 300)
            vy += dt * ay;

        double newY = y + dt * vy;

        if (newY + h / 2 > 400 || newY - h / 2 < 0) {
            vy *= -1;
        } else {
            y = newY;
        }
    }

    /**
     * Increases the number of coins collected by the enemy.
     */
    public void increaseCoin() {
        this.pieces += 1;
    }

    public int getCoin(){
        return this.pieces;
    }

    /**
     * Checks if the enemy collides with a coin using circle-circle collision 
     * detection.
     *
     * @param coin the coin to check for collision
     * @return true if the enemy collides with the coin, false otherwise
     */
    public boolean checkCoin2(Coin coin) {
        double x1 = x;
        double y1 = y;
        double r1 = w / 2;

        double coin_w = coin.getW();
        double coin_h = coin.getH();

        double x2 = coin.getX();
        double y2 = coin.getY();
        double r2 = coin_w / 2;

        double dist = sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return (dist <= r1 + r2);
    }

    /**
     * Checks if the enemy collides with a coin using axis-aligned bounding
     *  box collision detection.
     *
     * @param theCoin the coin to check for collision
     * @return true if the enemy collides with the coin, false otherwise
     */
    public boolean checkCoin(Coin theCoin) {
        double x1 = x;
        double y1 = y;
        double w1 = w;
        double h1 = h;

        double x2 = theCoin.getX();
        double y2 = theCoin.getY();
        double w2 = theCoin.getW();
        double h2 = theCoin.getH();

        if ((x1 + w1 / 2 < x2 - w2 / 2) || (x2 + w2 / 2 < x1 - w1 / 2)
                || (y2 + h2 / 2 < y1 - h1 / 2) || (y1 + h1 / 2 < y2 - h2 / 2)) 
                {
            return false;
        }
        return true;
    }

    /**
     * Checks if the enemy collides with a hero using axis-aligned bounding box 
     * collision detection.
     *
     * @param theHero the hero to check for collision
     * @return true if the enemy collides with the hero, false otherwise
     */
    public boolean checkHero(Hero theHero) {
        double x1 = x;
        double y1 = y;
        double w1 = w - 15;
        double h1 = h - 15;

        double x2 = theHero.getX();
        double y2 = theHero.getY();
        double w2 = theHero.getW() - 15;
        double h2 = theHero.getH() - 15;

        if ((x1 + w1 / 2 < x2) || (x2 + w2 < x1 - w1 / 2)
                || (y2 + h2 < y1 - h1 / 2) || (y1 + h1 / 2 < y2)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the enemy collides with a hero using circle-circle
     *  collision detection.
     *
     * @param hero the hero to check for collision
     * @return true if the enemy collides with the hero, false otherwise
     */
    public boolean checkHero2(Hero hero) {
        double x1 = x;
        double y1 = y;
        double r1 = w / 2;

        double hero_w = hero.getW();

        double x2 = hero.getX();
        double y2 = hero.getY();
        double r2 = hero_w / 2;

        double dist = sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return (dist <= r1 + r2);
    }

    // Getters and Setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
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

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Increases the speed of the enemy by adjusting the acceleration and velocity.
     */
    public void increaseSpeed() {
        this.ay += 15;
        this.vx += 10;
    }
}
