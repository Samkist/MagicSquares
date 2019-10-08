package me.Samkist.MagicSquares;

import BreezySwing.GBDialog;

import javax.swing.*;

public class SquareDialog extends GBDialog {

    private SquareFactory factory;

    public SquareDialog(JFrame frame, SquareFactory factory) {
        super(frame);
        this.factory = factory;
        buildSquare();
    }

    public void buildSquare() {
        try {
            for (JLabel[] tmpLabels : factory.getTempLabels()) {
                for (JLabel tmpLabel : tmpLabels) {
                    remove(tmpLabel);
                }
            }
        } catch(Exception e) {

        }
        for(int i = 1; i <= factory.getSize(); i++) {
            for(int j = 1; j <= factory.getSize(); j++) {
                JLabel tempLabel = addLabel("" + factory.getSquare()[j-1][i-1], j, i, 1, 1);
                System.out.println("adding " + i + " " + j);
            }
        }
        setSize(getWidth() + 1, getHeight() + 1);
        setSize(getWidth() -1, getHeight() -1);
    }


}
