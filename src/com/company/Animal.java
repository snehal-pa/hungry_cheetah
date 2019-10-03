package com.company;

import java.util.Random;

public abstract class Animal implements Directions {
    protected int x, oldX, y, oldY, row, col, dir, index = -1;

    protected boolean full; //to ckeck Cheetah if it is full

    public Animal(int x, int y, int row, int col, int index) {
        this.row = row;
        this.col = col;
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
        this.index = index;
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

    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void move() {
        Random r = new Random();
        int dir = r.nextInt(4); // get the random directions
//        int numSteps;                   // number of steps animals are moving
//        if (dir == dirUp || dir == dirDown) {
//            numSteps = r.nextInt(this.row + 1);
//        } else {
//            numSteps = r.nextInt(this.col + 1);
//        }
//
        oldX = x;
        oldY = y;

//            System.out.printf("%d %d %d\n", x, y, dir);

//        for (int i = 0; i < numSteps; i++) {
            if (this.x == 0 && this.y == 0 && dir == this.dirUp) {
                dir = this.dirRight;

            } else if (this.x == 0 && this.y == 0 && dir == this.dirLeft) {
                dir = this.dirDown;

            } else if (this.x == 0 && this.y == col - 1 && dir == this.dirUp) {
                dir = this.dirLeft;

            } else if (this.x == 0 && this.y == col - 1 && dir == this.dirRight) {
                dir = this.dirDown;

            } else if (this.x == this.row - 1 && this.y == this.col - 1 && dir == this.dirRight) {
                dir = this.dirUp;

            } else if (this.x == this.row - 1 && this.y == this.col - 1 && dir == this.dirDown) {
                dir = this.dirLeft;

            } else if (this.x == this.row - 1 && this.y == 0 && dir == this.dirDown) {
                dir = this.dirRight;

            } else if (this.x == this.row - 1 && this.y == 0 && dir == this.dirLeft) {
                dir = this.dirUp;

            } else if (this.x == 0 && dir == this.dirUp) {
                dir = this.dirRight;

            } else if (this.x == (this.row - 1) && dir == this.dirDown) {
                dir = this.dirLeft;

            } else if (y == 0 && dir == this.dirLeft) {
                dir = this.dirUp;

            } else if (y == this.col - 1 && dir == this.dirRight) {
                dir = this.dirDown;

            }
            switch (dir) {
                case dirUp:
                    x = x - 1;
                    break;
                case dirRight:
                    y = y + 1;
                    break;
                case dirDown:
                    x = x + 1;
                    break;
                case dirLeft:
                    y = y - 1;
                    break;
                default:
                    break;
            }
//        }
    }

    public void setFull(boolean b) {

        this.full = b;
    }

    public boolean isFull() {
        return full;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getDir() {
        return dir;
    }


}
