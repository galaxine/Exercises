import gui.Addition;
import gui.PanelMenu;
import gui.Reset;
import gui.Subtraction;
import logic.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calculator = new Calculator();
    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400,400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        JTextField first = new JTextField("0");
        first.setEnabled(false);
        JTextField second = new JTextField();
        PanelMenu menu = new PanelMenu(calculator);
        Addition add = new Addition(first, second, calculator);
        menu.getPlus().addActionListener(add);
        Subtraction subtraction = new Subtraction(first, second, calculator);
        menu.getMinus().addActionListener(subtraction);
        EventHandler event = new EventHandler(menu,"menu.getReset()","menu.setReset()","add");
        Reset reset = new Reset(first,second,calculator);
        menu.getReset().;

        container.add(first);
        container.add(second);
        container.add(menu);
        container.setLayout(layout);

    }

    public JFrame getFrame() {
        return frame;
    }
}
