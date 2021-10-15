package lesson8.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonListener implements ActionListener {
    private JTextField resultField;

    public CalcButtonListener(JTextField resultField) {
        this.resultField = resultField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String string = resultField.getText();

        String result = "Error";
        try {
            int operatorIndex = findOperatorPosition(string);

            String left = string.substring(0, operatorIndex);
            String right = string.substring(operatorIndex + 1);
            final char operator = string.charAt(operatorIndex);

            switch (operator) {
                case '+':
                    result = String.valueOf(Long.parseLong(left) + Long.parseLong(right));
                    break;
                case '-':
                    result = String.valueOf(Long.parseLong(left) - Long.parseLong(right));
                    break;
                case '*':
                    result = String.valueOf(Long.parseLong(left) * Long.parseLong(right));
                    break;
                case '/':
                    result = String.valueOf(Long.parseLong(left) / Long.parseLong(right));
                    break;
                case '√':
                    result = String.valueOf(Math.sqrt(Double.parseDouble(left)));
                    break;
                case '%':
                    result = String.valueOf(Double.parseDouble(left) / 100 * Double.parseDouble(right));
                    break;
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Error");
            return;
        }

        resultField.setText(resultField.getText() + "=" + result);
    }

    private int findOperatorPosition(String string) {
        char[] ca = {'+', '-', '*', '/', '√', '%'};
        for (int i = 0; i < ca.length; i++) {
            int index = string.indexOf(ca[i]);
            if (index > 0) {
                return index;
            }
        }
        return -1;
    }
}
