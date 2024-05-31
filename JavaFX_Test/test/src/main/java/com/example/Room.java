package com.example;

public class Room {
    private double x;
    private double y;
    private int peopleNum;
    private int maxNum;
    private int lineNum;
    private boolean isOpen;

    public Room(double x, double y, int max) {
        this.x = x;
        this.y = y;
        peopleNum = 0;
        maxNum = max;
    }

    public Room(double x, double y, int num, int max) {
        this.x = x;
        this.y = y;
        isOpen = true;
        peopleNum = num;
        maxNum = max;
    }

    public Room(double x, double y, int num, int line, int max) {
        this.x = x;
        this.y = y;
        peopleNum = num;
        maxNum = max;
        lineNum = line;
        isOpen = false;
    }

    public double xVal() {
        return x;
    }

    public double yVal() {
        return y;
    }

    public int getNum() {
        return peopleNum;
    }

    public int getMax() {
        return maxNum;
    };

    public int getOnLine() {
        return lineNum;
    }

    public boolean getOpen() {
        return isOpen;
    }

    public void close() {
        peopleNum = 0;
        isOpen = false;
        System.out.println("The room is closed");
    }

    public void open() {
        isOpen = true;
        System.out.println("The room is open");
    }

    public void addNum(int num) {
        open();
        if (num >= 0) {
            if (peopleNum + num >= maxNum) {
                System.out.println("The room is full");
                peopleNum = maxNum;
                lineNum = num - maxNum;
            } else {
                peopleNum += num;
            }
            System.out.println(check());
        } else {
            System.out.println("You can't add negative people");
        }
    }

    public void removeNum(int num) {
        open();
        if (num >= 0) {
            if (peopleNum >= maxNum) {
                lineNum -= num;
                if (lineNum < 0) {
                    peopleNum += lineNum;
                    lineNum = 0;
                }
            } else {
                peopleNum -= num;
            }
            System.out.println(check());
        } else {
            System.out.println("You can't subtract negative people");
        }
    }

    public void addMax(int num) {
        maxNum += num;
        reset();
    }

    public void subtractMax(int num) {
        maxNum -= num;
        reset();
    }

    public void reset() {
        int sum = peopleNum + lineNum;
        if (sum - maxNum >= 0) {
            lineNum = sum - maxNum;
            peopleNum = maxNum;
        } else {
            lineNum = 0;
            peopleNum = sum;
        }
        System.out.println(check());
    }

    public String check() {
        String status;
        if (isOpen == true) {
            status = "open";
        } else {
            status = "closed";
        }
        return ("The room is " + status + ". There are " + peopleNum + " people in the room and " + lineNum
                + " people on line");
    }
}