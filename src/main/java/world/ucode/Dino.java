package world.ucode;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Dino extends Pane {
    final Image IMAGE = new Image("trex.png");
    static ImageView imageView;
    static final int COLUMNS  =  1;
    static final int COUNT    =  4;
    static final int OFFSET_X =  0;
    static final int OFFSET_Y =  0;
    static final int WIDTH    = 88;
    static final int HEIGHT   = 142;
    private static double x;
    static double y;
    static float vector = 0;
    static float gravity = 1;
    static Animation animation;

    Dino (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void makeDino() {
        imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        animation = new GameAnimation(
                imageView,
                Duration.millis(500),
                COUNT, COLUMNS,
                OFFSET_X, WIDTH,
                HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().add(imageView);
        setTranslateX(x);
        setTranslateY(y);
    }
}
