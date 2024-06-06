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

public class Method {

    private static MenuItem[] menuItems;

    @SuppressWarnings("exports")
    public static ImageView addImage(Image img, int height, int width) {
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

        menuItems = new MenuItem[] { floorb, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8 };

        return menuItems;
    }

    @SuppressWarnings("exports")
    public static MenuButton addMenuButtonBox(MenuItem[] items) {

        // Creating a dropdown menu for the floors
        MenuButton floors = new MenuButton("Floors");
        for (int i = 0; i < items.length; i++) {
            int num = i;
            floors.getItems().addAll(items[num]);
        }

        return floors;
    }

    @SuppressWarnings("exports")
    public static void setAction(Stage window, Scene[] scenes) {
        MenuItem[] items = createItems();

        items[0].setOnAction(e -> window.setScene(scenes[0]));
        items[1].setOnAction(e -> window.setScene(scenes[1]));
        items[2].setOnAction(e -> window.setScene(scenes[2]));
        items[3].setOnAction(e -> window.setScene(scenes[3]));
        items[4].setOnAction(e -> window.setScene(scenes[4]));
        items[5].setOnAction(e -> window.setScene(scenes[5]));
        items[6].setOnAction(e -> window.setScene(scenes[6]));
        items[7].setOnAction(e -> window.setScene(scenes[7]));
        items[8].setOnAction(e -> window.setScene(scenes[8]));
    }

    @SuppressWarnings("exports")
    public static HBox topMenu(Stage window, Scene[] scenes) {
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");

        MenuButton button = addMenuButtonBox(createItems());
        setAction(window, scenes);

        topMenu.getChildren().addAll(button);

        return topMenu;
    }
}
