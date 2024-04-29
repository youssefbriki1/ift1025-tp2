package mvc.entity;


import static java.lang.Math.sqrt;

public class Enemy {

    private String img_url;
    private double x, y;
    private double w, h;

    private double vx, vy;

    private double ax, ay;

    private int life = 100;
    private int pieces;


    public Enemy(double x, double y, double vx, double vy, double ax, double ay, String img_url){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.img_url = img_url;
        this.pieces = 0;
    }

    public void jump(){
        vy = -300;
    }

    //dt means delta t
    public void update(double dt){

        //calculate new velocity

        //vx += dt * ax;

        if(-300 <= vy && vy <= 300)
            vy += dt * ay;

        //new position

        //double newX = x + dt * vx;
        double newY = y + dt * vy;


        /*  if (newX + w / 2 > 640 || newX - w / 2 < 0) {
            vx *= -1;
        } else {
            x = newX;
        }*/

        if (newY + h / 2 > 320 || newY - h / 2 < 0) {
            vy *= -1;

        } else {
            y = newY;
        }
    }

   public void increaseCoin(){
        this.pieces += 1;
   }

   public boolean checkCoin2(Coin coin){
        double x1 = x + w/2;
        double y1 = y + h/2;
        double r1 = 0.5 * sqrt(w*w + h * h);

        double coin_w = coin.getW();
        double coin_h = coin.getH();

        double x2 = coin.getX() + coin_w/2;
        double y2 = coin.getY() + coin_h/2;
        double r2 = 0.5 * sqrt(coin_w * coin_w + coin_h * coin_h);

        double dist = sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        if(dist <= r1 + r2){
            if(!coin.isEaten())
                this.pieces += 1;
            return true;
        }
        return false;
    }

   public boolean checkCoin(Coin coin){
        boolean fl = true;
        if(
               ( (this.x + this.w) < coin.getX() ) ||
               ( (coin.getX() + coin.getW()) < this.x) ||
               ( this.y > (coin.getY() + coin.getH()) ) ||
               ( (this.y + this.h) < coin.getY() )
        ){
            fl = false;
        }
        else {
            this.pieces += 1;
        }

        return fl;
   }

   public boolean checkHero(Hero hero){
    if(
           ( (this.x + this.w) < hero.getX() ) ||
           ( (hero.getX() + hero.getW()) < this.x) ||
           ( this.y > (hero.getY() + hero.getH()) ) ||
           ( (this.y + this.h) < hero.getY() )
    ){
        return false;
    }
    else {
        return true;
    }

}


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void increaseSpeed(){
        this.ay += 15;
        this.vx += 10;
    }
}
