package mvc.entity;

public class FurtiveHero extends Hero{
    // A determiner
    private boolean goingUp = true;
    private double initialY;
    public FurtiveHero(double x, double y, String imgUrl, double vx, double vy){
        super(x, y, imgUrl, vx, vy);
        this.initialY = y;
        this.goingUp = true;
        }


    @Override
    public void touched(Enemy enemy) {
        System.out.println("FURTIVE TOUCHED");
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
    
            int signe = goingUp ? 1 : -1;

            if (this.y > this.initialY + 50){
                goingUp = false;
            }
            else if (this.y < this.initialY - 50){
                goingUp = true;
            }

            if (this.y  >= 0 && this.y <= 400 ){
                this.y += signe * this.vy;
            }
            else if (this.y <= 0){
                goingUp = true;
                this.y = 1;
            }
            else{
                goingUp = false;
                this.y = 319;
            }
    
        }
    
    }
    

