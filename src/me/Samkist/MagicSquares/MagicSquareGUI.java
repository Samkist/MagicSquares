package me.Samkist.MagicSquares;

import BreezySwing.GBFrame;

import javax.swing.*;

public class MagicSquareGUI extends GBFrame {

    private static JFrame frame = new MagicSquareGUI();


    public static void main(String[] args) {
        frame.setTitle("Magic Squares");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
