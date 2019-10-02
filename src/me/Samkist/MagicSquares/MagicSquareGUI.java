package me.Samkist.MagicSquares;

import BreezySwing.GBFrame;

import javax.swing.*;

public class MagicSquareGUI extends GBFrame {

    private static JFrame frame = new MagicSquareGUI();
    private JTextField numberField = addIntegerField(0, 1, 1, 1,1 );
    private JButton createSquare = addButton("Create Square", 2, 1, 1, 1);
    private JButton checkSquare = addButton("Check Square", 3, 1 ,1, 1);
    private SquareFactory squareFactory;
    private CheckDialog checkDialog = new CheckDialog(frame);

    public static void main(String[] args) {
        frame.setTitle("Magic Squares");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(createSquare))
            squareFactory = new SquareFactory(Integer.parseInt(numberField.getText()));
        if(jButton.equals(checkSquare)) {
            checkDialog.setVisible(true);
        }
    }
}
