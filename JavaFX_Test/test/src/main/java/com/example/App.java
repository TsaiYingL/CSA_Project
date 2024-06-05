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
    Scene loginScene, sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, editScene;

    // creating the elevators
    Room eleA = new Room(480, 646, 20);
    Room eleB = new Room(480, 628, 5, 20);
    Room eleC = new Room(480, 459, 1, 20);
    Room eleD = new Room(480, 247, 10, 20);
    Room eleE = new Room(480, 227, 20);
    RoomType elevator = new RoomType(new Room[] { eleA, eleB, eleC, eleD, eleE }, 5, 26, 18);

    // creating girls bathrooms
    Room gwc1 = new Room(537, 208, 1, 6);
    Room gwc2 = new Room(537, 208, 2, 6);
    Room gwc3 = new Room(537, 208, 3, 6);
    Room gwc4 = new Room(537, 208, 4, 6);
    Room gwc5 = new Room(537, 208, 5, 6);
    Room gwc6 = new Room(537, 208, 6, 6);
    Room gwc7 = new Room(527, 200, 3, 6);
    RoomType girlWC = new RoomType(new Room[] { gwc1, gwc2, gwc3, gwc4, gwc5, gwc6, gwc7 }, 1, 22, 12);

    // creating boys bathrooms
    Room bwc1 = new Room(204.8, 637.6, 1, 6);
    Room bwc2 = new Room(204.8, 637.6, 1, 6);
    Room bwc3 = new Room(204.8, 637.6, 1, 6);
    Room bwc4 = new Room(204.8, 637.6, 1, 6);
    Room bwc5 = new Room(204.8, 637.6, 1, 6);
    Room bwc6 = new Room(204.8, 637.6, 1, 6);
    Room bwc7 = new Room(204.8, 637.6, 1, 6);
    RoomType boyWC = new RoomType(new Room[] { bwc1, bwc2, bwc3, bwc4, bwc5, bwc6, bwc7 }, 1, 22, 12);

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
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
                Alert alert = new Alert(AlertType.CONFIRMATION, "Log In", ButtonType.YES, ButtonType.CANCEL,
                        ButtonType.APPLY);
                alert.setTitle("Brooklyn Tech");
                alert.setHeaderText(null);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.YES) {
                        // Switch to the main screen
                        window.setScene(scene1);
                        window.setTitle("Brooklyn Tech");
                    } else if (response == ButtonType.APPLY) {
                        window.setScene(editScene);
                        window.setTitle("Edit status");
                    } else {
                        // Show a message indicating the operation is canceled
                        Alert cancelAlert = new Alert(AlertType.INFORMATION, "Log in canceled");
                        cancelAlert.setHeaderText(null);
                        cancelAlert.showAndWait();
                    }
                });
            }
        };

        // action event
        Label l = new Label("no text");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!usernameField.getText().equals("246318489") || !passwordField.getText().equals("password")) {
                    l.setText("Incorrect username or password");
                    loginLayout.getChildren().add(l);
                } else {
                    passwordField.setOnAction(loginEvent);
                }
            }
        };

        // when enter is pressed
        passwordField.setOnAction(event);

        // When enter is pressed
        return loginLayout;
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
        ImageView imageView = Method.addImage(image, 700, 700);

        vbox.getChildren().addAll(label, imageView);
        stackPane.getChildren().addAll(vbox);

        HBox hbox = Method.addMenuButtonBox(window, scenes);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(stackPane);

        scenes[floor] = new Scene(borderPane, 700, 800);
        // girlWC.roomStat(scenes[floor], floor - 1);
        // elevator.roomStat(scenes[floor]);
        RoomType.allRoomStat(scenes[floor], floor, girlWC, boyWC, elevator);

        return scenes[floor];
    }

    public VBox editStat() {
        VBox vbox = new VBox(10);
        Button add = new Button("+");
        Button subtract = new Button("-");

        Label label = new Label("Edit Scene");

        vbox.getChildren().addAll(add, subtract, label);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
}