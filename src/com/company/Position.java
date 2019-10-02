package com.company;

public interface Position {

     int dirUp = 0;
     int dirRight = 1;
     int dirDown = 2;
     int dirLeft = 3;

     String toString();
     void move();
}
