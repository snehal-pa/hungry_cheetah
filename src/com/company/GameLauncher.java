package com.company;

import java.util.Scanner;

public class GameLauncher {

    Map map = new Map();


    public void startGameLauncher(){
        map.menu();
        map.makeMap();
        map.startMoving();
        System.out.println();
//        map.printMap();

    }
}
