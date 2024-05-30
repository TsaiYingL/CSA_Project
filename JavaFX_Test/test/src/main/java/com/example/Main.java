package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
    Scene sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        /*
         * Label label = new Label("First Floor");
         * Button button1 = new Button("Second Floor");
         * Button button2 = new Button("Third Floor");
         * button1.setOnAction(e -> window.setScene(scene2));
         * 
         * HBox topMenu = new HBox();
         * topMenu.getChildren().addAll(label, button1, button2);
         */

        HBox topMenu = addButtons();

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
        button10.setOnAction(e -> window.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button10);
        scene2 = new Scene(layout2, 300, 300);

        // Display homepage first
        window.setScene(scene1);
        window.setTitle("School Map");
        window.show();
    }

    public HBox addButtons() {
        HBox topMenu = new HBox();
        Label label = new Label("Home");
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");

        /*
         * Creating the buttons one by one
         * Button floorb = new Button("Basement");
         * Button floor1 = new Button("Floor 1");
         * Button floor3 = new Button("Floor 2");
         * Button floor2 = new Button("Floor 3");
         * Button floor4 = new Button("Floor 4");
         * Button floor5 = new Button("Floor 5");
         * Button floor6 = new Button("Floor 6");
         * Button floor7 = new Button("Floor 7");
         * Button floor8 = new Button("Floor 8");
         * 
         * floorb.setPrefSize(100, 20);
         * 
         * floorb.setOnAction(e -> window.setScene(sceneb));
         * floor1.setOnAction(e -> window.setScene(scene1));
         * floor2.setOnAction(e -> window.setScene(scene2));
         * floor3.setOnAction(e -> window.setScene(scene3));
         * floor4.setOnAction(e -> window.setScene(scene4));
         * floor5.setOnAction(e -> window.setScene(scene5));
         * floor6.setOnAction(e -> window.setScene(scene6));
         * floor7.setOnAction(e -> window.setScene(scene7));
         * floor8.setOnAction(e -> window.setScene(scene8));
         */

        // Creating a dropdown menu for the floors
        MenuButton floors = new MenuButton("Floors");
        MenuItem floorb = new MenuItem("Basement");
        MenuItem floor1 = new MenuItem("Floor 1");
        MenuItem floor3 = new MenuItem("Floor 2");
        MenuItem floor2 = new MenuItem("Floor 3");
        MenuItem floor4 = new MenuItem("Floor 4");
        MenuItem floor5 = new MenuItem("Floor 5");
        MenuItem floor6 = new MenuItem("Floor 6");
        MenuItem floor7 = new MenuItem("Floor 7");
        MenuItem floor8 = new MenuItem("Floor 8");
        floors.getItems().addAll(floorb, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8);

        floorb.setOnAction(e -> window.setScene(sceneb));
        floor1.setOnAction(e -> window.setScene(scene1));
        floor2.setOnAction(e -> window.setScene(scene2));
        floor3.setOnAction(e -> window.setScene(scene3));
        floor4.setOnAction(e -> window.setScene(scene4));
        floor5.setOnAction(e -> window.setScene(scene5));
        floor6.setOnAction(e -> window.setScene(scene6));
        floor7.setOnAction(e -> window.setScene(scene7));
        floor8.setOnAction(e -> window.setScene(scene8));
        topMenu.getChildren().addAll(label, floors);

        return topMenu;
    }
}