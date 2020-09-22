package world.ucode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    private static final Image IMAGE = new Image("d-rex.jpeg");
    public void makeMenu(Stage primaryStage) {
        primaryStage.setTitle("Beta-Rex )))");
        Button button = new Button();
        button.setText("New game");

        Pane root = new Pane();
//        root.setStyle("-fx-background-color: White;");
        Dino drex = new Dino(primaryStage, 25, 200);
        drex.makeDino();
        root.getChildren().addAll(drex);
        button.setTranslateX(160);
        button.setTranslateY(120);
        root.getChildren().add(button);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 400, 300));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewScene newGame = new NewScene();
                newGame.start(primaryStage);
            }
        });
        primaryStage.show();
    }
}
