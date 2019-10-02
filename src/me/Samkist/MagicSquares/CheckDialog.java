/* Created By: Sam Pizette
 * On Date: 10/2/2019
 * Project Name: MagicSquare
 */
package me.Samkist.MagicSquares;

import BreezySwing.GBDialog;
import BreezySwing.IntegerField;

import javax.swing.*;

public class CheckDialog extends GBDialog {

    private JComboBox dropDown = addComboBox(1, 1, 1, 1);
    private JButton buildFields = addButton("Build Fields", 2, 1 ,1, 1);
    private JTextField[][] tempFields;
    private boolean fieldsExist = false;


    public CheckDialog(JFrame jFrame) {
        super(jFrame);
        dropDown.addItem("2x2");
        dropDown.addItem("3x3");
        dropDown.addItem("4x4");
        dropDown.addItem("5x5");
        dropDown.addItem("6x6");
        dropDown.addItem("7x7");
        dropDown.addItem("8x8");
        dropDown.setSelectedIndex(1);
    }

    @Override
    public void buttonClicked(JButton jButton) {
        if(jButton.equals(buildFields)) {
            if(fieldsExist)
                clearFields();
            generateFields();
        }
    }

    public void clearFields() {
        for(JTextField field[] : tempFields) {
            for(JTextField sfield : field) {
                remove(sfield);
            }
        }
    }

    public void generateFields() {
        fieldsExist = true;
        int tableSize = dropDown.getSelectedIndex() + 2;
        tempFields = new JTextField[tableSize][tableSize];
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize; j++) {
                JTextField tempField = addTextField("", 2 + i, j+2, 1, 1);
                tempFields[i][j] = tempField;
            }
        }

        switch(dropDown.getSelectedIndex()) {
            case 0:
                setSize(400, 400);
                break;
            case 1:
                setSize(450, 450);
                break;
            case 2:
                setSize(500, 500);
                break;
            case 3:
                setSize(550, 550);
                break;
            case 4:
                setSize(600, 600);
                break;
            case 5:
                setSize(650, 650);
                break;
            case 6:
                setSize(700, 700);
                break;
        }

    }
}
