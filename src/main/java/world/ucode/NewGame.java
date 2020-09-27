package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    static Pane root = new Pane();
    private static Stage primaryStage;
    static Dino drex;
    static Score score;
    NewGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void makeGame () {
//        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
//        scene.creatScene(primaryStage, root, "Beta-Rex )))", "game");
        drex = new Dino(25, 385);
        score = new Score();
        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
        scene.creatScene(primaryStage, root, drex, "Beta-Rex )))", "game");
        root.getChildren().add(drex);
        root.getChildren().add(score);
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
    static void gameOver() {
        Image IMAGE = new Image("replay.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(150);
        imageView.setFitHeight(69);
        Button button = new Button("", imageView);
        button.setTranslateX(500);
        button.setTranslateY(40);
        Image IMAGE2 = new Image("menu.png");
        ImageView imageView2 = new ImageView(IMAGE2);
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(69);
        Button button2 = new Button("", imageView2);
        button2.setTranslateX(500);
        button2.setTranslateY(200);
//        root.getChildren().addAll(Main.deqCloud);
        root.getChildren().add(button);
        root.getChildren().add(button2);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                primaryStage.close();
//                Stage primaryStage2 = new Stage();
                root.getChildren().removeAll(button, button2, drex, score);
                root.getChildren().removeAll(Main.deqCloud);
                root.getChildren().removeAll(Main.deqCactus);
                root.getChildren().removeAll(Main.arrGroundGame);
                NewGame newGame = new NewGame(primaryStage);
                newGame.makeGame();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(button, button2, drex, score);
                root.getChildren().removeAll(Main.deqCloud);
                root.getChildren().removeAll(Main.deqCactus);
                root.getChildren().removeAll(Main.arrGroundGame);
                Menu menu = new Menu();
                menu.makeMenu(primaryStage);
            }
        });
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