package gui;

import logic.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Addition implements ActionListener {
    private Calculator calc;
    private JTextField first;
    private JTextField second;
    private PanelMenu menu;

    public Addition(JTextField first, JTextField second, Calculator calc, PanelMenu menu) {
        this.first = first;
        this.second = second;
        this.calc = calc;
        this.menu = menu;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            calc.incrementByN(Integer.parseInt(second.getText()));
            first.setText(String.valueOf(calc.getSum()));
            second.setText("");
            if (calc.getSum() != 0) {
                menu.getReset().setEnabled(true);
            } else {
                menu.getReset().setEnabled(false);
            }
        } catch (NumberFormatException m) {
            second.setText("");
        }
    }

}


