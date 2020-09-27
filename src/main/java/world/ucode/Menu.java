package world.ucode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    private static final Image IMAGE = new Image("d-rex.jpeg");
    Pane root = Main.root;
    public void makeMenu(Stage primaryStage) {
        NewScene scene = new NewScene(Main.groundLanth, 600, 400);
        Image IMAGE = new Image("dinoMenu.png");
        ImageView imageView = new ImageView(IMAGE);
        imageView.setFitWidth(78);
        imageView.setFitHeight(69);
        Button button = new Button("New game", imageView);
//        button.setText("New game");
        button.setTranslateX(220);
        button.setTranslateY(40);
        Image IMAGE2 = new Image("dinoMenuExit.png");
        ImageView imageView2 = new ImageView(IMAGE2);
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(69);
        Button button2 = new Button("", imageView2);
//        button.setText("New game");
        button2.setTranslateX(220);
        button2.setTranslateY(200);

        Dino drex = new Dino(25, 285);
        scene.creatScene(primaryStage, root, drex, "Beta-Rex )))", "menu");
        root.getChildren().addAll(drex);
//        root.getChildren().addAll(Main.deqCloud);
        root.getChildren().add(button);
        root.getChildren().add(button2);
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
                NewGame newGame = new NewGame(primaryStage);
                newGame.makeGame();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        primaryStage.show();
    }
}
