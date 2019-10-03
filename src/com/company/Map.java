package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Random random = new Random();
    private final int r = 5;
    private final int c = 5;
    private Animal[][] posAnimal = new Animal[r][c];
    ArrayList<Animal> zebra = new ArrayList<Animal>();
    ArrayList<Animal> cheetah = new ArrayList<Animal>();
    int numAnimals;
    int numCheetah;
    int numZebra;
    int eatenZebra = 0;
    boolean allCheetahFull = false;


    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of animals");
        numAnimals = scan.nextInt();
        numCheetah = random.nextInt((numAnimals / 2)) + 1;
        numZebra = (numAnimals - numCheetah);
        System.out.println("Zebra:" + numZebra);
        System.out.println("Cheetah:" + numCheetah);
    }

    private void initializeMap() {
        int countCheetah = 0;
        int countZebra = 0;
        do {
            int j = random.nextInt(r * c);
            int x = j / r;
            int y = j % c;
            if (posAnimal[x][y] == null) {
                posAnimal[x][y] = new Cheetah(x, y, r, c);
                cheetah.add(posAnimal[x][y]);
                countCheetah++;
            }
        } while (countCheetah != numCheetah);

        do {
            int j = random.nextInt(r * c);
            int x = j / r;
            int y = j % c;
            if (posAnimal[x][y] == null) {
                posAnimal[x][y] = new Zebra(x, y, this.r, this.c);
                //zebra[countZebra] = posAnimal[x][y];
                zebra.add(posAnimal[x][y]);
                countZebra++;
            }
        } while (countZebra != numZebra);
    }

    public void makeMap() {
        initializeMap();
        printMap();
    }

    public void startMoving() {
        for (; ; ) {
            moveCheetah();
            moveZebra();
            updateMap();
            printMap();
            if (zebra.size() < cheetah.size() || isAllCheetahFull() == true) {
                System.out.printf("%d Zebra died", eatenZebra);
                break;
            }
            System.out.println();
        }
    }


    private void moveCheetah() {
        for (int i = 0; i < cheetah.size(); i++) {
            cheetah.get(i).move();
//            cheetah.get(i).isFull()=false;
        }
        // Checking cheetah on cheetah
        for (int i = 0; i < cheetah.size(); i++) {
            for (int j = 0; j < cheetah.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (cheetah.get(i).getX() == cheetah.get(j).getX() && cheetah.get(i).getY() == cheetah.get(j).getY()) {
                    cheetah.get(i).setX(cheetah.get(i).getOldX());
                    cheetah.get(i).setY(cheetah.get(i).getOldY());
                }
            }
        }

        // checking Cheetah on Zebra
        for (int i = 0; i < cheetah.size(); i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (cheetah.get(i).getX() == zebra.get(j).getX() && cheetah.get(i).getY() == zebra.get(j).getY() && !cheetah.get(i).isFull()) {
                    zebra.remove(zebra.get(j));
                    System.out.println("zebra died");
                    eatenZebra++;
                    cheetah.get(i).setFull(true);
                    System.out.printf("Cheetah - %d is full%n", i);
                }
            }
        }
        for (int i = 0; i < cheetah.size(); i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (cheetah.get(i).getX() == zebra.get(j).getX() && cheetah.get(i).getY() == zebra.get(j).getY() && cheetah.get(i).isFull()) {
                    cheetah.get(i).setX(cheetah.get(i).getOldX());
                    cheetah.get(i).setY(cheetah.get(i).getOldY());
                }
            }
        }

    }

    public boolean isAllCheetahFull() {
        int countFullCheetah =0;
        for (int i = 0; i < cheetah.size(); i++) {
            if (cheetah.get(i).isFull() == true) {
                countFullCheetah++;
            }
        }
        if(cheetah.size()==countFullCheetah){
            allCheetahFull=true;
        }
        return allCheetahFull;
    }

    private void moveZebra() {
        for (int i = 0; i < zebra.size(); i++) {
            zebra.get(i).move();

        }
        // Checking zebra on zebra
        for (int i = 0; i < zebra.size(); i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (zebra.get(i).getX() == zebra.get(j).getX() && zebra.get(i).getY() == zebra.get(j).getY()) {
                    zebra.get(i).setX(zebra.get(i).getOldX());
                    zebra.get(i).setY(zebra.get(i).getOldY());
                }
            }
        }
        //checking Zebra on Cheetah
        for (int i = 0; i < zebra.size(); i++) {
            for (int j = 0; j < cheetah.size(); j++) {
                if (zebra.get(i).getX() == cheetah.get(j).getX() && zebra.get(i).getY() == cheetah.get(j).getY()/* && !cheetah.get(j).isFull()*/) {
                    zebra.get(i).setX(zebra.get(i).getOldX());
                    zebra.get(i).setY(zebra.get(i).getOldY());
//                    zebra.remove(zebra.get(i));
//                    cheetah.get(j).setFull(true);
//                    System.out.println("zebra died...");
//                    System.out.printf("Cheetah - %d is full%n",j);
//                    eatenZebra++;
                }
            }
        }
    }


    private void updateMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                posAnimal[i][j] = null;
            }
        }
        for (int i = 0; i < zebra.size(); i++) {
            posAnimal[zebra.get(i).getX()][zebra.get(i).getY()] = zebra.get(i);
        }
        for (int i = 0; i < cheetah.size(); i++) {
            posAnimal[cheetah.get(i).getX()][cheetah.get(i).getY()] = cheetah.get(i);
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

    public ArrayList<Animal> getZebra() {

        return zebra;
    }

    public ArrayList<Animal> getCheetah() {

        return cheetah;
    }

}

