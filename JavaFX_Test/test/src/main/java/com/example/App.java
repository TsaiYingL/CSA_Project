package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application {
    Line line;
    Button button;
    Stage window;
    Scene loginScene, sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;

    Room eleA = new Room(480, 645, 20);
    Room eleB = new Room(480, 630, 5, 20);
    Room[] elevators = { eleA, eleB };

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        System.out.println("ijelijlwjf" + eleA.xVal() + " " + eleA.yVal());
        window = primaryStage;
        // set title for the stage
        window.setTitle("Brooklyn Tech");

        // Create the floor scenes
        scene1 = createScenes(1, "floorPlan\\floor.png");
        scene2 = createScenes(2, "floorPlan\\floor.png");
        scene3 = createScenes(3, "floorPlan\\floor.png");
        scene4 = createScenes(4, "floorPlan\\floor.png");
        scene5 = createScenes(5, "floorPlan\\floor5.png");
        scene6 = createScenes(6, "floorPlan\\floor.png");
        scene7 = createScenes(7, "floorPlan\\floor7.png");

        VBox loginLayout = logIn();

        // Create the login scene
        loginScene = new Scene(loginLayout, 300, 200);

        // Set the initial scene to the login scene
        window.setScene(loginScene);
        window.show();
    }

    @SuppressWarnings("exports")
    public ImageView addImage(Image img) {
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(700);
        imageView.setFitWidth(700);
        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }

    @SuppressWarnings("exports")
    public HBox addButtons() {
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");

        // Creating a dropdown menu for the floors
        MenuButton floors = new MenuButton("Floors");
        MenuItem floorb = new MenuItem("Basement");
        MenuItem floor1 = new MenuItem("Floor 1");
        MenuItem floor2 = new MenuItem("Floor 2");
        MenuItem floor3 = new MenuItem("Floor 3");
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
        topMenu.getChildren().addAll(floors);

        return topMenu;
    }

    @SuppressWarnings("exports")
    public void elevators(Scene scene, Room[] ele) {
        Room[] elevator = ele;

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            double mouseX, mouseY;

            public void handle(MouseEvent event) {
                mouseX = event.getX();
                mouseY = event.getY();

                System.out.println(mouseX + " " + mouseY);
                for (Room i : elevator) {
                    System.out.println(i.xVal() + " " + i.yVal());
                    if ((Math.abs(mouseX - i.xVal() - 5) <= 10) && (Math.abs(mouseY - i.yVal() - 10) <= 10)) {
                        System.out.println(i.check());
                    } else {
                        System.out.println("no elevator");
                    }
                }
            }
        });
    }

    public Scene createScenes(int floor, String imgpath) throws FileNotFoundException {
        Scene[] scenes = { sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8 };

        StackPane stackPane = new StackPane();

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);

        // labeling the scene
        Label label;
        if (floor == 0) {
            label = new Label("Basement");
        } else {
            label = new Label("Floor " + String.valueOf(floor));
        }

        // importing the floor map
        Image image = new Image(new FileInputStream(imgpath));
        ImageView imageView = addImage(image);

        vbox.getChildren().addAll(label, imageView);
        stackPane.getChildren().addAll(vbox);

        HBox hbox = addButtons();

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(stackPane);

        scenes[floor] = new Scene(borderPane, 700, 800);
        elevators(scenes[floor], elevators);

        return scenes[floor];
    }

    public VBox logIn() {
        // TextField for username
        TextField usernameField = new TextField();
        Label usernameLabel = new Label("Username:");
        usernameLabel.setLabelFor(usernameField);
        // PasswordField for password
        PasswordField passwordField = new PasswordField();
        Label passwordLabel = new Label("Password:");
        passwordLabel.setLabelFor(passwordField);
        // VBox layout for login screen
        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);
        // Event handler for login action
        EventHandler<ActionEvent> loginEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Display a confirmation dialog with Yes and Cancel options
                Alert alert = new Alert(AlertType.CONFIRMATION, "Log In", ButtonType.YES, ButtonType.CANCEL);
                alert.setTitle("Brooklyn Tech");
                alert.setHeaderText(null);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.YES) {
                        // Switch to the main screen
                        window.setScene(scene1);
                        window.setTitle("Brooklyn Tech");
                    } else {
                        // Show a message indicating the operation is canceled
                        Alert cancelAlert = new Alert(AlertType.INFORMATION, "Log in canceled");
                        cancelAlert.setHeaderText(null);
                        cancelAlert.showAndWait();
                    }
                });
            }
        };
        // When enter is pressed
        passwordField.setOnAction(loginEvent);
        return loginLayout;
    }
}