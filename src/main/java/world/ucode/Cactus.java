package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Cactus extends Pane {
    private Image IMAGE;
    Cactus (int x, int y) {
        double number = Math.random();
        if (number <= 0.34)
            IMAGE = new Image("cactus1.png");
        else if (number > 0.34 && number < 0.68)
            IMAGE = new Image("cactus3.png");
        else
            IMAGE = new Image("cactus4.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(IMAGE.getWidth() * 2);
        imageView.setFitHeight(IMAGE.getHeight() * 1.5);
        this.setTranslateX(x);
        this.setTranslateY(y);
        getChildren().add(imageView);
        Main.deqCactus.add(this);
    }
    void moveLeft(float acceleration) {

        setTranslateX(getTranslateX() - (Main.speed + acceleration));
    }
    static void translateCactus(float acceleration) {
//    System.out.println(acceleration);
        if (Main.deqCactus.getFirst().getTranslateX() < NewScene.screenCloudCactusEnd) {
            double x2 = Main.xCactusRandomBegin + Math.random() * Main.xCactusRandomEnd;
            Main.deqCactus.getFirst().setTranslateX(Main.deqCactus.getLast().getTranslateX() + x2);
            Main.deqCactus.addLast(Main.deqCactus.getFirst());
            Main.deqCactus.removeFirst();
        }
        for (var it : Main.deqCactus) {
//            if (i % 30 == 0)
//                acceleration++;
//            if (acceleration == 15)
//                acceleration = 0;
            it.moveLeft(acceleration);
        }
    }
}