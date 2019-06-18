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

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

    }

    public JFrame getFrame() {
        return frame;
    }
}
