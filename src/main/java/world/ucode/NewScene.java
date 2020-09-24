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
    static int screenCloudCactusEnd = -150;
    private float gravity = 1;
    private float vector = 0;

    NewScene(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;
    }
//    Pane root = new Pane();
    protected void creatScene(Stage primaryStage, Pane root, String title, String trigger) {
        primaryStage.setTitle(title);
//        root.setStyle("-fx-background-color: #ffffff;");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(trigger);
            }
        };
        timer.start();
    }
    private void update(String trigger) {
        int acceleration = 0;
        if (trigger.equals("menu")) {
            arrGround = Main.arrGroundMenu;
//            Cactus.translateCactus(acceleration);
//            Cloud.translateCloud(acceleration);
        }
        else if (trigger.equals("game")) {
            arrGround = Main.arrGroundGame;
            Cactus.translateCactus(acceleration);
            Cloud.translateCloud(acceleration);
        }
        for (int i = 0; i < arrGround.size(); i++) {
//            if (i % 30 == 0)
//                acceleration++;
//            if (acceleration == 15)
//                acceleration = 0;
            arrGround.get(i).moveLeft(acceleration);
            if (arrGround.get(i).getTranslateX() < screenGroundEnd) {
                arrGround.get(i).setTranslateX(Main.xGround - x);
//                Main.arrGround.add(Main.arrGround.get(i));
//                Main.arrGround.remove(Main.arrGround.get(i));
            }
        }

    }
}
