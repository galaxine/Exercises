package clicker.ui;

import clicker.applicationLogic.Calculator;
import clicker.applicationLogic.PersonalCalculator;

import javax.swing.*;
import java.awt.*;

public class UserInterface  implements  Runnable{
    private JFrame frame;
    private PersonalCalculator calc;

    public UserInterface() {
        calc = new PersonalCalculator();
    }
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
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200,100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    public void createComponents(Container cont) {
        GridLayout layout = new GridLayout(2,1);
        cont.setLayout(layout);
        JLabel countShow = new JLabel(String.valueOf(calc.giveValue()));
        JButton count = new JButton(("Click!"));
        ClickListener listener = new ClickListener(calc, countShow);
        count.addActionListener(listener);
        cont.add(countShow);
        cont.add(count);
    }

    public JFrame getFrame() {
        return frame;
    }
}
