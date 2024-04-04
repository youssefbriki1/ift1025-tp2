package Characters;

public class FurtiveHero extends Hero{

    @Override
    void touched(Enemy enemy) {
        throw new UnsupportedOperationException("Unimplemented method 'touched'");
    }

    @Override
    void isKilled() {
        throw new UnsupportedOperationException("Unimplemented method 'isKilled'");
    }

    @Override
    void moving() {
        throw new UnsupportedOperationException("Unimplemented method 'moving'");
    }
    
}
