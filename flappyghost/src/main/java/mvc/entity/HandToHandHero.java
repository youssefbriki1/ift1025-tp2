package mvc.entity;

public class HandToHandHero extends Hero{
    public HandToHandHero(double x, double y, String imgUrl, double vx, double vy){
        super(x, y, imgUrl, vx, vy);
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
        this.x += this.vx;
        this.y += this.vy; 
        }
    
}
