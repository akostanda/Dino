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
    Pane root = Main.root;
    public void makeMenu(Stage primaryStage) {
        NewScene scene = new NewScene(Main.groundLanth, 600, 400);
        scene.creatScene(primaryStage, root, "Beta-Rex )))", "menu");
        Button button = new Button();
        button.setText("New game");
        button.setTranslateX(240);
        button.setTranslateY(110);

        Dino drex = new Dino(primaryStage, 25, 285);
        root.getChildren().addAll(drex);
//        root.getChildren().addAll(Main.deqCloud);
        root.getChildren().add(button);
//        for (int i = 0; i < 150; i++) {
//            Ground ground = new Ground(x, 370);
//            x += 71;
//            root.getChildren().add(ground);
////        ground.move();
//        }
        drex.makeDino();
        drex.toFront();
//        primaryStage.setResizable(false);
//        primaryStage.centerOnScreen();
//        primaryStage.setScene(new Scene(root, 400, 300));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewGame newGame = new NewGame();
                newGame.makeGame(primaryStage);
            }
        });
        primaryStage.show();
    }
}
