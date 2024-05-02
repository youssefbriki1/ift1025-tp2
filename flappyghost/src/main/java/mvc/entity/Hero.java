package mvc.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The abstract class representing a Hero entity in the game.
 */
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

    /**
     * Constructs a Hero object with the specified initial position, image URL, velocity, and width.
     *
     * @param x      the initial x-coordinate of the Hero
     * @param y      the initial y-coordinate of the Hero
     * @param imgUrl the URL of the Hero's image
     * @param vx     the x-velocity of the Hero
     * @param vy     the y-velocity of the Hero
     * @param w      the width of the Hero
     */
    public Hero(double x, double y, String imgUrl, double vx, double vy, double w) {
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

    /**
     * Handles the collision between the Hero and an Enemy.
     *
     * @param enemy the Enemy object that the Hero collided with
     */
    public abstract void touched(Enemy enemy);

    /**
     * Handles the event when the Hero kills an Enemy.
     *
     * @param enemy the Enemy object that the Hero killed
     */
    public abstract void isKilled(Enemy enemy);

    /**
     * Handles the movement of the Hero.
     */
    public abstract void moving();

    /**
     * Returns the x-coordinate of the Hero.
     *
     * @return the x-coordinate of the Hero
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the Hero.
     *
     * @return the y-coordinate of the Hero
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the URL of the Hero's image.
     *
     * @return the URL of the Hero's image
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Returns the width of the Hero.
     *
     * @return the width of the Hero
     */
    public double getW() {
        return w;
    }

    /**
     * Returns the height of the Hero.
     *
     * @return the height of the Hero
     */
    public double getH() {
        return h;
    }

    /**
     * Sets the x-coordinate of the Hero.
     *
     * @param x the new x-coordinate of the Hero
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the Hero.
     *
     * @param y the new y-coordinate of the Hero
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the URL of the Hero's image.
     *
     * @param imgUrl the new URL of the Hero's image
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Sets the width of the Hero.
     *
     * @param w the new width of the Hero
     */
    public void setW(double w) {
        this.w = w;
    }

    /**
     * Sets the height of the Hero.
     *
     * @param h the new height of the Hero
     */
    public void setH(double h) {
        this.h = h;
    }

    /**
     * Updates the position of the Hero based on the elapsed time and x-velocity.
     *
     * @param dt the elapsed time
     * @param vx the x-velocity of the Hero
     */
    public void update(double dt, double vx) {
        this.x -= dt * vx;
    }

    /**
     * Checks if the Hero is alive.
     *
     * @return true if the Hero is alive, false otherwise
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets the alive state of the Hero.
     *
     * @param isAlive the new alive state of the Hero
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Returns the x-velocity of the Hero.
     *
     * @return the x-velocity of the Hero
     */
    public double getVx() {
        return vx;
    }

    /**
     * Sets the x-velocity of the Hero.
     *
     * @param vx the new x-velocity of the Hero
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * Returns the y-velocity of the Hero.
     *
     * @return the y-velocity of the Hero
     */
    public double getVy() {
        return vy;
    }

    /**
     * Sets the y-velocity of the Hero.
     *
     * @param vy the new y-velocity of the Hero
     */
    public void setVy(double vy) {
        this.vy = vy;
    }

    /**
     * Returns the ImageView object representing the Hero's view.
     *
     * @return the ImageView object representing the Hero's view
     */
    public ImageView getHeroView() {
        return heroView;
    }

    /**
     * Moves the Hero to the specified coordinates.
     *
     * @param newX the new x-coordinate of the Hero
     * @param newY the new y-coordinate of the Hero
     */
    public void moveHero(double newX, double newY) {
        heroView.setX(newX);
        heroView.setY(newY);
    }

    /**
     * Checks if the Hero is added to the view.
     *
     * @return true if the Hero is added to the view, false otherwise
     */
    public boolean isAdded() {
        return this.addedToView;
    }

    /**
     * Sets the added state of the Hero.
     */
    public void setAdded() {
        this.addedToView = true;
    }

    /**
     * Checks if the Hero is touched.
     *
     * @return true if the Hero is touched, false otherwise
     */
    public boolean isTouched() {
        return this.isTouched;
    }

    /**
     * Sets the touched state of the Hero.
     */
    public void setTouched() {
        this.isTouched = true;
    }

    /**
     * Sets the disabled state of the Hero.
     *
     * @param state the new disabled state of the Hero
     */
    public void setIsDisabled(boolean state) {
        this.isDisabled = state;
    }

    /**
     * Checks if the Hero is disabled.
     *
     * @return true if the Hero is disabled, false otherwise
     */
    public boolean isDisabled() {
        return this.isDisabled;
    }

    /**
     * Sets the ID of the Hero.
     *
     * @param id the new ID of the Hero
     */
    public void setId(int id) {
        this.id = id;
    }
}
