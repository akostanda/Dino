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

import java.util.ArrayList;

public class NewScene {
//    private int x = 0;
    private int x;
    private int width;
    private int height;
    private ArrayList<Ground> arrGround = new ArrayList<Ground>();
    private int screenGroundEnd = -50;
    static int screenCloudCactusEnd = -210;

//    int acceleration = 0;
    private float gravity = 1;
    private float vector = 0;

    Scene scene;
    AnimationTimer timer;

    NewScene(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;
    }
//    Pane root = new Pane();
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
//        drex.setTranslateY(drex.getTranslateY() - Dino.vector);
//        Dino.vector -= Dino.gravity;
//        if (drex.getTranslateY() >= 385) {
//            Dino.vector = 0;
//            drex.setTranslateY(385);
//        }
        if (trigger.equals("menu")) {
            arrGround = Main.arrGroundMenu;
//            Cactus.translateCactus(acceleration);
//            Cloud.translateCloud(acceleration);
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
    System.out.println("Accel" + Main.acceleration); //
                Score.counter += 1;
//
    System.out.println("Score.counter:" + Score.counter); //
            }
            for (var it : Main.deqCactus) {
                double xx = Math.pow(((it.getTranslateX() + it.cactusWidth / 2) - (drex.getTranslateX() + 22)), 2);
                double yy = Math.pow(((it.getTranslateY() + 37) - (drex.getTranslateY() + 71)), 2);
                double objectsDistance = Math.sqrt(xx + yy);
                if ((it.getTranslateX() - (drex.getTranslateX() + 88) <= 0)
                        && (it.getTranslateY() - (drex.getTranslateY() + 71) <= 0)) {
                    timer.stop();
                    Dino.animation.stop();
                    Score.timer.stop();
                }
            }

            arrGround = Main.arrGroundGame;
            Cactus.translateCactus(Main.acceleration);
            Cloud.translateCloud(Main.acceleration);
        }

        for (int i = 0; i < arrGround.size(); i++) {

//      System.out.println("acceleration:" + Main.acceleration);
//      System.out.println("Score.counter:" + Score.counter);

//            if (i % 30 == 0)
//                acceleration++;
//            if (acceleration == 15)
//                acceleration = 0;
            arrGround.get(i).moveLeft(Main.acceleration);
            if (arrGround.get(i).getTranslateX() < screenGroundEnd) {
                arrGround.get(i).setTranslateX(Main.xGround - x);
//                Main.arrGround.add(Main.arrGround.get(i));
//                Main.arrGround.remove(Main.arrGround.get(i));
            }
        }
    }
}
