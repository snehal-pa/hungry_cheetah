package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();
        map.menu();
        map.makeMap();
//        for (; ; ) {
            map.startMoving();
            System.out.println();
            map.printMap();
//       }
        //GameEngine e = new GameEngine();
    }

}
