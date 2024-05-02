package mvc.entity;

/**
 * The PistolBall class represents a bullet fired from a pistol.
 * It keeps track of the position and whether it has killed an enemy.
 */
public class PistolBall {
    private double x, y;
    private boolean hasKilled = false;

    /**
     * Constructs a PistolBall object with the specified initial position.
     *
     * @param x The initial x-coordinate of the PistolBall.
     * @param y The initial y-coordinate of the PistolBall.
     */
    public PistolBall(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the position of the PistolBall based on the 
     * elapsed time and velocity.
     *
     * @param dt The elapsed time since the last update.
     * @param vx The velocity of the PistolBall.
     */
    public void update(double dt, double vx) {
        double newX = x + vx * dt;
        this.x = newX;
    }

    /**
     * Returns the current x-coordinate of the PistolBall.
     *
     * @return The x-coordinate of the PistolBall.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the current y-coordinate of the PistolBall.
     *
     * @return The y-coordinate of the PistolBall.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns whether the PistolBall has killed an enemy.
     *
     * @return true if the PistolBall has killed an enemy, false otherwise.
     */
    public boolean getHasKilled() {
        return hasKilled;
    }

    /**
     * Sets whether the PistolBall has killed an enemy.
     *
     * @param hasKilled true if the PistolBall has killed an enemy, 
     * false otherwise.
     */
    public void setHasKilled(boolean hasKilled) {
        this.hasKilled = hasKilled;
    }
}
