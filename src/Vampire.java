/*Todo 1. Vampires have a random location
       2. Vampires have a look
       3. Vampires are move locked
       4. Vampires die
 */


public class Vampire {
    private int x;
    private int y;
    private char vampire = 'V';
    private boolean alive;

    public Vampire() {

    }

    public Vampire(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public char getVampire() {
        return vampire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vampire vampire = (Vampire) o;

        if (x != vampire.x) return false;
        return y == vampire.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
