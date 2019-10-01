package me.Samkist.MagicSquares;

import BreezySwing.Format;
import com.sun.javafx.collections.ElementObservableListDecorator;
import sun.java2d.DisposerTarget;

import javax.swing.*;


public class SquareFactory {
    private volatile int[][] square;
    private int size;

    public SquareFactory(int size) {
        this.size = size;
        square = new int[size][size];
        populateArray();
        System.out.println(getSquareString());
    }



    public String getSquareString() {
        String squareString = "";
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                squareString += Format.justify('c', square[j][i], 4);
            }
            squareString += '\n';
        }
        return squareString;
    }

    public void populateArray() {
        int currentX, currentY;
        currentX = size/2;
        currentY = 0;
        for(int i = 1; i <= size*size; i++) {
            square[currentX][currentY] = i;
            //Checks top
            if(currentX+1 > size-1 && currentY-1 < 0) {
                currentY++;
            } else if(currentY-1 < 0) {

                currentX++;
                currentY = size-1;
            } else if(currentX+1 > size-1) {
                currentY--;
                currentX = 0;
            } else if(square[currentX+1][currentY-1] != 0) {
                currentY++;
            } else {
                currentX++;
                currentY--;
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.println(i + "," + j + " --> " + square[i][j]);
            }
        }
    }
}
