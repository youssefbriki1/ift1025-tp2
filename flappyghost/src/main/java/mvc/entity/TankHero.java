package mvc.entity;

public class TankHero extends Hero {
    private double x;
    private double y;
    private double w;

    public TankHero(double x, double y, String imgUrl){
        this.x = x;
        this.y = y;
    }

    @Override
    void touched(Enemy enemy) {
        enemy.setLife(enemy.getLife() / 2);
        }

    @Override
    void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 7);
        }

    @Override
    void moving() {
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


    public double randomNumGenerator(){
        int sign = Math.random() < 0.5 ? -1 : 1;
        int randomNumber = (int) (Math.random() * 30 + 1);
        return sign * randomNumber;
    }
    
}
