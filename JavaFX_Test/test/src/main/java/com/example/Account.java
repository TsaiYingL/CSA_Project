package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Account {
    private int studentID;
    private String password;

    public Account(int studentID, String password) {
        studentID = this.studentID;
        password = this.password;
    }

    public void createAccount(int ID, String key) {
        try {
            FileWriter myWriter = new FileWriter("UserInfo.txt", true);
            String[] info = { String.valueOf(ID), key };
            myWriter.write(Arrays.toString(info) + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean userExist(int ID) {
        String studentID = String.valueOf(ID);
        try {
            FileReader file = new FileReader("UserInfo.txt");
            BufferedReader readFile = new BufferedReader(file);
            String info = readFile.readLine();
            while (info != null) {
                if (info.contains(studentID)) {
                    readFile.close();
                    System.out.println("user exists!!!");
                    return true;
                }
                info = readFile.readLine();
            }
            readFile.close();
            return false;
        } catch (Exception e) {
            System.out.println("Oh no!!! an error!!! \n" + e);
            return false;
        }

    }
}
