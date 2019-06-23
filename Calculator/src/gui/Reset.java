package gui;

import logic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements ActionListener {
    private JTextField first;
    private JTextField second;
    private Calculator calc;
    private PanelMenu menu;
    public Reset(JTextField first, JTextField second, Calculator calc, PanelMenu menu) {
        this.first = first;
        this.second = second;
        this.calc = calc;
        this.menu = menu;
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
        this.calc.resetSum();
        this.first.setText(String.valueOf(this.calc.getSum()));
        this.second.setText("");
        this.first.setText("0");
        this.menu.getReset().setEnabled(false);
    }

}
