package mvc;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class View extends BorderPane {

    private int w, h;

    private Pane root = new Pane();
    private Canvas canvas ;
    private GraphicsContext context;
    private HBox hbox = new HBox(40);
    private Separator sep1 = new Separator();
    private Text life = new Text("Life: 100"); 
    private Separator sep2 = new Separator();
    private Text piece = new Text("Piece: 0");

    private Text gameOver = new Text("Game Over");

    private Button gameButton = new Button("Pause");

    /**
     * Constructs a View object with the specified width and height.
     *
     * @param w The width of the view.
     * @param h The height of the view.
     */
    public View(int w, int h){
        this.w = w;
        this.h = h;

        canvas = new Canvas(w, h);
        context = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        this.setCenter(root);

        sep1.setOrientation(Orientation.VERTICAL);
        sep2.setOrientation(Orientation.VERTICAL);

        gameButton.setFocusTraversable(false);

        hbox.getChildren().add(gameButton);
        hbox.getChildren().add(sep1);
        hbox.getChildren().add(life);
        hbox.getChildren().add(sep2);
        hbox.getChildren().add(piece);

        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(5, 40, 5, 40));

        this.setBottom(hbox);
    }

    /**
     * Gets the width of the view.
     *
     * @return The width of the view.
     */
    public int getW() {
        return w;
    }

    /**
     * Sets the width of the view.
     *
     * @param w The width of the view.
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * Gets the height of the view.
     *
     * @return The height of the view.
     */
    public int getH() {
        return h;
    }

    /**
     * Sets the height of the view.
     *
     * @param h The height of the view.
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Gets the graphics context of the canvas.
     *
     * @return The graphics context of the canvas.
     */
    public GraphicsContext getContext(){
        return this.context;
    }

    /**
     * Gets the root pane of the view.
     *
     * @return The root pane of the view.
     */
    public Pane getRoot(){
        return this.root;
    }

    /**
     * Updates the displayed piece count.
     *
     * @param pieces The new piece count.
     */
    public void updatePiece(int pieces){
        String text;
        if (pieces > 1000){
            text = "Merci Robin!";
        }
        else{
            text = "Piece: " + pieces;
        }
        this.piece.setText(text);
    }

    /**
     * Updates the displayed life count.
     *
     * @param life The new life count.
     */
    public void updateLife(int life){
        String text = "Life: " + life;
        this.life.setText(text);
    }

    /**
     * Gets the game button.
     *
     * @return The game button.
     */
    public Button getGameButton() {
        return gameButton;
    }

    /**
     * Sets the game over state and displays the game over image.
     */
    public void setGameOver(){
        Image gameOver = new Image("gameover.png");
        context.drawImage(gameOver, 230, 100);
       //context.fillText("Game Over", 300, 200);
    }
}
