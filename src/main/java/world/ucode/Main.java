package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main extends Application {
    static int xGround = 0;
    static int groundLanth = 66;
    static int xCactus = 1210;
    static int xCloud = 1210;
    static int yCactus = 400;
    static int xCactusRandomBegin = 420;
    static int xCactusRandomEnd = 800;
    static int yCloud = 30;
    static int xCloudRandomBegin = 150;
    static int xCloudRandomEnd = 1000;
    static int yCloudRandomEnd = 200;
    static Pane root = new Pane();
    static float speed = 5;
    static float acceleration = 0;
    static ArrayList<Ground> arrGroundMenu = new ArrayList<Ground>();
    static ArrayList<Ground> arrGroundGame = new ArrayList<Ground>();
    static Deque<Cactus> deqCactus = new LinkedList<Cactus>();
    static Deque<Cloud> deqCloud = new LinkedList<Cloud>();

    @Override
    public void start(Stage primaryStage) {
        try {
            for (int i = 0; i < 1000; i++) {
                new Ground(xGround, 350, "menu");
                new Ground(xGround, 450, "game");
                xGround += groundLanth;
                double number1 = xCactusRandomBegin + Math.random() * xCactusRandomEnd;
                new Cactus(xCactus, yCactus);
                double number2 = xCloudRandomBegin + Math.random() * xCloudRandomEnd;
                double y = yCloud + Math.random() * yCloudRandomEnd;
                new Cloud(xCloud, (int)y);
                xCactus += number1;
                xCloud += number2;
            }
            root.getChildren().addAll(arrGroundMenu);
            Menu menu = new Menu();
            menu.makeMenu(primaryStage);
            primaryStage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
