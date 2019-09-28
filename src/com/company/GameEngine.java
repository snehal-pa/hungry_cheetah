package com.company;

import java.util.Scanner;

public class GameEngine {
    int noOfAnimal;
    Map map  = new Map();



    public void startGameEngine(){
       // map.menu();
        map.makeMap();
        map.startMoving();

    }
}
