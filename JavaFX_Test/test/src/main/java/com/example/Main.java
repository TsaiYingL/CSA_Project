package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.FileInputStream;
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

        Label label = new Label("First Floor");
        Button button1 = new Button("Second Floor");
        Button button2 = new Button("Third Floor");
        button1.setOnAction(e -> window.setScene(scene2));

        HBox topMenu = new HBox();
        topMenu.getChildren().addAll(label, button1, button2);

        Image image = new Image(new FileInputStream("techFloorPlan.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(25);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(stackPane);

        scene1 = new Scene(borderPane, 500, 500);

        /*
         * StackPane layout1 = new StackPane();
         * layout1.getChildren().addAll(label, button1, imageView);
         * scene1 = new Scene(layout1, 300, 300);
         */

        // button 2
        Button button10 = new Button("Back to home page");
        button2.setOnAction(e -> window.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button10);
        scene2 = new Scene(layout2, 300, 300);

        // Display homepage first
        window.setScene(scene1);
        window.setTitle("School Map");
        window.show();
    }

}