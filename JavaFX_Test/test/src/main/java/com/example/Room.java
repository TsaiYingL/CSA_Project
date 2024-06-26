package com.example;

public class Room {
    private double x;
    private double y;
    private int peopleNum;
    private int maxNum;
    private int lineNum;
    private boolean isOpen;

    public Room() {
    }

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

    public String[] getStat() {
        String roomIsOpen;
        if (isOpen == true) {
            roomIsOpen = "open";
        } else {
            roomIsOpen = "close";
        }
        return new String[] { roomIsOpen, String.valueOf(peopleNum), String.valueOf(lineNum) };
    }

    public void close() {
        lineNum = 0;
        peopleNum = 0;
        isOpen = false;
        System.out.println("The room is closed");
    }

    public void open() {
        isOpen = true;
        System.out.println("The room is open");
    }

    public void changeStat() {
        if (isOpen == true) {
            close();
        } else {
            open();
        }
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
        } else {
            System.out.println("You can't add negative people");
        }
        System.out.println(check());
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
        } else {
            System.out.println("You can't subtract negative people");
        }
        System.out.println(check());
    }

    public void addMax(int num) {
        maxNum += num;
        reset();
        System.out.println(check());
    }

    public void subtractMax(int num) {
        maxNum -= num;
        reset();
        System.out.println(check());
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
        String[] stat = getStat();
        return ("The room is " + stat[0] + ". There are " + peopleNum + " people in the room and " + lineNum
                + " people on line");
    }

    public void check(double x, double y, double xRange, double yRange) {
        if ((Math.abs(x - xVal() - xRange / 2) <= xRange / 2) && (Math.abs(y - yVal() - yRange / 2) <= yRange / 2)) {
            String[] stat = getStat();
            System.out.println("The room is " + stat[0] + ". There are " + peopleNum + " people in the room and "
                    + lineNum + " people on line");
        }
    }
}