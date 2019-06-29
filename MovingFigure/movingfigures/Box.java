import java.awt.*;

public class Box extends Figure {
    private int length;
    private int height;

    public Box(int x, int y, int height, int length) {
        super(x, y);
        this.height =height;
        this.length = length;
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(getX(), getY(), height, length);
    }
}
