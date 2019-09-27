package com.company;

import java.util.Random;

public class Map {
    Random random = new Random();
    private int[][] position = new int[10][10];
    Animal[] animal;

    //constructor
    public Map(int animals) {
        animal = new Animal[animals];

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

    public void setNewPosition() {

    }

    public Animal[] getAnimal() {

        return animal;
    }

}
