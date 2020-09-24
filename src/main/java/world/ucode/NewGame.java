package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.StackPane;
        import javafx.stage.Stage;
        import javafx.scene.layout.Pane;
        import javafx.animation.AnimationTimer;

public class NewGame {
    private int x = 0;
    Pane root = new Pane();
    public void makeGame (Stage primaryStage) {
        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
        scene.creatScene(primaryStage, root, "Beta-Rex )))", "game");
        Dino drex = new Dino(primaryStage, 25, 385);
        root.getChildren().add(drex);
        root.getChildren().addAll(Main.arrGroundGame);
        root.getChildren().addAll(Main.deqCactus);
        root.getChildren().addAll(Main.deqCloud);
        drex.toFront();
        drex.makeDino();
        if (drex.getTranslateX() < 385) {
            drex
        }
    }

//    private void creatScene(Stage primaryStage, Pane root) {
//        primaryStage.setTitle("Beta-Rex )))");
////        root.setStyle("-fx-background-color: #ffffff;");
//        primaryStage.setScene(new Scene(root, 1000, 400));
//        primaryStage.setResizable(false);
//        primaryStage.centerOnScreen();
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                update();
//            }
//        };
//        timer.start();
//    }
//    private void update() {
//        for (int i = 0; i < Main.arrGround.size(); i++) {
//            Main.arrGround.get(i).moveLeft();
//            if (Main.arrGround.get(i).getTranslateX() < - 50) {
//                Main.arrGround.get(i).setTranslateX(x - 71);
//            }
//        }
//    }
}