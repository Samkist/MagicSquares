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
    private JButton checkFields = addButton("Check Fields", 3, 1, 1, 1);
    private IntegerField[][] tempFields;
    private boolean fieldsExist = false;
    private int tableSize = 0;


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

        if(jButton.equals(checkFields)) {
            messageBox(checkFields());
        }
    }

    private boolean errorCheck() {
        for(IntegerField[] field : tempFields) {
            for(IntegerField sfield : field) {
                if(!(sfield.isValidNumber()))
                    return true;
            }
        }
        return false;
    }

    private String checkFields() {
        String incorrect = "Incorrect Square";
        String correct  = "Square is Correct";
        int correctValue = 0;
        for(int i = 0; i < tableSize; i++) {
                correctValue += Integer.parseInt(tempFields[0][i].getText());
        }

        for(int i = 1; i < tableSize; i++) {
            int tempIntValue = 0;
            for(int j = 0; j < tableSize; j++) {
                tempIntValue += Integer.parseInt(tempFields[i][j].getText());
            }
            if(!(tempIntValue == correctValue)) {
                System.out.println("Incorrect: 1");
                return incorrect;
            }
        }

        for(int i = 0; i < tableSize; i++) {
            int tempIntValue = 0;
            for(int j = 0; j < tableSize; j++) {
                tempIntValue += Integer.parseInt(tempFields[j][i].getText());
            }
            if(!(tempIntValue == correctValue)) {
                System.out.println("Incorrect: 2");
                return incorrect;
            }
        }
        int tempIntValue = 0;
        for(int i = 0; i < tableSize; i++) {
            tempIntValue += Integer.parseInt(tempFields[i][i].getText());
        }
        if(!(tempIntValue == correctValue)) {
            System.out.println("Incorrect: 3");
            return incorrect;
        }
/*        tempIntValue = 0;
        for(int i = tableSize - 1; i >= 0; i--) {
            for(int j = 0; j < tableSize; j++) {
                tempIntValue += Integer.parseInt(tempFields[i][j].getText());
            }
        }*/
        tempIntValue = 0;
        int i = tableSize - 1;
            for(int j = 0; j < tableSize; j++) {
                tempIntValue += Integer.parseInt(tempFields[i][j].getText());
                i--;
            }
        if(!(tempIntValue == correctValue)) {
            System.out.println(tempIntValue);
            System.out.println(correctValue);
            System.out.println("Incorrect: 4");
            return incorrect;
        }
        return correct;
    }

    public void clearFields() {
        for(IntegerField[] field : tempFields) {
            for(IntegerField sfield : field) {
                remove(sfield);
            }
        }
    }

    public void generateFields() {
        fieldsExist = true;
        tableSize = dropDown.getSelectedIndex() + 2;
        tempFields = new IntegerField[tableSize][tableSize];
        for(int i = 0; i < tableSize; i++) {
            for(int j = 0; j < tableSize; j++) {
                IntegerField tempField = addIntegerField(0, 2 + i, j+2, 1, 1);
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
