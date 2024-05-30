package com.example;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class Method {

    @SuppressWarnings("exports")
    public ImageView addImage(Image img) {
        ImageView imageView = new ImageView(img);
        imageView.setX(50);
        imageView.setY(25);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }

    @SuppressWarnings("exports")
    public HBox addButtons() {
        HBox topMenu = new HBox();
        Label label = new Label("Home");
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #336699;");

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
