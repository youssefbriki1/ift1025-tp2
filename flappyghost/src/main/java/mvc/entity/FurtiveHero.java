package mvc.entity;

public class FurtiveHero extends Hero{
    // A determiner
    private double vy = 100;

    public FurtiveHero(double x, double y, String imgUrl, double vx, double vy){
        super(x, y, imgUrl, vx, vy);
        }

    @Override
    public void touched(Enemy enemy) {
        int enemyPieces = enemy.getPieces();
        if (enemyPieces > 10){
            enemy.setPieces(enemyPieces - 10);
        }
        else{
            enemy.setPieces(0);
        }
        }

    @Override
    public void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 8);
        }

    @Override
    public void moving() {
        // Condition to move the hero to not go over or under the screen
        if (this.y + this.vy > 0 && this.y + this.vy < 320){
            this.y += vy;
        }
        else if (this.y + this.vy < 0){
            this.y = 0;
        }
        else{
            this.y = 320;
        }
    
    }}
