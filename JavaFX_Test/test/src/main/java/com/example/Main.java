package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;

public class Main extends Application {
    Line line;
    Button button;
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label label = new Label("Home page");
        Button button1 = new Button("Go to page 1");
        button1.setOnAction(e -> window.setScene(scene2));

        // Layout 1 - children are laid out in verticle column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 300, 300);

        // button 2
        Button button2 = new Button("Back to home page");
        button2.setOnAction(e -> window.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300, 300);

        // Display homepage first
        window.setScene(scene1);
        window.setTitle("School Map");
        window.show();
    }

}