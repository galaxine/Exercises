import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable{

    public JFrame frame;

    public UserInterface() {

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
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200,300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel you = new JLabel("Are you?");

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);

        JLabel fun = new JLabel("Why?");
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton cuz = new JRadioButton("Because it is fun!");
        ButtonGroup group1 = new ButtonGroup();
        JButton click = new JButton("Done!");
        group1.add(noReason);
        group1.add(cuz);
        container.add(you);
        container.add(yes);
        container.add(no);
        container.add(fun);
        container.add(noReason);
        container.add(cuz);
        container.add(click);
    }

    public JFrame getFrame() {
        return frame;
    }
}

