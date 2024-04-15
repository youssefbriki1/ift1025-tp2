package mvc.entity;

public class TankHero extends Hero {
    private long TankHeroTimer = 0;

    public TankHero(double x, double y, String imgUrl, double vx, double vy){
        super(x, y, imgUrl, vx, vy);
        }

    @Override
    public void touched(Enemy enemy) {
        enemy.setLife(enemy.getLife() / 2);
        }

    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 7);
        }

    @Override
    public void moving() {
        // For x
        this.x = this.x + randomNumGenerator();
        double newY = this.y + randomNumGenerator();
        if (newY > 0 && newY < 320){
            this.y = newY;
        }
        else if (newY < 0){
            this.y = 0;
        }
        else{
            this.y = 320;
        }
    }

    // Method to generate a random number in this particular case
    private double randomNumGenerator(){
        int sign = Math.random() < 0.5 ? -1 : 1;
        int randomNumber = (int) (Math.random() * 30 + 1);
        return sign * randomNumber;
    }
    
    public long getTankHeroTimer() {
        return TankHeroTimer;
    }

    public void setTankHeroTimer(long tankHeroTimer) {
        TankHeroTimer = tankHeroTimer;
    }
    
}
