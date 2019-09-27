package com.company;

import java.util.Scanner;

public class GameEngine {
    int noOfAnimal;
    Map map;
    public int Menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of animals");
        noOfAnimal = scan.nextInt();
        map= new Map(noOfAnimal);
        return noOfAnimal;
    }


    public void newPos(){
       Animal [] animals = map.getAnimal();
    }
}
