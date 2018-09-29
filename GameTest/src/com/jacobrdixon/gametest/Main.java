package com.jacobrdixon.gametest;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final Rectangle PLAYER = new Rectangle(0, 0, 30, 30 );
    private static boolean up    = false;
    private static boolean down  = false;
    private static boolean left  = false;
    private static boolean right = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        root.getChildren().add(PLAYER);

        Scene scene = new Scene(root, 400, 400);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                KeyCode key = event.getCode();

                if( key == KeyCode.UP){
                    up = true;
                } else if ( key == KeyCode.DOWN ){
                    down = true;
                } else if ( key == KeyCode.LEFT ){
                    left = true;
                } else if ( key == KeyCode.RIGHT ){
                    right = true;
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                KeyCode key = event.getCode();

                if( key == KeyCode.UP){
                    up = false;
                } else if ( key == KeyCode.DOWN ){
                    down = false;
                } else if ( key == KeyCode.LEFT ){
                    left = false;
                } else if ( key == KeyCode.RIGHT ){
                    right = false;
                }

            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();
        timer.start();

    }

    public static void main(String[] args){
        launch(args);
    }

    private void onUpdate(){

        double playerPosX = PLAYER.getX();
        double playerPosY = PLAYER.getY();


        if(up){
            if(playerPosY > 0){
                PLAYER.setY(playerPosY - 5);
            }
        }
        if(down){
            if(playerPosY + 30 < 400){
                PLAYER.setY(playerPosY + 5);
            }
        }
        if(left){
            if(playerPosX > 0){
                PLAYER.setX(playerPosX - 5);
            }
        }
        if(right){
            if(playerPosX + 30 < 400){
                PLAYER.setX(playerPosX + 5);
            }
        }

    }

}
