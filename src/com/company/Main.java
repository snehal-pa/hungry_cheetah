package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    int count = 0;

    public static void main(String[] args) {
        int[][] pos = new int[10][10];

        Map map = new Map(3);
        pos = map.getPosition();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d  ", pos[i][j]);

            }
            System.out.println();
        }

        for (Animal a : map.getAnimal()) {
            System.out.println(a);
            System.out.printf("%d    %d%n", a.getX(), a.getY());
            System.out.printf("%d    %d%n", a.getX() + 1, a.getY());
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.printf("%d  ", pos[i][j]);
                }
                System.out.println();
            }
        }
    }

}
