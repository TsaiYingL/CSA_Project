package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;

public class Main extends Application implements EventHandler<ActionEvent> {
    Line line;
    Button button;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First ex");

        button = new Button();
        button.setText("click");
        button.setOnAction(this); // whenever u click on the button, the method that handle the action is in this
                                  // class

        Line line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(100);
        line.setEndY(200);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(line);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("Hehe");
        }
    }

}