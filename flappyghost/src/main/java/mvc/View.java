package mvc;

import javafx.animation.AnimationTimer;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View extends BorderPane {

    private int w, h;

    private Pane root = new Pane();
    private Canvas canvas ;
    private GraphicsContext context;
    private HBox hbox = new HBox(0);
    private Button resume = new Button("Resume");
    private Separator sep1 = new Separator();
    private Text life = new Text("Life: 100");
    private Separator sep2 = new Separator();
    private Text piece = new Text("Piece: 0");

    public View(int w, int h){


        this.w = w;
        this.h = h;

        canvas = new Canvas(w, h);
        context = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        this.setCenter(root);

        sep1.setOrientation(Orientation.VERTICAL);
        sep2.setOrientation(Orientation.VERTICAL);

        //hbox.getChildren().add(resume);
        hbox.getChildren().add(sep1);
        hbox.getChildren().add(life);
        hbox.getChildren().add(sep2);
        hbox.getChildren().add(piece);

        hbox.setAlignment( Pos.CENTER );

        this.setBottom(hbox);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public GraphicsContext getContext(){
        return this.context;
    }

    public void updatePiece(int pieces){
        String text = "Piece: " + pieces;
        this.piece.setText(text);
    }



}
