package world.ucode;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class NewGame {
    static Pane root = new Pane();
    private static Stage primaryStage;
    static Dino drex;
    static Score score;

    NewGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static void makeGame () {
        drex = new Dino(25, 385);
        score = new Score();
        NewScene scene = new NewScene(Main.groundLanth, 1200, 500);
        scene.creatScene(primaryStage, root, drex, "Beta-Rex )))", "game");
        root.getChildren().add(drex);
        root.getChildren().add(score);
        root.getChildren().addAll(Main.arrGroundGame);
        root.getChildren().addAll(Main.deqCactus);
        root.getChildren().addAll(Main.deqCloud);
        drex.toFront();
        drex.makeDino();
        scene.scene.setOnKeyPressed(
                event -> {
                    KeyCode keyCode = event.getCode();
                    if (keyCode.equals(keyCode.SPACE)) {
                        if (drex.getTranslateY() >= 385)
                            Dino.vector = 22;
                    }
                });
    }

    static void gameOver(AnimationTimer timer, Cactus cactus) {
        Image IMAGE = new Image("replay_button.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(150);
        imageView.setFitHeight(69);
        Button button = new Button("", imageView);
        button.setTranslateX(500);
        button.setTranslateY(60);
        Image IMAGE2 = new Image("dinoMenuExit.png");
        ImageView imageView2 = new ImageView(IMAGE2);
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(69);
        Button button2 = new Button("", imageView2);
        button2.setTranslateX(500);
        button2.setTranslateY(200);
        root.getChildren().add(button);
        root.getChildren().add(button2);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().removeAll(button, button2);
                cactus.setTranslateX(cactus.getTranslateX() - 200);
                Score.counter = 0;
                Main.speed = 5;
                Main.acceleration = 0;
                timer.start();
                Dino.animation.play();
                Score.timer.play();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}