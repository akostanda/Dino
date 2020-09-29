package world.ucode;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class NewScene {
    private int x;
    private int width;
    private int height;
    private ArrayList<Ground> arrGround = new ArrayList<Ground>();
    private int screenGroundEnd = -71;
    static int screenCloudCactusEnd = -210;
    Scene scene;
    AnimationTimer timer;

    NewScene(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;
    }

    protected void creatScene(Stage primaryStage, Pane root, Dino drex, String title, String trigger) {
        primaryStage.setTitle(title);
        root.setStyle("-fx-background-color: #f7f7f7;");
        scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(trigger, drex);
            }
        };
        timer.start();
    }

    private void update(String trigger, Dino drex) {
        if (trigger.equals("menu")) {
            arrGround = Main.arrGroundMenu;
        }
        else if (trigger.equals("game")) {
            drex.setTranslateY(drex.getTranslateY() - Dino.vector);
            Dino.vector -= Dino.gravity;
            if (drex.getTranslateY() >= 385) {
                Dino.vector = 0;
                drex.setTranslateY(385);
            }
            if (Score.counter % 1000 == 0) {
                Main.acceleration = 0;
                Score.counter += 1;
            }
            if (Score.counter % 100 == 0) {
                Main.acceleration += 1;
                Score.counter += 1;
            }
            for (var it : Main.deqCactus) {
                if ((it.getTranslateX() >= drex.getTranslateX()
                    && it.getTranslateX() - (drex.getTranslateX() + Dino.WIDTH) <= -15
                    && it.getTranslateY() - (drex.getTranslateY() + 95) <= -20)) {
                    gameStop(it);
                }
                else if ((it.getTranslateX() + it.cactusWidth / 2 >= drex.getTranslateX()
                        && (it.getTranslateX() + it.cactusWidth / 2) - (drex.getTranslateX() + Dino.WIDTH / 2) <= -7
                        && it.getTranslateY() - (drex.getTranslateY() + 95) <= -14)) {
                    gameStop(it);
                }
                else if ((it.getTranslateX() < drex.getTranslateX()
                        && drex.getTranslateX() - (it.getTranslateX() + it.cactusWidth) < -18
                        && it.getTranslateY() - (drex.getTranslateY() + 95) <= -35)) {
                    gameStop(it);
                }
            }
            arrGround = Main.arrGroundGame;
            Cactus.translateCactus(Main.acceleration);
            Cloud.translateCloud(Main.acceleration);
        }
        for (int i = 0; i < arrGround.size(); i++) {
            arrGround.get(i).moveLeft(Main.acceleration);
            if (arrGround.get(i).getTranslateX() < screenGroundEnd) {
                arrGround.get(i).setTranslateX(Main.xGround - x);
            }
        }
    }

    private void gameStop(Cactus cactus) {
        timer.stop();
        Dino.animation.stop();
        Score.timer.stop();
        NewGame.gameOver(timer, cactus);
    }
}
