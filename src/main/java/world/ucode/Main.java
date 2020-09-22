package world.ucode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<Ground> arrGround = new ArrayList<Ground>();
    private static final Image IMAGE = new Image("d-rex.jpeg");
    @Override
    public void start(Stage primaryStage) {
        try {
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
