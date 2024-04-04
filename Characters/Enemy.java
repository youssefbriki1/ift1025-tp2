package Characters;
public class Enemy {
    // Attributes
    public int speed;
    private int coins;

    public Enemy(){
        this.speed = 120;
        this.coins = 0;
    }
    
    public int getCoins(){
        return this.coins;
    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public void jump(){

    }

    public void shoot(){

    }

    
}
