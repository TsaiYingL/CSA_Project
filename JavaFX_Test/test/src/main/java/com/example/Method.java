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
    public static Pair<HBox, Scene[]> addMenuButtonBox(Stage window, Scene[] scenes) {
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

        MenuItem[] menuItems = { floorb, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8 };

        for (int i = 0; i < scenes.length; i++) {
            int num = i;
            menuItems[i].setOnAction(e -> {
                window.setScene(scenes[num]);
                System.out.println(num);
            });
        }
        topMenu.getChildren().addAll(floors);

        Pair<HBox, scene[]> pair = Pair.with(topMenu, scenes);

        return Pair<topMenu. scenes>;
    }
}
