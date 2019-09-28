package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Random random = new Random();
    private final int r = 10;
    private final int c = 10;
    //private int[][] position = new int[r][c];
    private Animal[][] posAnimal = new Animal[r][c];
    Animal[] zebra;
    Animal[] cheetah;
    int numAnimals;
    int numCheetah;
    int numZebra;

    //constructor
    public Map() {


    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of animals");
        numAnimals = scan.nextInt();
        numCheetah = random.nextInt((numAnimals / 3)) + 1;
        numZebra = (numAnimals - numCheetah);
        int countCheetah = 0;
        int countZebra = 0;
        zebra = new Zebra[numZebra];
        cheetah = new Cheetah[numCheetah];
    }

    private void initializeMap() {
        int countCheetah = 0;
        int countZebra = 0;
        do {
            int j = random.nextInt(r * c);
            int x = j / r;
            int y = j % c;
            if (posAnimal[x][y] == null) {
                posAnimal[x][y] = new Cheetah(x, y, this.r, this.c);
                cheetah[countCheetah] = posAnimal[x][y];
                countCheetah++;
            }
        } while (countCheetah != numCheetah);

        do {
            int j = random.nextInt(r * c);
            int x = j / r;
            int y = j % c;
            if (posAnimal[x][y] == null) {
                posAnimal[x][y] = new Zebra(x, y, this.r, this.c);
                zebra[countZebra] = posAnimal[x][y];
                countZebra++;
            }
        } while (countZebra != numZebra);
    }

    public void makeMap() {
        initializeMap();
        printMap();
//        for (Animal c : getCheetah()) {
//            System.out.println(c);
//            System.out.printf("%d    %d%n", c.getX(), c.getY());
//        }
//        for (Animal z : getZebra()) {
//            System.out.println(z);
//            System.out.printf("%d    %d%n", z.getX(), z.getY());
//        }

    }

    public void startMoving() {
        for (int i = 0; i < cheetah.length; i++) {
            cheetah[i].move();
        }
        for (int i = 0; i < zebra.length; i++) {
            zebra[i].move();
        }
        updateMap();
    }

    private void updateMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                posAnimal[i][j] = null;
            }
        }
        for (int i = 0; i < cheetah.length; i++) {
            posAnimal[cheetah[i].getX()][cheetah[i].getY()] = cheetah[i];
        }
        for (int i = 0; i < zebra.length; i++) {
            posAnimal[zebra[i].getX()][zebra[i].getY()] = zebra[i];
        }

    }

    public void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (posAnimal[i][j] == null) {
                    System.out.print("O" + "\t");
                } else {
                    System.out.print(posAnimal[i][j] + "\t");
                }
            }
            System.out.println();
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

    public Animal[] getZebra() {

        return zebra;
    }

    public Animal[] getCheetah() {

        return cheetah;
    }

}

