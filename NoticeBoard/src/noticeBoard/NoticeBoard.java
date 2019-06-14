package noticeBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeBoard implements Runnable {
    private JFrame frame;

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
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);

        JTextField firstRow = new JTextField();
        JButton secondRow = new JButton("Copy!");
        JLabel thirdRow = new JLabel();
        Areacopy copier = new Areacopy(firstRow,thirdRow);
        secondRow.addActionListener(copier);

        container.add(firstRow);
        container.add(secondRow);
        container.add(thirdRow);
    }
}

class Areacopy implements ActionListener {
    private JTextField origin;
    private JLabel destiny;

    public Areacopy(JTextField origin, JLabel destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.destiny.setText(this.origin.getText());
        this.origin.setText("");
    }
}