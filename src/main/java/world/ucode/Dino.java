package world.ucode;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;

public class Dino extends Pane {
//    InputStream iconStream = getClass().getResourceAsStream("d-rex.png");
    private final Image IMAGE = new Image("trex.png");

    private static final int COLUMNS  =  1;
    private static final int COUNT    =  4;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    static final int WIDTH    = 88;
    static final int HEIGHT   = 142;
    private static int x;
    static int y;
    static float vector = 0;
    static float gravity = 1;
    boolean toDown = false;
    static Animation animation;
    Dino (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void makeDino() {
        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        animation = new GameAnimation(
                imageView,
                Duration.millis(500),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().add(imageView);
//        Ground ground = new Ground(primaryStage);
//        primaryStage.setScene(new Scene(new Group(imageView), 1000, 400));
        setTranslateX(x);
        setTranslateY(y);
    }

//    static void setY(int newY) {
//        setTranslateY(newY);
//    }
}
