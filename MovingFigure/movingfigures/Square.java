import java.awt.*;

public class Square extends Figure {
    private int sidelength;

    public Square(int x, int y, int sidelength) {
        super(x, y);
        this.sidelength = sidelength;
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(getX(), getY(), sidelength, sidelength);
    }
}
