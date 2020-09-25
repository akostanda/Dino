package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
//        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
//        scene.creatScene(primaryStage, root, "Beta-Rex )))", "game");
        Dino drex = new Dino(primaryStage, 25, 385);
        Score score = new Score(root);
        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
        scene.creatScene(primaryStage, root, drex, "Beta-Rex )))", "game");
        root.getChildren().add(drex);
//        root.getChildren().add(score);
        root.getChildren().addAll(Main.arrGroundGame);
        root.getChildren().addAll(Main.deqCactus);
        root.getChildren().addAll(Main.deqCloud);
//        score.time();
//        score.toFront();
        drex.toFront();
        drex.makeDino();
//        if (Score.counter % 100 == 0) {
//            Main.acceleration++;
//        }
//        if (Score.counter % 1000 == 0) {
//            Main.acceleration = 0;
//        }
        scene.scene.setOnKeyPressed(
                event -> {
                    KeyCode keyCode = event.getCode();

                    if (keyCode.equals(keyCode.SPACE)) {
                        if (drex.getTranslateY() >= 385)
                            Dino.vector = 22;
                    }
                });
//        scene.scene.setOnKeyPressed(
//                event -> {
//                    KeyCode keyCode = event.getCode();
//
//                    if (keyCode.equals(keyCode.SPACE)) drex.setTranslateY(drex.getTranslateY() - 10);
//                });
//        if (score.counter % 100 == 0) {
//            Main.speed++;
//        }
//        if (score.counter % 1000 == 0) {
//            Main.speed = 3;
//        }
//        if (drex.getTranslateX() < 385) {
//            drex
//        }

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