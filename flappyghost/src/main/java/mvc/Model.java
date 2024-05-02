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

    public Model(Enemy theEnemy, GameBackground background){
        this.enemy = theEnemy;
        this.background = background;
        this.heroGenerated = 0;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public GameBackground getBackground() {
        return background;
    }


    public void setBackground(GameBackground background) {
        this.background = background;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }


    public void addNewCoin(Coin theCoin){
        coinList.add(theCoin);
    }

    public void addNewPistolBall(PistolBall theBall){
        pistolBallList.add(theBall);
    }

    public List<PistolBall> getPistolBallList(){
        return pistolBallList;
    }


//  To be implemented 
    public void addHero(Hero hero){
        heroGenerated++;
        hero.setId(heroGenerated);
        heroList.add(hero);
        }
    public int getHeroGenerated(){
        return heroGenerated;
    }

    public List<Hero> getHeroList(){
        return heroList;
    }
    public void killHero(Hero Hero){
        heroList.remove(Hero);
    }

    public void removeCoin(Coin coin){
        coinList.remove(coin);
    }

    // public static Hero createHero(){
    //     int heroType = (int) Math.random() * 3;
    //     if(heroType == 0){
    //         // A corriger les positionnement
    //         return new HandToHandHero(Math.random(), Math.random(), null); 

    //     }
    //     else if(heroType == 1){
    //         // A corriger
    //         return new FurtiveHero(Math.random(), Math.random(), null);
    //     }
    //     else{
    //         // A corriger
    //         return new TankHero(heroType, heroType, null);
    //     }
    // }

// Add how we can add types of Heroes

}
