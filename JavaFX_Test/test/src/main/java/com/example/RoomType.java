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

public class RoomType {
    private Room[] rooms;
    private double xRange;
    private double yRange;

    public RoomType(Room[] rooms, double xRange, double yRange) {
        this.rooms = rooms;
        this.xRange = xRange;
        this.yRange = yRange;
    }

    @SuppressWarnings("exports")
    public void roomStat(Scene scene) {

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                double mouseX = event.getX();
                double mouseY = event.getY();

                System.out.println("mouese: " + mouseX + " " + mouseY);
                for (Room r : rooms) {
                    System.out.println(r.check(mouseX, mouseY, xRange, yRange));
                }
            }
        });
    }
}
