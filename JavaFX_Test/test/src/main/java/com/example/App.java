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
    Scene loginScene, sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, eSceneb,
            eScene1, eScene2, eScene3, eScene4, eScene5, eScene6, eScene7, eScene8;

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

        // Create the edit scenes
        eScene1 = editStat(1);
        eScene2 = editStat(2);
        eScene3 = editStat(3);
        eScene4 = editStat(4);
        eScene5 = editStat(5);
        eScene6 = editStat(6);
        eScene7 = editStat(7);

        VBox loginLayout = logIn();

        // Create the login scene
        loginScene = new Scene(loginLayout, 300, 200);

        // Set the initial scene to the login scene
        window.setScene(loginScene);
        window.show();
    }

    @SuppressWarnings("exports")
    public ImageView addImage(Image img, int height, int width) {
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }

    @SuppressWarnings("exports")
    public static MenuItem[] createItems() {
        MenuItem floorb = new MenuItem("Basement");
        MenuItem floor1 = new MenuItem("Floor 1");
        MenuItem floor2 = new MenuItem("Floor 2");
        MenuItem floor3 = new MenuItem("Floor 3");
        MenuItem floor4 = new MenuItem("Floor 4");
        MenuItem floor5 = new MenuItem("Floor 5");
        MenuItem floor6 = new MenuItem("Floor 6");
        MenuItem floor7 = new MenuItem("Floor 7");
        MenuItem floor8 = new MenuItem("Floor 8");

        MenuItem[] menuItems = new MenuItem[] { floorb, floor1, floor2, floor3, floor4, floor5, floor6, floor7,
                floor8 };

        return menuItems;
    }

    @SuppressWarnings("exports")
    public static MenuButton createButton(MenuItem[] items) {

        // Creating a dropdown menu for the floors
        MenuButton floors = new MenuButton("Floors");
        for (int i = 0; i < items.length; i++) {
            int num = i;
            floors.getItems().addAll(items[num]);
        }

        return floors;
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
                        window.setScene(eScene1);
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

    @SuppressWarnings("exports")
    public HBox addMenuButtonBox() {
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");

        MenuItem[] items = createItems();
        MenuButton floors = createButton(items);

        items[0].setOnAction(e -> window.setScene(sceneb));
        items[1].setOnAction(e -> window.setScene(scene1));
        items[2].setOnAction(e -> window.setScene(scene2));
        items[3].setOnAction(e -> window.setScene(scene3));
        items[4].setOnAction(e -> window.setScene(scene4));
        items[5].setOnAction(e -> window.setScene(scene5));
        items[6].setOnAction(e -> window.setScene(scene6));
        items[7].setOnAction(e -> window.setScene(scene7));
        items[8].setOnAction(e -> window.setScene(scene8));
        topMenu.getChildren().addAll(floors);

        return topMenu;
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
        ImageView imageView = addImage(image, 700, 700);

        vbox.getChildren().addAll(label, imageView);
        stackPane.getChildren().addAll(vbox);

        HBox hbox = addMenuButtonBox();

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(stackPane);

        scenes[floor] = new Scene(borderPane, 700, 800);
        // girlWC.roomStat(scenes[floor], floor - 1);
        // elevator.roomStat(scenes[floor]);
        RoomType.allRoomStat(scenes[floor], floor, girlWC, boyWC, elevator);

        return scenes[floor];
    }

    public VBox statDisplay(int floor) {
        VBox vbox = new VBox();

        Room[] elevators = elevator.getRooms();
        Room[] gWCs = girlWC.getRooms();
        Room[] bWCs = boyWC.getRooms();

        Room[] roomOnFloor = { elevators[0], elevators[1], elevators[2], elevators[3], elevators[4], gWCs[floor - 1],
                bWCs[floor - 1] };

        // labeling the scene
        Label fl;
        if (floor == 0) {
            fl = new Label("Basement");
        } else {
            fl = new Label("Floor " + String.valueOf(floor));
        }
        vbox.getChildren().add(fl);

        for (Room r : roomOnFloor) {

            String[] stat = r.getStat();
            TilePane tilePane = new TilePane();
            TilePane tilePane2 = new TilePane();
            Label label = new Label();

            label.setText("Room: " + stat[0] + " People in room: " + stat[1] + " People on line: " + stat[2]);
            tilePane.getChildren().add(label);

            Button add = new Button("+");
            EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    r.addNum(1);
                    String[] currentStat = r.getStat();
                    label.setText("Room: " + currentStat[0] + " People in room: " + currentStat[1] + " People on line: "
                            + currentStat[2]);
                }
            };
            add.setOnAction(addEvent);

            Button subtract = new Button("-");
            EventHandler<ActionEvent> subtractEvent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    r.removeNum(1);
                    String[] currentStat = r.getStat();
                    label.setText("Room: " + currentStat[0] + " People in room: " + currentStat[1] + " People on line: "
                            + currentStat[2]);
                }
            };
            subtract.setOnAction(subtractEvent);

            Button openOrClose = new Button("open/close");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    r.changeStat();
                    String[] currentStat = r.getStat();
                    label.setText("Room: " + currentStat[0] + " People in room: " + currentStat[1] + " People on line: "
                            + currentStat[2]);
                }
            };
            openOrClose.setOnAction(event);

            tilePane2.getChildren().addAll(subtract, add, openOrClose);
            tilePane.setTileAlignment(Pos.TOP_CENTER);
            tilePane.setVgap(10);
            tilePane.setHgap(20);

            vbox.getChildren().addAll(tilePane, tilePane2);
        }

        return vbox;
    }

    public Scene editStat(int floor) {
        Scene[] scenes = { eSceneb, eScene1, eScene2, eScene3, eScene4, eScene5, eScene6, eScene7, eScene8 };

        VBox vbox = statDisplay(floor);

        MenuItem[] items = createItems();
        MenuButton menu = createButton(items);

        items[0].setOnAction(e -> window.setScene(eSceneb));
        items[1].setOnAction(e -> window.setScene(eScene1));
        items[2].setOnAction(e -> window.setScene(eScene2));
        items[3].setOnAction(e -> window.setScene(eScene3));
        items[4].setOnAction(e -> window.setScene(eScene4));
        items[5].setOnAction(e -> window.setScene(eScene5));
        items[6].setOnAction(e -> window.setScene(eScene6));
        items[7].setOnAction(e -> window.setScene(eScene7));
        items[8].setOnAction(e -> window.setScene(eScene8));

        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");
        topMenu.getChildren().addAll(menu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(vbox);

        scenes[floor] = new Scene(borderPane, 500, 500);
        return scenes[floor];
    }
}