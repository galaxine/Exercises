
/*Todo the collections for taking out the dead vampires doesn't work.
*  I assume this is a problem with the equals and hashcode implementation*/


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

    // i use this to differentiate. if the vampire object is the same as with the
    // other objects in the ArrayList in Dungeon, then we can make a new one that
    // is individualistic in coordinates.

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Vampire compare = (Vampire) o;

        if(this.getY() != ((Vampire) o).getY() ){
            if(this.getX() != getX()) {
                return false;
            }
        }

        return true;
    }

    //i am not so sure if this is needed right now.
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public String toString() {
        return getVampire() + " " +  getX() + " " + getY();
    }
}
