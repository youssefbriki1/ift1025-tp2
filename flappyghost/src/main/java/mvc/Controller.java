package mvc;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import mvc.entity.Coin;
import mvc.entity.Enemy;
import mvc.entity.GameBackground;
import mvc.entity.Hero;
import mvc.entity.PistolBall;
import mvc.entity.HandToHandHero;
import mvc.entity.FurtiveHero;
import mvc.entity.TankHero;
import mvc.Model;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private Model model;
    private View view;

    private Enemy enemy;

    private GraphicsContext context;
    private Pane root;

    private GameBackground background;

    private int WIDTH, HEIGHT;

    private long lastFire = 0;
    private long fireTimer;

    private boolean isPlaying = true;

    private double enemyVx, enemyVy, enemyAy;

    public Controller(Model m, View v){
        this.model = m;
        this.view = v;
        this.enemy = m.getEnemy();
        this.background = m.getBackground();
        this.context = v.getContext();
        this.root = v.getRoot();
        WIDTH = 640;
        HEIGHT = 440;

        this.view.setOnKeyPressed( ( event ) -> {
            if( event.getCode() == KeyCode.SPACE) {
                System.out.println( "Space" );
                enemy.jump();
            }
        });

        this.view.getGameButton().setOnAction((action) -> {
            String txt = this.view.getGameButton().getText();
            if(txt.equals("Pause")){
                this.pauseGame();
            }
            else{
                this.resumeGame();
            }
        });
    }

    public void pauseGame(){
        this.view.getGameButton().setText("Resume");
        enemyAy = this.enemy.getAy();
        enemyVx = this.enemy.getVx();
        enemyVy = this.enemy.getVy();
        this.enemy.setAy(0);
        this.enemy.setVx(0);
        this.enemy.setVy(0);
        isPlaying = false;
    }

    public void resumeGame(){
        this.view.getGameButton().setText("Pause");
        this.enemy.setAy(enemyAy);
        this.enemy.setVx(enemyVx);
        this.enemy.setVy(enemyVy);
        isPlaying = true;
    }


    public void coinGeneration(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(isPlaying){
                    Random rand = new Random();
                    int y_pos = rand.nextInt(370);
                    Image coinImg = new Image("coin.png");
                    double w = coinImg.getWidth();
                    double h = coinImg.getHeight();
                    Coin coin = new Coin(640, y_pos, w, h);
                    System.out.println("Coin w " + w + " h " + h);
                    System.out.println("Enemy w " + enemy.getW() + " h " + enemy.getH());



                    model.addNewCoin(coin);
                }
            }
        }, 0, 2000);

    }

        public void heroGenerator(){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(isPlaying) {
                        Random rand = new Random();
                        int y_pos = rand.nextInt(300);
                        // Hero creation
                        Hero newHero;
                        int heroType = (int) (Math.random() * 3);
                        System.out.println("Hero type: " + heroType);

                        double w = Math.random() * 40 + 40;

                        if (heroType == 0) {
                            // A corriger les positionnement
                            newHero = new HandToHandHero(640 + Math.random() * 100, y_pos, "ball.png",0,0, w);

                        } else if (heroType == 1) {
                            // A corriger
                            System.out.println(y_pos);
                            newHero = new FurtiveHero(640 + Math.random() * 100, y_pos, "pessi.png",1,1, w);
                        } else {
                            // A corriger
                            newHero = new TankHero(640 + Math.random() * 100, y_pos, "perry.png",100,100, w);
                        }

                        model.addHero(newHero);

                    }

                }
            }, 0, 2000); 
        }
    public void fireBall(){
        System.out.println("fireee");
        if(fireTimer - lastFire > 1e9) {
            double x = enemy.getX() + enemy.getW() + 40;
            double y = enemy.getY() + enemy.getH() / 2;
            PistolBall theBall = new PistolBall(x, y);
            model.addNewPistolBall(theBall);
            lastFire = fireTimer;
        }
        else{
            System.out.println("Not enough time");
        }
    }

    public void gameOver(){
        pauseGame();
        view.setGameOver();
    }

    public void gameAnimation(){
        Image enemyImg = new Image(enemy.getImg_url());
        Image backgroundImg = new Image(this.background.getImg_url());
        Image coinImg = new Image("coin.png");

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double deltaTime = (now - lastTime) * 1e-9;
                context.clearRect(0, 0, WIDTH, HEIGHT);


                //background movement
                background.update(deltaTime, Math.abs(enemy.getVx()));
                context.drawImage(backgroundImg, background.getX(), 0);
                context.drawImage(backgroundImg, background.getX() + 640, 0);


                for(Hero hero : model.getHeroList()){
                    if (hero instanceof TankHero && isPlaying){
                        TankHero heroTank = (TankHero) hero;
                        heroTank.moving();
                        heroTank.setTankHeroMove(now);
                    }
                    else if (isPlaying){
                        hero.moving();
                    }


                hero.update(deltaTime, enemy.getVx());


                    boolean ifTouch = enemy.checkHero(hero);
                    if (hero.isAlive() && ifTouch && !hero.isDisabled()){
                        hero.touched(enemy);
                        System.out.println("Touched");

                       /* if(enemy.getLife() == 0){
                            System.out.println("**** enemy" + enemy.getX() + " " + enemy.getY() + " " + enemy.getW() + " " + enemy.getH());
                            System.out.println("**** hero " + hero.getX() + " " + hero.getY() + " " + hero.getW() + " " + hero.getH());
                            context.fillOval(enemy.getX() - enemy.getW()/2, enemy.getY() - enemy.getH()/2, enemy.getW(), enemy.getH());
                            context.fillOval(hero.getX(), hero.getY(), hero.getW(), hero.getH());

                        }*/
                        hero.setTouched();
                        hero.setIsDisabled(true);
                    }
                    

                    hero.moveHero(hero.getX(), hero.getY());

                    if(!hero.isAdded()){
                        ImageView heroView = hero.getHeroView();
                        root.getChildren().add(heroView);
                        hero.setAdded();
                    }
                }

                //coin movement

                for(Coin theCoin: model.getCoinList()){
                    theCoin.update(deltaTime, enemy.getVx());
                    boolean ifTouch = enemy.checkCoin(theCoin);
                    if(ifTouch){
                        enemy.increaseSpeed();
                        model.removeCoin(theCoin);
                        enemy.increaseCoin();
                    }
                    else if(theCoin.getX() < -60){
                        model.removeCoin(theCoin);
                    }
                    else {
                        context.drawImage(coinImg,  theCoin.getX() - theCoin.getW()/2,  theCoin.getY() - theCoin.getH()/2);
                    }
                }

                //update enemy
                enemy.update(deltaTime);
                context.drawImage(enemyImg, enemy.getX() - enemy.getW() / 2, enemy.getY() - enemy.getH() / 2);


                Image ballImg = new Image("ball.png");
                for(PistolBall ball : model.getPistolBallList()){
                    ball.update(deltaTime, enemy.getVx() * 10);
                    context.fillOval(ball.getX() , ball.getY(), 10, 10);
                    for (Hero hero : model.getHeroList()){
                        if (ball.getY() > hero.getY() && ball.getY() > hero.getY() - hero.getW() && ball.getX() <= hero.getX() && !ball.getHasKilled()){
                            hero.isKilled(enemy);
                            System.out.println("Killed");
                            model.killHero(hero);
                            root.getChildren().remove(hero.getHeroView());
                            ball.setHasKilled(true);
                        }
                    }
                    ball.setHasKilled(true);
                }
                lastTime = now;
                fireTimer = now;

                int coinCount = enemy.getPieces();
                view.updatePiece(coinCount);
                int life = enemy.getLife();
                view.updateLife(life);
                if(life == 0){
                    gameOver();
                    stop();
                }






            }
        };
        timer.start();
    }

    public void startGame(){
        coinGeneration();
        heroGenerator();
        gameAnimation();
    }

}
