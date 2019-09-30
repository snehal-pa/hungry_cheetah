package com.company;

import java.util.Random;

public class Zebra extends Animal {

    public Zebra(int x, int y, int r, int c) {
        super(x, y, r, c);
    }

    public String toString() {
        return String.format("Z");
    }
}
