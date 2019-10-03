package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
    Random random = new Random(); //initialize an object of Random class
    private final int r = 5; // constant value row
    private final int c = 5; //constant value column
    private Animal[][] posAnimal = new Animal[r][c]; // 2-dimensional array of Animal class with the size of row and column
    ArrayList<Animal> zebra = new ArrayList<Animal>();  // Zebra arrayList
    ArrayList<Animal> cheetah = new ArrayList<Animal>(); //Cheetah arrayList
    int numAnimals;
    int numCheetah;
    int numZebra;
    int eatenZebra = 0;


    public void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of animals");
        numAnimals = scan.nextInt();                          //prompt to enter total number of animals
        numCheetah = random.nextInt((numAnimals / 2)) + 1;    // initializing with random number of Cheetah
        numZebra = (numAnimals - numCheetah);                 //initializing with random number of Zebra
        System.out.println("Zebra:" + numZebra);
        System.out.println("Cheetah:" + numCheetah);
    }

    private void initializeMap() {
        int countCheetah = 0;
        int countZebra = 0;

        //Filling the map with Cheetahs
        do {
            int x = random.nextInt(r);
            int y = random.nextInt(c);
            if (posAnimal[x][y] == null) {
                posAnimal[x][y] = new Cheetah(x, y, r, c);
                cheetah.add(posAnimal[x][y]);
                countCheetah++;
            }
        } while (countCheetah != numCheetah);

        //filling the map with Zebras
        do {
            int x = random.nextInt(r);
            int y = random.nextInt(c);
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
            if (zebra.size() < cheetah.size() || isAllCheetahFull()) {
                System.out.printf("%d Zebra died", eatenZebra);
                break;
            }
            System.out.println();
        }
    }


    private void moveCheetah() {
        for (int i = 0; i < cheetah.size(); i++) {
            cheetah.get(i).move();
        }
        // Checking cheetah moving on cheetah by checking coordinate x and y
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

        // checking Cheetah's move on Zebra by checking coordinates and check if Cheetah is not full
        for (int i = 0; i < cheetah.size(); i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (cheetah.get(i).getX() == zebra.get(j).getX() && cheetah.get(i).getY() == zebra.get(j).getY() && !cheetah.get(i).isFull()) {
                    System.out.printf("zebra:%d died%n ", j);
                    zebra.remove(zebra.get(j));
                    eatenZebra++;
                    cheetah.get(i).setFull(true);
                    System.out.printf("Cheetah:%d is full%n", i);
                }
            }
        }
        //checking Cheetah's move on Zebra if Cheetah is full
        for (int i = 0; i < cheetah.size(); i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (cheetah.get(i).getX() == zebra.get(j).getX() && cheetah.get(i).getY() == zebra.get(j).getY() && cheetah.get(i).isFull()) {
                    cheetah.get(i).setX(cheetah.get(i).getOldX());
                    cheetah.get(i).setY(cheetah.get(i).getOldY());
                }
            }
        }

    }

    //checking if all cheetahs are full
    public boolean isAllCheetahFull() {
        for (int i = 0; i < cheetah.size(); i++) {
            if (!cheetah.get(i).isFull()) {
                return false;
            }
        }
        return true;
    }

// moving zebras and checking their coordinates with other zebras and Cheetahs
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
                }
            }
        }
    }

// updating map after cheetah and Zebra move
    private void updateMap() {
        for (int i = 0; i < r; i++) {        //reset the map by making all position null
            for (int j = 0; j < c; j++) {
                posAnimal[i][j] = null;
            }
        }
        for (int i = 0; i < zebra.size(); i++) {   //reset Zebras positions
            int x = zebra.get(i).getX();
            int y = zebra.get(i).getY();
//            if (posAnimal[x][y] != null) {
//                System.out.println("Update zebra: Animal at position: " + x + " "+ y + " " + posAnimal[x][y].toString() + " New animal " + zebra.get(i).toString());
//            }
            posAnimal[x][y] = zebra.get(i);
        }
        for (int i = 0; i < cheetah.size(); i++) {   //reset Cheetahs positions
            int x = cheetah.get(i).getX();
            int y = cheetah.get(i).getY();
//            if (posAnimal[x][y] != null) {
//                System.out.println("Update cheetah: Animal at position: " + x + " " + y + " " + posAnimal[x][y].toString()  + " New animal " + cheetah.get(i).toString());
//            }
            posAnimal[x][y] = cheetah.get(i);
        }
    }
// printing the map after every updates
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

