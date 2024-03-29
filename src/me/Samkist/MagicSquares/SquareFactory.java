package me.Samkist.MagicSquares;

import BreezySwing.Format;

import javax.swing.*;


public class SquareFactory {
    private int[][] square;
    private int size;
    private JLabel[][] tempLabels;
    private MagicSquareGUI gui;
    private int starter;

    public SquareFactory(int size, int starter, MagicSquareGUI gui) {
        this.size = size;
        this.gui = gui;
        this.starter = starter;
        square = new int[size][size];
        populateArray();
    }

    public int[][] getSquare() {
        return square;
    }

    public int getSize() {
        return size;
    }

    public JLabel[][] getTempLabels() {
        return tempLabels;
    }


    public void populateArray() {
        int currentX, currentY;
        currentX = size/2;
        currentY = 0;
        int editedStarter = starter -1;
        for(int i = 1; i <= size*size; i++) {
            square[currentX][currentY] = i + editedStarter;
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
