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
import java.util.ArrayList;

public class Ground extends Pane {

//    private static final Image IMAGE = new Image("land2.png");
//    private static ArrayList<ImageView> arrGround = new ArrayList<ImageView>();
//    private static final int COLUMNS  =   1;
//    private static final int COUNT    =  1;
//    private static final int OFFSET_X =  1;
//    private static final int OFFSET_Y =  0;
//    private int x;
    private final int y = 330;
////    private static final int WIDTH    = 0;
////    private static final int HEIGHT   = 0;
    private static Stage primaryStage;

    Ground (int x) {
//        this.primaryStage = primaryStage;
//        this.x = x;
        Image IMAGE;
        double number = Math.random();
        if (number < 0.12)
            IMAGE = new Image("land1.png");
        else if (number > 0.88)
            IMAGE = new Image("land3.png");
        else
            IMAGE = new Image("land2.png");
        ImageView imageView = new ImageView(IMAGE);
//        imageView.setLayoutX(x);
//        imageView.setLayoutY(y);
        setTranslateX(x);
        setTranslateY(y);
        getChildren().add(imageView);
        Main.arrGround.add(this);
//        arrGround = setArrGround();
    }
    void moveLeft() {

        setTranslateX(getTranslateX() - 9);
    }
//    private ArrayList<ImageView> setArrGround() {
//        for (int i = 0; i < 20; i++) {
//            Image IMAGE;
//            double number = Math.random();
//            if (number == 0.5)
//                IMAGE = new Image("land1.png");
//            else if (number ==  0.7)
//                IMAGE = new Image("land3.png");
//            else
//                IMAGE = new Image("land2.png");
//            ImageView imageView = new ImageView(IMAGE);
//            Main.arrGround.add(imageView);
//        }
//        return arrGround;
//    }
//    public static ArrayList<ImageView> getArrGround() {
//        return arrGround;
//    }
//    public void move() {
//        int groundWidth = 10;
//        int screenWidth = 1000;
//        System.out.print("arrGround.size = ");
//    System.out.println(arrGround.size());
//        for (int i = arrGround.size(); i >= 0; i--) {
////            this.setTranslateX(this.getTranslateX() - 1);
//            screenWidth -= groundWidth;
//            getChildren().add(arrGround.get(i));
//            arrGround.get(i).setLayoutX(screenWidth);
//            arrGround.get(i).setLayoutY(370);
//            if (i == 0)
//                i = arrGround.size();
//        }
//    }
//    public void move() {
//        for (int i = arrGround.size(); i >= 0; i--) {
//            this.setTranslateX(this.getTranslateX() - 1);
//            i == 0 ? i = arrGround.size();
//        }
//    }
    //    imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

//        final Animation animation = new GameAnimation(
//                imageView,
//                Duration.millis(450),
//                COUNT, COLUMNS,
//                OFFSET_X, OFFSET_Y,
//                WIDTH, HEIGHT
//        );
//        animation.setCycleCount(Animation.INDEFINITE);
//        animation.play();
//
//        primaryStage.setScene(new Scene(new Group(imageView), 1000, 400));
//    imageView.setLayoutX(950);
//    imageView.setLayoutY(370);

}
