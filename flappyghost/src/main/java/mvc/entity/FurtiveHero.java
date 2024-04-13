package mvc.entity;

public class FurtiveHero extends Hero{
    private double x;
    private double y;
    private double w;
    private double vx = 0;
    private double vy = 0;

    public FurtiveHero(double x, double y, String imgUrl){
        this.x = x;
        this.y = y;
    }

    @Override
    void touched(Enemy enemy) {
        int enemyPieces = enemy.getPieces();
        if (enemyPieces > 10){
            enemy.setPieces(enemyPieces - 10);
        }
        else{
            enemy.setPieces(0);
        }
        }

    @Override
    void isKilled(Enemy enemy) {
        enemy.setPieces(enemy.getPieces() + 8);
        }

    @Override
    void moving() {
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
