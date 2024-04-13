package mvc.entity;

public abstract class Hero {
    // Attributes
    

    abstract void touched(Enemy enemy);
    abstract void isKilled(Enemy enemy);
    abstract void moving();    
}