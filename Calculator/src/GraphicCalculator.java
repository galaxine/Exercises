<<<<<<< HEAD
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
=======
import javax.swing.*;
import java.awt.*;


public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private int numbers =0;
    private Addition add;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setSize(new Dimension (400,400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

>>>>>>> calculator
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
<<<<<<< HEAD
        GridLayout layout = new GridLayout(3,1);
        JTextField first = new JTextField("0");
        first.setEnabled(false);
        JTextField second = new JTextField();
        PanelMenu menu = new PanelMenu(calculator);
        Addition add = new Addition(first, second, calculator, menu);
        menu.getPlus().addActionListener(add);
        Subtraction subtraction = new Subtraction(first, second, calculator, menu);
        menu.getMinus().addActionListener(subtraction);
        Reset reset = new Reset(first,second,calculator,menu);
        menu.getReset().addActionListener(reset);

        container.add(first);
        container.add(second);
        container.add(menu);
        container.setLayout(layout);
=======
>>>>>>> calculator

    }

    public JFrame getFrame() {
        return frame;
    }
}
