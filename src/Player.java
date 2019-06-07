import java.util.Scanner;

/*Todo 1.Player has a coordinate
       2.Player has movement
       3.Player has a movement lock (turn based)
       3.Player has a look (char)
       4.And a state of being alive or dead.
 */
public class Player {
    private int x = 0;
    private int y = 0;
    private boolean moves = true;
    private char at = '@';
    private boolean alive = true;
    private Scanner scanner = new Scanner(System.in);
    //first as  a test without the lamp class.
    public Player () {

    }

    /**
     *
     * @return the x coordinate of the player
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return the y coordinate of the player
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return the player character visual
     */
    public char getAt() {
        return at;
    }

    /**
     *
     * @return returns wether it is alive opr not
     */
    public boolean isAlive() {
        return alive;
    }

    public void playerDies(Lamp lamp) {
        if (lamp.getTimer()>0) {
            lamp.lampTimer();
        }
        if(lamp.getTimer()==0){
            alive = false;
        }
    }

    public String toString() {
        return getAt() + " " + getX()
 + " " + getY();
    }
}
