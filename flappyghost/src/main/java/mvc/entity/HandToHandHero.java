package mvc.entity;

public class HandToHandHero extends Hero{
    private double x;
    private double y;
    private double w;
    private double vx = 0;
    private double vy = 0;

    public HandToHandHero(double x, double y, String imgUrl){
        this.x = x;
        this.y = y;
    }



    @Override
    void touched(Enemy enemy) {
        enemy.setLife(0);
        }

    @Override
    void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 5);
    }

    // Useless method
    @Override
    void moving() {
        this.x += vx;
        this.y += vy; 
        }
    
}
