package com.game.simplegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class SimpleGame extends Application {

    @Override
    public void start(Stage stage){
        String defaultStyle = "-fx-background-color: #4ea1dc; -fx-font-size: 28px; -fx-pref-width: 70px; -fx-pref-height: 70px; -fx-background-radius: 20px;-fx-border-color: black;-fx-border-radius: 20px; -fx-border-width: 2px;";
        String stylePressed = "-fx-background-color: #1b79b7; -fx-font-size: 28px; -fx-pref-width: 70px; -fx-pref-height: 70px; -fx-background-radius: 20px;-fx-border-color: black;-fx-border-radius: 20px; -fx-border-width: 3px;";

        Button buttonUp = new Button("↑");
        buttonUp.setStyle(defaultStyle);

        Button buttonDown = new Button("↓");
        buttonDown.setStyle(defaultStyle);

        Button buttonLeft = new Button("←");
        buttonLeft.setStyle(defaultStyle);

        Button buttonRight = new Button("→");
        buttonRight.setStyle(defaultStyle);

        Rectangle block = new Rectangle(50,50, Color.rgb(102, 0, 102));
        block.setX(600/2 - 25);
        block.setY(600/2 - 25);

        GridPane gridPane = new GridPane();
        gridPane.add(buttonUp, 1, 0);
        gridPane.add(buttonDown, 1, 1);
        gridPane.add(buttonLeft, 0, 1);
        gridPane.add(buttonRight, 2, 1);

        gridPane.setLayoutX(600/2 - 105);
        gridPane.setLayoutY(450);

        Pane root = new Pane();
        root.getChildren().add(block);
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 600, 600);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {


            }
        };

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case W:
                    buttonUp.setStyle(stylePressed);
                    if(block.getY() >= 0){
                        block.setY(block.getY()-10);
                    }
                    break;
                case S:
                    buttonDown.setStyle(stylePressed);
                    if(block.getY() <= 550){
                        block.setY(block.getY()+10);
                    }
                    break;
                case A:
                    buttonLeft.setStyle(stylePressed);
                    if(block.getY() >= 0){
                        block.setX(block.getX()-10);
                    }
                    break;
                case D:
                    buttonRight.setStyle(stylePressed);
                    if(block.getY() <= 550){
                        block.setX(block.getX()+10);
                    }
                    break;
                default:
                    break;
            }
        });

        scene.setOnKeyReleased(event->{
            switch (event.getCode()){
                case W:
                    buttonUp.setStyle(defaultStyle);
                    break;
                case S:
                    buttonDown.setStyle(defaultStyle);
                    break;
                case A:
                    buttonLeft.setStyle(defaultStyle);
                    break;
                case D:
                    buttonRight.setStyle(defaultStyle);
                    break;
                default:
                    break;
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}