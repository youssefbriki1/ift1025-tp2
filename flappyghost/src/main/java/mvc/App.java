package mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import mvc.entity.Enemy;
import mvc.entity.GameBackground;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        launch(args);
    }

    @Override
    public void start(Stage stage){
        View view = new View(640, 400);

        Enemy enemy = new Enemy(100, 100, 120, 0, 0, 500, "cheems.png");
        GameBackground background = new GameBackground(0, 120, "bg.png");
        Model model = new Model(enemy, background);

        Controller controller = new Controller(model, view);

        Scene scene = new Scene(view, 640, 440);

        stage.setScene(scene);
        stage.setTitle("Flappy Ghost");
        stage.show();

        scene.setOnKeyPressed( ( event ) -> {
            if( event.getCode() == KeyCode.SPACE) {
                System.out.println( "Space" );
                enemy.jump();
            }
            if( event.getCode() == KeyCode.E) {
                System.out.println( "E" );
                controller.fireBall();
            }
        });

        controller.startGame();

    }
}
