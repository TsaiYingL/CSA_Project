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
    private int num; // number of the room in each floor
    private double xRange;
    private double yRange;

    public RoomType(Room[] rooms, int num, double xRange, double yRange) {
        this.rooms = rooms;
        this.num = num;
        this.xRange = xRange;
        this.yRange = yRange;
    }

    public Room getRoom(int floor) {
        return rooms[floor];
    }

    public Room[] getRooms() {
        return rooms;
    }

    public int getNum() {
        return num;
    }

    public double getxRange() {
        return xRange;
    }

    public double getyRange() {
        return yRange;
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

    @SuppressWarnings("exports")
    public void roomStat(Scene scene, int num) {

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                double mouseX = event.getX();
                double mouseY = event.getY();

                System.out.println("mouese: " + mouseX + " " + mouseY);
                System.out.println(rooms[num].check(mouseX, mouseY, xRange, yRange));
            }
        });
    }

    public static void allRoomStat(Scene scene, int floor, RoomType... roomTypes) {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                double mouseX = event.getX();
                double mouseY = event.getY();

                for (RoomType t : roomTypes) {
                    if (t.getNum() > 1) {
                        for (Room r : t.getRooms()) {
                            System.out.println(r.check(mouseX, mouseY, t.getxRange(), t.getyRange()));
                        }
                    } else {
                        System.out.println(t.getRoom(floor - 1).check(mouseX, mouseY, t.getxRange(), t.getyRange()));
                    }
                }
            }
        });
    }
}
