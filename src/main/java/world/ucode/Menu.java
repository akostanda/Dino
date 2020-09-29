package world.ucode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    Pane root = Main.root;

    public void makeMenu(Stage primaryStage) {
        NewScene scene = new NewScene(Main.groundLanth, 600, 400);
        Image IMAGE = new Image("dinoMenu.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(78);
        imageView.setFitHeight(69);
        Button button = new Button("New game", imageView);
        button.setTranslateX(220);
        button.setTranslateY(120);
        Dino drex = new Dino(25, 285);
        scene.creatScene(primaryStage, root, drex, "Beta-Rex )))", "menu");
        root.getChildren().addAll(drex);
        root.getChildren().add(button);
        drex.makeDino();
        drex.toFront();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewGame newGame = new NewGame(primaryStage);
                newGame.makeGame();
            }
        });
        primaryStage.show();
    }
}
