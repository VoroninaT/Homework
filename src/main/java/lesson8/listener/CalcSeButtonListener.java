package lesson8.listener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcSeButtonListener implements ActionListener {
    private JTextField resultField;

    public CalcSeButtonListener(JTextField resultField) {
        this.resultField = resultField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        try {
            Object result = scriptEngine.eval(resultField.getText());
            resultField.setText(resultField.getText() + "=" + result);
        } catch (Exception ex) {
            resultField.setText("Error");
        }
    }
}
