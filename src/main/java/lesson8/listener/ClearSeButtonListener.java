package lesson8.listener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearSeButtonListener implements ActionListener {
    private JTextField resultField;

    public ClearSeButtonListener(JTextField resultField) {
        this.resultField = resultField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultField.setText("");
    }
}
