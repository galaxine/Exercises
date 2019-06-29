import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Figure figure;
    private Component board;

    public KeyboardListener (
            Component component, Figure figure) {
        this.figure = figure;
        this.board = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            figure.move(0, -1);

            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            figure.move(0, 1);

            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            figure.move(-1 , 0 );

            board.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            figure.move(1,0);

            board.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
