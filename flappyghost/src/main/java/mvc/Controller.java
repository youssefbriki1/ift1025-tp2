package mvc;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import mvc.entity.Coin;
import mvc.entity.Enemy;
import mvc.entity.GameBackground;
import mvc.entity.PistolBall;

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
    }



    public void coinGeneration(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Random rand = new Random();
                int y_pos = rand.nextInt(370);
                Image coinImg = new Image("coin.png");
                double w = coinImg.getWidth();
                double h = coinImg.getHeight();
                Coin coin = new Coin(640, y_pos, w, h);

                model.addNewCoin(coin);

//                System.out.println("I would be called every 2 seconds");
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



                //coin movement

                int limit = model.getCoinMade() - 10;
                if(limit < 0)
                    limit = 0;
                for(int i = limit; i<model.getCoinMade(); i++){
                    model.getCoinList()[i].update(deltaTime, enemy.getVx());
                    boolean ifTouch = enemy.checkCoin(model.getCoinList()[i]);
                    if(!model.getCoinEaten()[i]){
                        if(ifTouch){
                            model.markCoinAsEaten(i);
                            int coinCount = model.eatenCoinCount();
                            view.updatePiece(coinCount);
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
    }



    public void startGame(){
        //showBackground();
        coinGeneration();
        gameAnimation();
    }

}
