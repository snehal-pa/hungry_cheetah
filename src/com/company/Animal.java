package com.company;

public abstract class Animal implements Position {
    int x, y;

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void move() {

    }
    public String toString(){
        return String.format("");
    }
}
