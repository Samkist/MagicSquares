package me.Samkist.MagicSquares;

public class SquareFactory {
    private int[][] square;
    private int size;

    public SquareFactory(int size) {
        this.size = size;
        square = new int[size][size];
    }

    public void populateArray() {
        int currentX, currentY;
        currentX = size/2;
        currentY = 0;
        for(int i = 1; i <= size*size; i++) {
            square[currentX][currentY] = i;
            if(currentY-- < 0) {
                if(currentX++ > size-1) {
                    
                }
            }
        }
    }
}
