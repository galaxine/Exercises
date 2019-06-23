package drawing.ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private DrawingBoard board;
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
        frame = new JFrame("Drawing Board");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(3);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        board = new DrawingBoard();
        container.add(board);
    }

    public JFrame getFrame() {
        return frame;
    }






}
