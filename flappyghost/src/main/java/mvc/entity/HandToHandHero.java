package mvc.entity;

public class HandToHandHero extends Hero{
    private double vx = 0;
    private double vy = 0;

    public HandToHandHero(double x, double y, String imgUrl){
        super(x, y, imgUrl);
    }



    @Override
    public void touched(Enemy enemy) {
        enemy.setLife(0);
        }

    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 5);
    }

    // Useless method
    @Override
    public void moving() {
        this.x += vx;
        this.y += vy; 
        }
    
}
