package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Random random = new Random();
    private final int r = 4;
    private final int c = 4;
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
        numCheetah = random.nextInt((numAnimals / 2)) + 1;
        numZebra = (numAnimals - numCheetah);
        System.out.println("Zebra:" + numZebra);
        System.out.println("Cheetah:" + numCheetah);
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
    }

    public void startMoving() {
        for (int i = 0; i < cheetah.length; i++) {
            cheetah[i].move();
        }
        for (int i = 0; i < cheetah.length; i++) {
            for (int j = 0; j < zebra.length; j++) {
                if (posAnimal[cheetah[i].getX()][cheetah[i].getY()] == zebra[j]) {
                    zebra[j] = zebra[zebra.length-1];
                    numZebra--;
                    System.out.println("zebra died");
                    for(Animal z: zebra){
                        System.out.print(z+"\t");
                    }
                }
            }
        }

        for (int i = 0; i < zebra.length; i++) {
            zebra[i].move();
        }
        for (int i = 0; i < zebra.length; i++) {
            for (int j = 0; j < cheetah.length; j++) {
                if (posAnimal[zebra[i].getX()][zebra[i].getY()] == cheetah[j]) {
                    posAnimal[zebra[i].getX()][zebra[i].getY()] = null;
                    System.out.println("zebra died");
                }
            }
        }

        updateMap();
    }

//    public boolean eaten() {
//        for (int i = 0; i < cheetah.length; i++) {
//            for (int j = 0; j < zebra.length; j++) {
//                if (posAnimal[cheetah[i].getX()][cheetah[i].getY()] == posAnimal[zebra[i].getX()][zebra[i].getY()]) {
//                    System.out.println("zebra died");
//                }
//            }
//        }
//        return true;
//    }

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
        // countZC();

    }

    public void countZC() {
        int ch = 0, ze = 0;
        int count = 0;
        do {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (posAnimal[i][j] != null && posAnimal[i][j] == zebra[ze]) {
                        ze++;
                    }
                }
            }
            count++;
        } while (count < zebra.length);
        count = 0;
        do {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (posAnimal[i][j] != null && posAnimal[i][j] == cheetah[ch]) {
                        ch++;
                    }
                }
            }
            count++;
        } while (count < cheetah.length);
        System.out.println("Zebra: " + ze + " cheetah:" + ch);

        ;

    }

    public void eatZebra() {
        for (int i = 0; i < r; i++) {
        }
    }

    public Animal[] getZebra() {

        return zebra;
    }

    public Animal[] getCheetah() {

        return cheetah;
    }

}

