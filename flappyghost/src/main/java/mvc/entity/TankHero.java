package mvc.entity;

public class TankHero extends Hero {
    private long TankHeroMove = 0;
    private long TankHeroLastMove = 0;

    public TankHero(double x, double y, String imgUrl, double vx, double vy, double w){
        super(x, y, imgUrl, vx, vy, w);
        }

    @Override
    public void touched(Enemy enemy) {
        enemy.setLife(enemy.getLife()/2);
        }

    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 7);
        }

    @Override
    public void moving() {
        // For x
        if (TankHeroMove - TankHeroLastMove > 1e9/2) {
            
        this.x = this.x + randomNumGenerator();
        double newY = this.y + randomNumGenerator();
        if (newY > 0 && newY < 280){
            this.y = newY;
        }
        else if (newY < 0){
            this.y = 0;
        }
        else{
            this.y = 280;
        }
        TankHeroLastMove = TankHeroMove;
    }
}

    // Method to generate a random number in this particular case
    private double randomNumGenerator(){
        int sign = Math.random() < 0.5 ? -1 : 1;
        int randomNumber = (int) (Math.random() * 30 + 1);
        return sign * randomNumber;
    }

    public void setTankHeroMove(long TankHeroMove) {
        this.TankHeroMove = TankHeroMove;
    }

    public void setTankHeroLastMove(long TankHeroLastMove) {
        this.TankHeroLastMove = TankHeroLastMove;
    }

    public long getTankHeroMove() {
        return TankHeroMove;
    }

    public long getTankHeroLastMove() {
        return TankHeroLastMove;
    }

    
}
