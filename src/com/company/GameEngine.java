package com.company;

import java.util.Scanner;

public class GameEngine {

    Map map = new Map();


    public void startGameEngine(){
        map.menu();
        map.makeMap();
        map.startMoving();
        System.out.println();
//        map.printMap();

    }
}
