package me.Samkist.MagicSquares;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

import javax.swing.*;

public class MagicSquareGUI extends GBFrame {

    private static JFrame frame = new MagicSquareGUI();
    private IntegerField numberField = addIntegerField(0, 1, 1, 1,1 );
    private JButton createSquare = addButton("Create Square", 3, 1, 1, 1);
    private JButton checkSquare = addButton("Check Square", 4, 1 ,1, 1);
    private IntegerField startingNumber = addIntegerField(0, 1, 2, 1, 1);
    private SquareFactory squareFactory;
    private CheckDialog checkDialog = new CheckDialog(frame);
    private SquareDialog squareDialog;
    private JLabel squareSize = addLabel("Square Size", 2,1,1, 1);
    private JLabel startingNumberLabel = addLabel("Starting Number", 2, 2, 1, 1);

    public static void main(String[] args) {
        frame.setTitle("Magic Squares");
        frame.setSize(400, 400);
        frame.setVisible(true);
    }


    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(createSquare) && !(errorCheck())) {
            if(numberField.getNumber() % 2 == 0) {
                messageBox("Please enter an odd number. This function does not support even numbers.");
                return;
            } else if(numberField.getNumber() <= 0) {
                messageBox("Please enter a positive integer. This function does not support negative numbers.");
                return;
            }
            squareFactory = new SquareFactory(numberField.getNumber(), startingNumber.getNumber(), this);
            squareDialog = new SquareDialog(this, squareFactory);
            squareDialog.setVisible(true);
        }
        if(jButton.equals(createSquare) && errorCheck())
            messageBox("Invalid Data! Please try again.");
        if(jButton.equals(checkSquare)) {
            checkDialog.setVisible(true);
        }
    }

    private boolean errorCheck() {
        if(!(numberField.isValidNumber()) || !(startingNumber.isValidNumber())) {
            return true;
        }
        return false;
    }
}
