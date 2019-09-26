package com.company;

import java.util.Random;

public class Map {
    int x, y;
    Random random = new Random();
    private int[][] position = new int[10][10];
    Animal[] animal;

    //constructor
    public Map(int animals) {
        animal = new Animal[animals];

    }

    public int[][] startPosition() {
        int noCheetah = random.nextInt((animal.length / 2)) + 1;
        int noZebra = (animal.length - noCheetah);
        int countCheetah = 0;
        int countZebra =0;
        do{
            int j = random.nextInt(100) ;
            int row = j / 10;
            int col = j % 10;
            //System.out.printf("%d  %d%n", row, col);
            if (position[row][col] == 0) {
                position[row][col]=1;
                animal[countCheetah] = new Cheetah(row,col);
                countCheetah++;
            }

        }while(countCheetah!=noCheetah);
        do{
            int j = random.nextInt(100) ;
            int row = j / 10;
            int col = j % 10;
            //System.out.printf("%d  %d%n", row, col);
            if (position[row][col] == 0) {
                position[row][col]=2;
                animal[countCheetah] = new Zebra(row,col);
                countZebra++;
                countCheetah++;
            }
        }while(countZebra!=noZebra);
        return position;
    }
    public Animal[] getAnimal(){
        return animal;
    }

}
