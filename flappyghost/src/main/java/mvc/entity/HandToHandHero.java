package mvc.entity;

public class HandToHandHero extends Hero {

    /**
     * Constructs a HandToHandHero object with the specified parameters.
     *
     * @param x      the x-coordinate of the hero
     * @param y      the y-coordinate of the hero
     * @param imgUrl the image URL of the hero
     * @param vx     the velocity in the x-direction of the hero
     * @param vy     the velocity in the y-direction of the hero
     * @param w      the width of the hero
     */
    public HandToHandHero(double x, double y, String imgUrl, double vx, 
    double vy, double w) {
        super(x, y, imgUrl, vx, vy, w);
    }

    /**
     * Overrides the touched method from the Hero class.
     * Sets the life of the enemy to 0 when the hero touches it.
     *
     * @param enemy the enemy that the hero touched
     */
    @Override
    public void touched(Enemy enemy) {
        enemy.setLife(0);
    }

    /**
     * Overrides the isKilled method from the Hero class.
     * Increases the pieces of the enemy by 5 when the hero kills it.
     *
     * @param enemy the enemy that the hero killed
     */
    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 5);
    }

    /**
     * Overrides the moving method from the Hero class.
     * Updates the position of the hero based on its velocity.
     */
    @Override
    public void moving() {
        this.x += this.vx;
        this.y += this.vy;
    }
}
