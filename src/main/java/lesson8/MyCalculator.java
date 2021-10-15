package lesson8;

import lesson8.listener.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame {

    private JTextField resultField = new JTextField();

    private final ActionListener buttonListener = new ButtonListener(resultField);
    private final CalcButtonListener calcButtonListener = new CalcButtonListener(resultField);
    private final CalcSeButtonListener calcSeButtonListener = new CalcSeButtonListener(resultField);
    private final ClearSeButtonListener clearSeButtonListener = new ClearSeButtonListener(resultField);

    public MyCalculator() {
        setTitle("Test Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setJMenuBar(createMenu());
        setLayout(new BorderLayout());
        add(createTop(), BorderLayout.NORTH);
        add(createButton(), BorderLayout.CENTER);


        setVisible(true);


    }

    private JPanel createButton() {

        JPanel button = new JPanel();
        button.setLayout(new BorderLayout());


        // Цифры
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 10; i++) {
            String buttonName = (i == 10) ? "0" : String.valueOf(i);
            JButton btn = new JButton(buttonName);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }
        button.add(digitsPanel, BorderLayout.CENTER);

        // Операторы
        JPanel advPanel = new JPanel();
        advPanel.setLayout(new GridLayout(4, 2));

        JButton clear = new JButton("C");
        clear.addActionListener(clearSeButtonListener);
        advPanel.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(calcButtonListener);
        advPanel.add(calc);

        JButton calcSe = new JButton("==");
        calcSe.addActionListener(calcSeButtonListener);
        advPanel.add(calcSe);

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        advPanel.add(minus);

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        advPanel.add(plus);

        JButton multiplication = new JButton("*");
        multiplication.addActionListener(buttonListener);
        advPanel.add(multiplication);

        JButton division = new JButton("/");
        division.addActionListener(buttonListener);
        advPanel.add(division);

        JButton percent = new JButton("%");
        percent.addActionListener(buttonListener);
        advPanel.add(percent);

        JButton radical = new JButton("√");
        radical.addActionListener(buttonListener);
        advPanel.add(radical);


        button.add(advPanel, BorderLayout.WEST);


        return button;

    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        resultField.setEditable(false);
        top.add(resultField);

        return top;
    }

    private JMenuBar createMenu() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));

        JMenuItem clear = menu.add(new JMenuItem("Clear"));
        clear.addActionListener(new ClearSeButtonListener(resultField));

        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonListener());
        return menuBar;
    }
}
