package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameEngine e = new GameEngine();
        Map map  = new Map(e.Menu());
        map.makeMap();
    }

}
