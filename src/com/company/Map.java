package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.ZipFile;

public class Map {
    Random random = new Random();
    private final int r = 5;
    private final int c = 5;
    //private int[][] position = new int[r][c];
    private Animal[][] posAnimal = new Animal[r][c];
    ArrayList<Animal> zebra = new ArrayList<Animal>();
    // Animal[] zebra;
    Animal[] cheetah;
    int numAnimals;
    int numCheetah;
    int numZebra;
    int[] oldX;
    int[] oldY;

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
        //zebra = new Zebra[numZebra];
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

        moveCheetah();
        moveZebra();
        updateMap();
    }

    private void moveCheetah() {
        for (int i = 0; i < cheetah.length; i++) {
            cheetah[i].move();
        }
        for (int i = 0; i < cheetah.length; i++) {
            for (int j = 0; j < zebra.size(); j++) {
                if (cheetah[i].getX() == zebra.get(j).getX() && cheetah[i].getY() == zebra.get(j).getY() && cheetah[i].isFull() == false) {
                    zebra.remove(zebra.get(j));
                    System.out.println("zebra died");
                    cheetah[i].setFull(true);
                    System.out.printf("Full: %b%n", cheetah[i].isFull());
                }
            }
            for (Animal z : zebra) {
                System.out.print("\n" + z + "\t");
            }
        }
    }

    private void moveZebra() {
//        ArrayList<Animal> zeb = new ArrayList<>(Arrays.asList(zebra));
//               zebra = zebra.toArray(new Zebra[zebra.size()]);
//        oldX = new int[zebra.size()];
//        oldY = new int[zebra.size()];
//
//        for (int i = 0; i < zebra.size(); i++) {
//            oldX[i] = zebra.get(i).getX();
//            oldY[i] = zebra.get(i).getY();
//        }


        for (int i = 0; i < zebra.size(); i++) {
            zebra.get(i).move();

        }

//        for (int i = 0; i < zebra.size(); i++) {
//            if ((posAnimal[zebra.get(i).getX() - 1][zebra.get(i).getY()] != null)){
//                zebra.get(i).move();
//                if(zebra.get(i).getDir()==Position.dirUp){
//                    zebra.get(i).setX(zebra.get(i).getX()+1);
//                }
//            }
//            if ((posAnimal[zebra.get(i).getX()][zebra.get(i).getY()+1] != null)){
//                zebra.get(i).move();
//                if(zebra.get(i).getDir()==Position.dirRight){
//                    zebra.get(i).setY(zebra.get(i).getY()-1);
//                }
//            }
//            if ((posAnimal[zebra.get(i).getX()+1][zebra.get(i).getY()] != null)){
//                zebra.get(i).move();
//                if(zebra.get(i).getDir()==Position.dirDown){
//                    zebra.get(i).setX(zebra.get(i).getX()-1);
//                }
//            }
//
//        }

        for (int i = 0; i < zebra.size(); i++) {
            for (int j = 0; j < cheetah.length; j++) {
                if (zebra.get(i).getX() == cheetah[j].getX() && zebra.get(i).getY() == cheetah[j].getY()) {
                    zebra.remove(zebra.get(i));
                    System.out.println("zebra died again");
                }
            }
        }
        for (Animal z : zebra) {
            System.out.print(z + "\t");
        }
        System.out.println();

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
        for (int i = 0; i < zebra.size(); i++) {
            posAnimal[zebra.get(i).getX()][zebra.get(i).getY()] = zebra.get(i);
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

    public Animal[] getCheetah() {

        return cheetah;
    }

}

