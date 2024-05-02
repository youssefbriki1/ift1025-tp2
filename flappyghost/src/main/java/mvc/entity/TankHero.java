package mvc.entity;

public class TankHero extends Hero {
    private long TankHeroMove = 0;
    private long TankHeroLastMove = 0;

    /**
     * Constructs a TankHero object with the specified parameters.
     *
     * @param x      the x-coordinate of the TankHero's position
     * @param y      the y-coordinate of the TankHero's position
     * @param imgUrl the image URL of the TankHero
     * @param vx     the x-component of the TankHero's velocity
     * @param vy     the y-component of the TankHero's velocity
     * @param w      the width of the TankHero
     */
    public TankHero(double x, double y, String imgUrl, double vx, double vy, 
    double w) {
        super(x, y, imgUrl, vx, vy, w);
    }

    /**
     * Decreases the enemy's life by 50 when the TankHero touches the enemy.
     *
     * @param enemy the enemy that the TankHero touched
     */
    @Override
    public void touched(Enemy enemy) {
        enemy.setLife(enemy.getLife() - 50);
    }

    /**
     * Increases the enemy's pieces by 7 when the TankHero kills the enemy.
     *
     * @param enemy the enemy that the TankHero killed
     */
    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 7);
    }

    /**
     * Moves the TankHero randomly in the x-direction and within the 
     * y-range of 0 to 280.
     */
    @Override
    public void moving() {
        // For x
        if (TankHeroMove - TankHeroLastMove > 1e9 / 2) {
            this.x = this.x + randomNumGenerator();
            double newY = this.y + randomNumGenerator();
            if (newY > 0 && newY < 280) {
                this.y = newY;
            } else if (newY < 0) {
                this.y = 0;
            } else {
                this.y = 280;
            }
            TankHeroLastMove = TankHeroMove;
        }
    }

    /**
     * Generates a random number that will be used in the function above.
     *
     * @return a random number within the range of -30 to 30
     */
    private double randomNumGenerator() {
        int sign = Math.random() < 0.5 ? -1 : 1;
        int randomNumber = (int) (Math.random() * 30 + 1);
        return sign * randomNumber;
    }

    /**
     * Sets the value of TankHeroMove.
     *
     * @param TankHeroMove the new value of TankHeroMove
     */
    public void setTankHeroMove(long TankHeroMove) {
        this.TankHeroMove = TankHeroMove;
    }

    /**
     * Sets the value of TankHeroLastMove.
     *
     * @param TankHeroLastMove the new value of TankHeroLastMove
     */
    public void setTankHeroLastMove(long TankHeroLastMove) {
        this.TankHeroLastMove = TankHeroLastMove;
    }

    /**
     * Returns the value of TankHeroMove.
     *
     * @return the value of TankHeroMove
     */
    public long getTankHeroMove() {
        return TankHeroMove;
    }

    /**
     * Returns the value of TankHeroLastMove.
     *
     * @return the value of TankHeroLastMove
     */
    public long getTankHeroLastMove() {
        return TankHeroLastMove;
    }
}
