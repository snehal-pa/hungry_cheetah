package com.company;

import java.util.Random;

public class Cheetah extends Animal {
    public Cheetah(int x, int y, int r, int c, int index) {
        super(x, y, r, c, index);
    }

    public String toString() {
        return String.format("%S%02d", "C", index);
    }

//    public void move() {
//        Random r = new Random();
//        dir = r.nextInt(4);
//        int numSteps;
////        if (dir == dirUp || dir == dirDown) {
////            numSteps = r.nextInt(this.row + 1);
////        } else {
////            numSteps = r.nextInt(this.col + 1);
////        }
//
////        System.out.printf("%d %d %d\n", x, y, dir);
////        oldX = x;
////        oldY = y;
//
////        for (int i = 0; i < numSteps; i++) {
//            if (this.x == 0 && this.y == 0 && dir == this.dirUp) {
//                dir = this.dirRight;
//
//            } else if (this.x == 0 && this.y == 0 && dir == this.dirLeft) {
//                dir = this.dirDown;
//
//            } else if (this.x == 0 && this.y == col - 1 && dir == this.dirUp) {
//                dir = this.dirLeft;
//
//            } else if (this.x == 0 && this.y == col - 1 && dir == this.dirRight) {
//                dir = this.dirDown;
//
//            } else if (this.x == this.row - 1 && this.y == this.col - 1 && dir == this.dirRight) {
//                dir = this.dirUp;
//
//            } else if (this.x == this.row - 1 && this.y == this.col - 1 && dir == this.dirDown) {
//                dir = this.dirLeft;
//
//            } else if (this.x == this.row - 1 && this.y == 0 && dir == this.dirDown) {
//                dir = this.dirRight;
//
//            } else if (this.x == this.row - 1 && this.y == 0 && dir == this.dirLeft) {
//                dir = this.dirUp;
//
//            } else if (this.x == 0 && dir == this.dirUp) {
//                dir = this.dirRight;
//
//            } else if (this.x == (this.row - 1) && dir == this.dirDown) {
//                dir = this.dirLeft;
//
//            } else if (y == 0 && dir == this.dirLeft) {
//                dir = this.dirUp;
//
//            } else if (y == this.col - 1 && dir == this.dirRight) {
//                dir = this.dirDown;
//
//            }
//            switch (dir) {
//                case dirUp:
//                    x = x - 1;
//                    break;
//                case dirRight:
//                    y = y + 1;
//                    break;
//                case dirDown:
//                    x = x + 1;
//                    break;
//                case dirLeft:
//                    y = y - 1;
//                    break;
//                default:
//                    break;
//            }
////        }
//
//    }


}
