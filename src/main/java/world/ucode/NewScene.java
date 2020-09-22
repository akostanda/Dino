package world.ucode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;

public class NewScene extends Application {
    private int x = 0;
    Pane root = new Pane();
    @Override
    public void start(Stage primaryStage) {
        creatScene(primaryStage, root);
        Dino drex = new Dino(primaryStage, 25, 260);
        root.getChildren().add(drex);
        for (int i = 0; i < 150; i++) {
            Ground ground = new Ground(x, 330);
            x += 71;
            root.getChildren().add(ground);
//        ground.move();
        }
        drex.toFront();
        drex.makeDino();
//        ground.makeGround();
    }
    private void creatScene(Stage primaryStage, Pane root) {
        primaryStage.setTitle("Beta-Rex )))");
//        root.setStyle("-fx-background-color: #ffffff;");
        primaryStage.setScene(new Scene(root, 1000, 400));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }
    private void update() {
        for (int i = 0; i < Main.arrGround.size(); i++) {
            Main.arrGround.get(i).moveLeft();
            if (Main.arrGround.get(i).getTranslateX() < - 50) {
                Main.arrGround.get(i).setTranslateX(x - 71);
            }
        }
    }
}
