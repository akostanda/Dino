package world.ucode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Ground extends Pane {

    Ground (int x, int y, String trigger) {
        Image IMAGE;
        double number = Math.random();
        if (number < 0.12)
            IMAGE = new Image("land1.png");
        else if (number > 0.88)
            IMAGE = new Image("land3.png");
        else
            IMAGE = new Image("land2.png");
        ImageView imageView = new ImageView(IMAGE);
        this.setTranslateX(x);
        this.setTranslateY(y);
        getChildren().add(imageView);
        if (trigger.equals("menu"))
            Main.arrGroundMenu.add(this);
        else if (trigger.equals("game"))
            Main.arrGroundGame.add(this);
    }

    void moveLeft(float acceleration) {

        setTranslateX(getTranslateX() - (Main.speed + acceleration));
    }

}
