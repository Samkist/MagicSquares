package me.Samkist.MagicSquares;

import javax.swing.*;

public class SquareFactory {
    private int[][] square;
    private int size;

    public SquareFactory(int size) {
        this.size = size;
        square = new int[size][size];
        populateArray();
    }

    public void populateArray() {
        int currentX, currentY;
        currentX = size/2;
        currentY = 0;
        for(int i = 1; i <= size*size; i++) {
            square[currentX][currentY] = i;
            //Checks top
            if(currentX++ > size-1 && currentY-- < 0) {
                currentY++;
            } else if(currentY-- < 0) {
                currentX++;
                currentY = size-1;
            } else if(currentX++ > size-1) {
                currentY--;
                currentX = 0;
            } else if(square[currentX][currentY] != 0) {
                currentY++;
            } else {
                currentX++;
                currentY--;
            }
/*            if(currentY-- < 0) {
                //If top right just go down
                if(currentX++ > size-1) {
                    currentY++;
                    continue;
                }
                //If on top row (not top right) move over one and go all the way down
                if(!(currentX++ > size-1)) {
                    currentY = size-1;
                    currentX++;
                    continue;
                }
            }
            //Check if the next position over goes out of bounds, goes up one row and back
            if(currentX++ > size-1) {
                currentY--;
                currentX = 0;
                continue;
            }

            //Checks if the square diagonal is occupied
            if(square[currentX+1][currentY+1] != 0) {
                currentY++;
            }*/
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.println(i + "," + j + " --> " + square[i][j]);
            }
        }
    }
}
