package mvc;

import mvc.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Model {
    private Enemy enemy;
    private GameBackground background;

    private Coin[] coinList = new Coin[100];
    private boolean[] coinEaten = new boolean[100];
    private List<Hero> heroList = new CopyOnWriteArrayList<>();
    private int heroGenerated;
    
    private int coinMade;

    private PistolBall[] pistolBallList = new PistolBall[100];
    private int pistolNumber;

    public Model(Enemy theEnemy, GameBackground background){
        this.enemy = theEnemy;
        this.background = background;
        this.coinMade = 0;
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

    public Coin[] getCoinList() {
        return coinList;
    }

    public int getCoinMade() {
        return coinMade;
    }

    public boolean[] getCoinEaten() {
        return coinEaten;
    }

    public void addNewCoin(Coin theCoin){
        coinList[coinMade] = theCoin;
        coinEaten[coinMade] = false;
        coinMade++;
    }

    public void markCoinAsEaten(int i){
        this.coinEaten[i] = true;
    }

    public int eatenCoinCount(){
        int res = 0;
        for(int i = 0; i<coinMade; i++){
            if( coinEaten[i]) res++;
        }
        return res;
    }

    public void addNewPistolBall(PistolBall theBall){
        pistolBallList[pistolNumber] = theBall;
        pistolNumber++;
    }

    public void printCoinList(){
        for(int i = 0; i<coinMade; i++){
            System.out.print("[" + coinList[i].getX() + ", " + coinList[i].getY() + "] ");
        }
        System.out.println();
    }

    public PistolBall[] getPistolBallList() {
        return pistolBallList;
    }

    public int getPistolNumber() {
        return pistolNumber;
    }

    public void printPistolList(){
        for(int i = 0; i<pistolNumber; i++){
            System.out.print("[" + pistolBallList[i].getX() + ", " + pistolBallList[i].getY() + "] ");
        }
        System.out.println();
    }
//  To be implemented 
    public void addHero(Hero hero){
        heroGenerated++;
        hero.setId(heroGenerated);
        heroList.add(hero);
        }

    public void removeHero(Hero hero){
        heroList.remove(hero);
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
