package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int count = 0;
        int[][] pos = new int[10][10];
        Map map = new Map(10);
        pos = map.startPosition();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d  ", pos[i][j]);

            }
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (pos[i][j] != 0) {
                    count++;

                }
            }
        }
        System.out.println(count);
        for(Animal a: map.getAnimal()){
            System.out.println(a);
        }

    }
}
