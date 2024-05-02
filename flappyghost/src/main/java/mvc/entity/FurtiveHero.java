package mvc.entity;

/**
 * The {@code FurtiveHero} class represents a furtive hero entity in the game.
 * It extends the {@code Hero} class and adds additional behavior
 *  specific to the furtive hero.
 */
public class FurtiveHero extends Hero {
    private boolean goingUp = true;
    private double initialY;

    /**
     * Constructs a new {@code FurtiveHero} object with the specified
     *  parameters.
     *
     * @param x      the x-coordinate of the hero's position
     * @param y      the y-coordinate of the hero's position
     * @param imgUrl the URL of the hero's image
     * @param vx     the x-component of the hero's velocity
     * @param vy     the y-component of the hero's velocity
     * @param w      the width of the hero
     */
    public FurtiveHero(double x, double y, String imgUrl, double vx, 
    double vy, double w) {
        super(x, y, imgUrl, vx, vy, w);
        this.initialY = y;
        this.goingUp = true;
    }

    /**
     * Handles the collision between the furtive hero and an enemy.
     * Reduces the enemy's pieces by 10 if it has more than 10 pieces,
     *  otherwise sets the enemy's pieces to 0.
     *
     * @param enemy the enemy that the hero collided with
     */
    @Override
    public void touched(Enemy enemy) {
        System.out.println("FURTIVE TOUCHED");
        int enemyPieces = enemy.getPieces();
        if (enemyPieces > 10) {
            enemy.setPieces(enemyPieces - 10);
        } else {
            enemy.setPieces(0);
        }
    }

    /**
     * Handles the event when the furtive hero is killed by an enemy.
     * Increases the enemy's pieces by 8.
     *
     * @param enemy the enemy that killed the hero
     */
    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 8);
    }

    /**
     * Moves the furtive hero based on its current position and velocity.
     * The hero moves up and down within a certain range on the screen.
     */
    @Override
    public void moving() {
        // Condition to move the hero to not go over or under the screen

        int signe = goingUp ? 1 : -1;

        if (this.y > this.initialY + 50) {
            goingUp = false;
        } else if (this.y < this.initialY - 50) {
            goingUp = true;
        }

        if (this.y >= 0 && this.y <= 400) {
            this.y += signe * this.vy;
        } else if (this.y <= 0) {
            goingUp = true;
            this.y = 1;
        } else {
            goingUp = false;
            this.y = 319;
        }
    }
}
