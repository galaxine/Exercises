package clicker.ui;

import clicker.applicationLogic.Calculator;
import clicker.applicationLogic.PersonalCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    private Calculator calc;
    private JLabel label;
    public ClickListener(Calculator calc, JLabel label) {
        this.calc = calc;
        this.label = label;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        calc.increase();
        String text = String.valueOf(calc.giveValue());
        label.setText(text);
    }
}