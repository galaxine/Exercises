package gui;

import logic.Calculator;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    private JButton plus;
    private JButton minus;
    private JButton reset;
    private Calculator calc;

    public PanelMenu(Calculator calculator) {
        super(new GridLayout(1,3));
        this.calc = calculator;
        createComponents();
    }

    private void createComponents() {
        plus = new JButton("+");
        minus = new JButton("-");
        reset = new JButton("Z");
        setReset();
        add(plus);
        add(minus);
        add(reset);
    }

    public JButton getPlus() {
        return plus;
    }

    public JButton getMinus() {
        return minus;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset () {
        if(this.calc.getSum() == 0) {
            this.reset.setEnabled(false);
        } else {
            this.reset.setEnabled(true);
        }
    }

}
