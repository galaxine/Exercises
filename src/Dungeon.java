import java.util.ArrayList;
import java.util.Scanner;

/*Todo 1. create a test playground.
         2. make the player move around.
         3. test that the player can not move outside.
         4. test that the vampires can move freely inside the dungeon randomly.
         5. test that the vampires do not collide with each other.
         6. test that the vampires can be removed if the player collides with them.
         7. test that turn based movement works. Vampires move one turn
          after the player moves one turn.
         8. test that the lamp works.
         9. test that the terminal gui looks as intended.
         10. test that the conditions for losing or winning the game is valid.
   */
public class Dungeon {
    private  boolean vampireMove;
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private char[][] dungeon;
    private Player player = new Player();
    Scanner scanner = new Scanner(System.in);
    //constructor for testing
    public Dungeon(int length, int height) {
        this.length = length;
        this.height = height;
        dungeon = new char[length][height];
    }

    //constructor taking the size of the dungeon, amount of vampires and their right to move or not
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampireMove = vampiresMove;
        dungeon = new char[length][height];
    }
    //runs the game.
    public void run() {

    }
    private void buildDungeon() {
        // first create the dungeon in a double array char
        for (int i = 0; i < (height - 1); i++) {
            for (int j = 0; j < (length - 1); j++) {
                dungeon[i][j] = '.';
            }
        }
            dungeon[player.getX()][player.getY()] = player.getAt();
    }

    public void printDungeon() {
        buildDungeon();
        // second: print the dungeon
        for (int i = 0; i < (height-1); i++) {
            for (int j = 0; j < (length-1); j++) {
                System.out.print(dungeon[i][j]);
            }
            System.out.println();
        }
    }

    public ArrayList<Character> takeCommand(String command){
        ArrayList<Character> commands  = new ArrayList<Character>();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) != 'w' && command.charAt(i) != 'a' &&
            command.charAt(i) != 's' && command.charAt(i) != 'd') {
            } else {
                commands.add(command.charAt(i));
            }
        } return commands;
    }

    /**
     *
     * @param commands
     */
    public void executeCommands(ArrayList<Character> commands) {
        if (!commands.isEmpty()) {
            for (char command :
                    commands) {
                switch (command) {
                    case 'a':
                        if (player.getY() > 0) {
                            player.setY(player.getY() - 1);
                        }
                        break;
                    case 'd':
                        if (player.getY() < (height - 1)) {
                            player.setY(player.getY() + 1);
                        }
                        break;
                    case 's':
                        if (player.getX() < (length - 1)) {
                            player.setX(player.getX() + 1);
                        }
                        break;
                    case 'w':
                        if (player.getX() > 0) {
                            player.setX(player.getY() - 1);
                        }
                        break;
                }
            }
        }
    }
//redundant on second thought.
    public void playerWallLogic(int x, int y) {

    }
        /*
           1. if the player position is higher than the length and height, then let the player take the height and length as the position.
           2. if the player is lower than (0, 0) than just take that as the coordinate.
           3. else take the coordinates.
         */
}
