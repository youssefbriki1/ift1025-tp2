package mvc;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
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


                    model.addNewCoin(coin);
                }


//                System.out.println("I would be called every 2 seconds");
            }
        }, 0, 2000);

    }

// To edit
        public void heroGenerator(){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(isPlaying) {
                        Random rand = new Random();
                        int y_pos = rand.nextInt(370);
                        // Hero creation
                        Hero newHero;
                        int heroType = (int) (Math.random() * 3);
                        System.out.println("Hero type: " + heroType);

                        if (heroType == 0) {
                            // A corriger les positionnement
                            newHero = new HandToHandHero(640 + Math.random() * 100, y_pos, "ball.png",0,0);

                        } else if (heroType == 1) {
                            // A corriger
                            System.out.println(y_pos);
                            newHero = new FurtiveHero(640 + Math.random() * 100, y_pos, "cheems.png",1,1);
                        } else {
                            // A corriger
                            newHero = new TankHero(640 + Math.random() * 100, y_pos, "perry.png",100,100);
                        }

                        Image heroImage = new Image(newHero.getImgUrl());
                        double w = heroImage.getWidth();
                        double h = heroImage.getHeight();
                        newHero.setW(w);
                        newHero.setH(h);

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
            model.printPistolList();
            lastFire = fireTimer;
        }
        else{
            System.out.println("Not enough time");
        }
    }
    public void gameAnimation(){
        Image enemyImg = new Image(enemy.getImg_url());
        Image backgroundImg = new Image(this.background.getImg_url());
        Image coinImg = new Image("coin.png");

        //context.drawImage(enemyImg, 0, 0);

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

                // Hero movement
                int limitHero = model.getHeroGenerated() - 10;
                if(limitHero < 0)
                    limitHero = 0;
                for(int i = limitHero; i<model.getHeroGenerated(); i++){
                    Hero hero = model.getHeroList().get(i);
                    if (hero instanceof TankHero && isPlaying){
                        TankHero heroTank = (TankHero) hero;
                        heroTank.moving();
                        heroTank.setTankHeroMove(now);
                        

                    }

                    else if (isPlaying){
                        hero.moving();
                    }
                    hero.update(deltaTime, enemy.getVx());
                    boolean ifTouch = enemy.checkHero(model.getHeroList().get(i));
                    if (hero.isAlive() && ifTouch){
                        hero.touched(enemy);
                        System.out.println("Touched");
                    }
                
                    context.drawImage(new Image(model.getHeroList().get(i).getImgUrl()), model.getHeroList().get(i).getX(), model.getHeroList().get(i).getY());
                }
            




                //coin movement

                int limit = model.getCoinMade() - 10;
                if(limit < 0)
                    limit = 0;
                for(int i = limit; i<model.getCoinMade(); i++){
                    model.getCoinList()[i].update(deltaTime, enemy.getVx());
                    boolean ifTouch = enemy.checkCoin2(model.getCoinList()[i]);
                  /*  if(ifTouch){
                        model.getCoinList()[i].setY(700);
                    }
                    context.drawImage(coinImg,  model.getCoinList()[i].getX(),  model.getCoinList()[i].getY());*/

                    if(!model.getCoinEaten()[i]){
                        if(ifTouch){
                            model.markCoinAsEaten(i);
                            int coinCount = model.eatenCoinCount();
                            view.updatePiece(coinCount);
                            enemy.increaseSpeed();
                        }
                        context.drawImage(coinImg,  model.getCoinList()[i].getX(),  model.getCoinList()[i].getY());

                    }
                }

                //update enemy
                enemy.update(deltaTime);
                context.drawImage(enemyImg, enemy.getX() - enemy.getW() / 2, enemy.getY() - enemy.getH() / 2);

                //update pistolBall
                int limitPistol = model.getPistolNumber() - 10;
                if(limitPistol < 0)
                    limitPistol = 0;

                Image ballImg = new Image("ball.png");
                for(int i = limitPistol; i< model.getPistolNumber(); i++){
                    model.getPistolBallList()[i].update(deltaTime, enemy.getVx() * 10);
                    PistolBall ball = model.getPistolBallList()[i];
                    context.fillOval(ball.getX() , ball.getY(), 10, 10);
                }


                lastTime = now;

                fireTimer = now;

            }
        };
        timer.start();
       /* if(isPlaying) {
            timer.start();
        }
        else{
            timer.stop();
        }*/
    }



    public void startGame(){
        //showBackground();
        coinGeneration();
        heroGenerator();
        gameAnimation();
    }

}
