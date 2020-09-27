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
                double xx = Math.pow(((it.getTranslateX() + it.cactusWidth / 2) - (drex.getTranslateX() + Dino.WIDTH / 2)), 2);
                double yy = Math.pow(((it.getTranslateY() + it.cactusHeight / 2) - (drex.getTranslateY() + Dino.HEIGHT / 2)), 2);
                double objectsDistance = Math.sqrt(xx + yy);
//                System.out.println("xx: " + xx);
//                System.out.println("yy: " + yy);

//        System.out.println("it.getTranslateX(): " + it.getTranslateX());
//        System.out.println("it.getTranslateY(): " + it.getTranslateY());


//                if (objectsDistance < it.minXtoDino && objectsDistance < (it.minYtoDino)) {
                if ((it.getTranslateX() >= drex.getTranslateX()
                    && it.getTranslateX() - (drex.getTranslateX() + Dino.WIDTH) <= -10
                    && it.getTranslateY() - (drex.getTranslateY() + 95) <= -20)) {
                    System.out.println(1);
//                    System.out.println("drex.getTranslateX(): " + drex.getTranslateX());
//                    System.out.println("drex.getTranslateY(): " + (drex.getTranslateY()));
//                    System.out.println("cactus.getTranslateX(): " + it.getTranslateX());
//                    System.out.println("cactus.getTranslateY(): " + (it.getTranslateY()));
//                    System.out.println("it.minXtoDino: " + it.minXtoDino);
//                    System.out.println("it.minYtoDino: " + (it.minYtoDino));
//                    System.out.println("objectsDistance: " + objectsDistance);
                    timer.stop();
                    Dino.animation.stop();
                    Score.timer.stop();
                    NewGame.gameOver();

                }
                else if ((it.getTranslateX() + it.cactusWidth / 2 >= drex.getTranslateX()
                        && (it.getTranslateX() + it.cactusWidth / 2) - (drex.getTranslateX() + Dino.WIDTH / 2) <= -5
                        && it.getTranslateY() - (drex.getTranslateY() + 95) <= -15)) {
                    System.out.println(2);
                    timer.stop();
                    Dino.animation.stop();
                    Score.timer.stop();
                }
                else if ((it.getTranslateX() + it.cactusWidth / 2 < drex.getTranslateX()
                        && (drex.getTranslateX() + Dino.WIDTH / 2) - (it.getTranslateX() + it.cactusWidth / 2) < -5
                        && it.getTranslateY() - (drex.getTranslateY() + 95) <= -15)) {
                    System.out.println(3);
                    timer.stop();
                    Dino.animation.stop();
                    Score.timer.stop();
                }
                else if ((it.getTranslateX() < drex.getTranslateX()
                        && drex.getTranslateX() - (it.getTranslateX() + it.cactusWidth) < -10
                        && it.getTranslateY() - (drex.getTranslateY() + 95) <= -35)) {
                    System.out.println(4);
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
