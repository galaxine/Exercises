package logic;

import javax.swing.*;

public class NumberChecker {
    JButton button;
    Calculator calc;

    public NumberChecker(JButton button, Calculator calc) {
        this.button = button;
        this.calc = calc;
    }

    public JButton setButton() {
        if (this.calc.getSum() !=0) {
            this.button.setEnabled(true);
        } else {
            this.button.setEnabled(false);
        }
        return this.button;
    }
}
