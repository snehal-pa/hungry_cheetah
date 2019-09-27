package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Random random = new Random();
    private int[][] position = new int[10][10];
    private Animal[][] posAnimal = new Animal[10][10];
    Animal[] animal;

    //constructor
    public Map() {


    }

    public void Menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of animals");
        int noOfAnimal = scan.nextInt();
//        map= new Map(noOfAnimal);
        animal = new Animal[noOfAnimal];
    }

    public int[][] getPosition() {
        int numCheetah = random.nextInt((animal.length / 2)) + 1;
        int numZebra = (animal.length - numCheetah);
        int countCheetah = 0;
        int countZebra = 0;
        do {
            int j = random.nextInt(100);
            int row = j / 10;
            int col = j % 10;
            if (position[row][col] == 0) {
                position[row][col] = 1;
                animal[countCheetah] = new Cheetah(row, col);
                countCheetah++;
            }

        } while (countCheetah != numCheetah);

        do {
            int j = random.nextInt(100);
            int row = j / 10;
            int col = j % 10;
            if (position[row][col] == 0) {
                position[row][col] = 2;
                animal[countCheetah] = new Zebra(row, col);
                countZebra++;
                countCheetah++;
            }
        } while (countZebra != numZebra);
        return position;
    }

    public void makeMap() {
        position = getPosition();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d ",position [i][j] );
            }
            System.out.println();
        }
        for (Animal a : getAnimal()) {
            System.out.println(a);
            System.out.printf("%d    %d%n", a.getX(), a.getY());
            System.out.printf("%d    %d%n", a.getX() + 1, a.getY());
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(position[i][j] + "   ");
                }
                System.out.println();
            }
        }

    }

    //    public Animal [][] getPosition() {
//        int numCheetah = random.nextInt((animal.length / 2)) + 1;
//        int numZebra = (animal.length - numCheetah);
//        int countCheetah = 0;
//        int countZebra = 0;
//        do {
//            int j = random.nextInt(100);
//            int row = j / 10;
//            int col = j % 10;
//            if (posAnimal[row][col] == null) {
//                posAnimal[row][col] = new Cheetah(row,col);
//                animal[countCheetah] = new Cheetah(row, col);
//                countCheetah++;
//            }
//
//        } while (countCheetah != numCheetah);
//
//        do {
//            int j = random.nextInt(100);
//            int row = j / 10;
//            int col = j % 10;
//            if (posAnimal[row][col] == null) {
//                posAnimal[row][col] = new Zebra(row,col);
//                animal[countCheetah] = new Zebra(row, col);
//                countZebra++;
//                countCheetah++;
//            }
//        } while (countZebra != numZebra);
//        return posAnimal;
//    }
//
    public void setNewPosition() {

    }

    public Animal[] getAnimal() {

        return animal;
    }

}

