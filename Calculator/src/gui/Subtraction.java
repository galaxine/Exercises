package gui;

import logic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subtraction implements ActionListener {
    private Calculator calc;
    private JTextField first;
    private JTextField second;

    public Subtraction(JTextField first, JTextField second, Calculator calc) {
        this.first = first;
        this.second = second;
        this.calc = calc;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     *
    **/
    @Override
    public void actionPerformed(ActionEvent e) {
        calc.decrementByN(Integer.parseInt(second.getText()));
        first.setText(String.valueOf(calc.getSum()));
    }

    public boolean isZero (Calculator calc) {
        if (calc.getSum() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
