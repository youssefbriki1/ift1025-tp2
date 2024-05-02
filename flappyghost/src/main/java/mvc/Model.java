package mvc;

import mvc.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Model {
    private Enemy enemy;
    private GameBackground background;

    private List<Hero> heroList = new CopyOnWriteArrayList<>();
    private int heroGenerated;

    private List<Coin> coinList = new CopyOnWriteArrayList<>();

    private List<PistolBall> pistolBallList = new CopyOnWriteArrayList<>();

    /**
     * Constructs a Model object with the specified enemy and game background.
     *
     * @param theEnemy   the enemy object in the game
     * @param background the game background object
     */
    public Model(Enemy theEnemy, GameBackground background) {
        this.enemy = theEnemy;
        this.background = background;
        this.heroGenerated = 0;
    }

    /**
     * Returns the enemy object in the game.
     *
     * @return the enemy object
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Sets the enemy object in the game.
     *
     * @param enemy the enemy object to set
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Returns the game background object.
     *
     * @return the game background object
     */
    public GameBackground getBackground() {
        return background;
    }

    /**
     * Sets the game background object.
     *
     * @param background the game background object to set
     */
    public void setBackground(GameBackground background) {
        this.background = background;
    }

    /**
     * Returns the list of coins in the game.
     *
     * @return the list of coins
     */
    public List<Coin> getCoinList() {
        return coinList;
    }

    /**
     * Adds a new coin to the game.
     *
     * @param theCoin the coin object to add
     */
    public void addNewCoin(Coin theCoin) {
        coinList.add(theCoin);
    }

    /**
     * Adds a new pistol ball to the game.
     *
     * @param theBall the pistol ball object to add
     */
    public void addNewPistolBall(PistolBall theBall) {
        pistolBallList.add(theBall);
    }

    /**
     * Returns the list of pistol balls in the game.
     *
     * @return the list of pistol balls
     */
    public List<PistolBall> getPistolBallList() {
        return pistolBallList;
    }

    /**
     * Adds a new hero to the game.
     *
     * @param hero the hero object to add
     */
    public void addHero(Hero hero) {
        heroGenerated++;
        hero.setId(heroGenerated);
        heroList.add(hero);
    }

    /**
     * Returns the number of heroes generated in the game.
     *
     * @return the number of heroes generated
     */
    public int getHeroGenerated() {
        return heroGenerated;
    }

    /**
     * Returns the list of heroes in the game.
     *
     * @return the list of heroes
     */
    public List<Hero> getHeroList() {
        return heroList;
    }

    /**
     * Removes a hero from the game.
     *
     * @param hero the hero object to remove
     */
    public void killHero(Hero hero) {
        heroList.remove(hero);
    }

    /**
     * Removes a coin from the game.
     *
     * @param coin the coin object to remove
     */
    public void removeCoin(Coin coin) {
        coinList.remove(coin);
    }
}
