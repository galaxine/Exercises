package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addition implements ActionListener {
    private JTextField first;
    private JTextField second;

    public Addition(JTextField first, JTextField second) {
        this.first = new JTextField();
        this.second = new JTextField();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        first.setText(this.second.getText());
    }
}
