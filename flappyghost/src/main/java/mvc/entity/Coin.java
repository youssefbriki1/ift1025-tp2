package mvc.entity;

/**
 * The Coin class represents a coin entity in the game.
 */
public class Coin {
    private double x;
    private double y;

    private double w;
    private double h;

    /**
     * Constructs a new Coin object with the specified position and dimensions.
     *
     * @param x The x-coordinate of the coin's position.
     * @param y The y-coordinate of the coin's position.
     * @param w The width of the coin.
     * @param h The height of the coin.
     */
    public Coin(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    /**
     * Updates the coin's position based on the elapsed time and velocity.
     *
     * @param dt The elapsed time since the last update.
     * @param vx The velocity of the coin.
     */
    public void update(double dt, double vx) {
        this.x -= dt * vx;
    }

    /**
     * Returns the x-coordinate of the coin's position.
     *
     * @return The x-coordinate of the coin's position.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the coin's position.
     *
     * @return The y-coordinate of the coin's position.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the width of the coin.
     *
     * @return The width of the coin.
     */
    public double getW() {
        return w;
    }

    /**
     * Returns the height of the coin.
     *
     * @return The height of the coin.
     */
    public double getH() {
        return h;
    }
}
