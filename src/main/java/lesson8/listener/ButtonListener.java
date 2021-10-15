package lesson8.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField resultField;

    public ButtonListener(JTextField resultField) {
        this.resultField = resultField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        resultField.setText(resultField.getText() + btn.getText());

    }
}
