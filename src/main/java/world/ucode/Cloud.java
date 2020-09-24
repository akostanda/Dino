package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Cloud extends Pane {
    private Image IMAGE;
    Cloud (int x, int y) {
        double number = Math.random();
        if (number <= 0.34)
            IMAGE = new Image("cloud1.png");
        else if (number > 0.34 && number < 0.68)
            IMAGE = new Image("cloud2.png");
        else
            IMAGE = new Image("cloud3.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(IMAGE.getWidth() * 1.5);
        imageView.setFitHeight(IMAGE.getHeight() * 1.5);
        this.setTranslateX(x);
        this.setTranslateY(y);
        getChildren().add(imageView);
        Main.deqCloud.add(this);
    }
    void moveLeft(int acceleration) {
        setTranslateX(getTranslateX() - (Main.speed + acceleration));
    }
    static void translateCloud(int acceleration) {
        if (Main.deqCloud.getFirst().getTranslateX() < NewScene.screenCloudCactusEnd) {
            double x2 = Main.xCloudRandomBegin + Math.random() * Main.xCloudRandomEnd;
            double y2 = Main.yCloud + Math.random() * Main.yCloudRandomEnd;
            Main.deqCloud.getFirst().setTranslateX(Main.deqCloud.getLast().getTranslateX() + x2);
            Main.deqCloud.getFirst().setTranslateY(Main.yCloud + y2);
            Main.deqCloud.addLast(Main.deqCloud.getFirst());
            Main.deqCloud.removeFirst();
        }
        for (var it : Main.deqCloud) {
//            if (i % 30 == 0)
//                acceleration++;
//            if (acceleration == 15)
//                acceleration = 0;
            it.moveLeft(acceleration);
        }
    }
}
