package Heroes;
import Enemy.Enemy;

public abstract class Hero {
    abstract void touched(Enemy enemy);
    abstract void isKilled();
    abstract void moving();    
}
