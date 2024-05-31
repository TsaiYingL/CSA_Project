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
import javafx.stage.Stage;
import javafx.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Scenes {
    Scene sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;

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

    public VBox createScenes(int floor, String imgpath) throws FileNotFoundException {
        Scene[] scenes = { sceneb, scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8 };

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        Label label;
        if (floor == 0) {
            label = new Label("Basement");
        } else {
            label = new Label("Floor" + String.valueOf(floor));
        }
        Image image = new Image(new FileInputStream(imgpath));
        ImageView imageView = addImage(image);
        layout.getChildren().addAll(label, imageView);
        scenes[floor] = new Scene(layout, 500, 500);
    }
}
