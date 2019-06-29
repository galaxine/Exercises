import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable  {

    private Figure figure;
    private JFrame frame;
    private DrawingBoard board;


    public UserInterface(Figure figure) {
        this.figure = figure;
    }
    @Override
    public void run() {
            frame = new JFrame();
            frame.setPreferredSize(new Dimension(
                    400, 400));

            frame.setDefaultCloseOperation(
                    WindowConstants.EXIT_ON_CLOSE);

            createComponents(frame.getContentPane());
            addListeners();

            frame.pack();
            frame.setVisible(true);
    }

    private void createComponents(Container container) {
        this.board = new DrawingBoard(figure);
        container.add(board);
    }

    private void addListeners() {
        KeyboardListener listen = new KeyboardListener(board ,figure);
        frame.addKeyListener(listen);
    }
}
