package gui;

import logic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements ActionListener {
    JTextField first;
    JTextField second;
    JButton button;
    Calculator calc;

    public Reset(JTextField first, JTextField second, JButton button, Calculator calc) {
        this.first = first;
        this.second = second;
        this.calc = calc;
        this.button = button;
    }

    public Reset(JTextField first, JTextField second, Calculator calculator) {
        this.first = first;
        this.second = second;
        this.calc = calculator;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public boolean isZero (Calculator calc) {
        if (calc.getSum() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
