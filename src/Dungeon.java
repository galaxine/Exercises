import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*Todo 1. create a test playground. DONE
         2. make the player move around. DONE
         3. test that the player can not move outside. DONE
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
    private ArrayList<Vampire> vampireHorde;
    Scanner scanner = new Scanner(System.in);

    //constructor for testing
    public Dungeon(int length, int height) {
        this.length = length;
        this.height = height;
        dungeon = new char[height][length];
    }

    //constructor taking the size of the dungeon, amount of vampires and their right to move or not
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampireMove = vampiresMove;
        dungeon = new char[height][length];
        vampireHorde = new ArrayList<Vampire>();
    }
    //runs the game.
    public void run() {

    }
    private void buildDungeon() {
        // first create the dungeon in a double array char
        for (int i = 0; i < (height); i++) {
            for (int j = 0; j < (length); j++) {
                dungeon[i][j] = '.';
            }
        }
            dungeon[player.getX()][player.getY()] = player.getAt();

                createVampireHorde();
                setVampireCoordination();
                theHordeRepresents();
        //    randomVampireMovement();
            }

    public void printDungeon() {
        buildDungeon();
        // second: print the dungeon
        for (int i = 0; i < (height); i++) {
            for (int j = 0; j < (length); j++) {
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
                if (moves == 0) {
                    break;
                }
                switch (command) {
                        //player may not be in a lower position than zero
                    case 'a':
                        if (!(player.getY()-1 < 0)) {
                            player.setY(player.getY() - 1);
                        }
                        break;
                    case 'd':
                        //player may not be greater than length position
                        if (player.getY()+ 1 < (length)) {
                            player.setY(player.getY() + 1);
                        }
                        break;
                    case 's':
                        if (player.getX() +1 < (height)) {
                            player.setX(player.getX() + 1);
                        }
                        break;
                        //at least the player shall not be under zero
                    case 'w':
                        if (!(player.getX()-1 <  0)) {
                            player.setX(player.getX() - 1);
                        }
                        break;
                }moves--;
            }
        }
    }
    //first test if the Vampire can take random Coordinates
    //then test if it can move freely, randomly, inside the


   /** public void randomVampireMovement() {
        int x = new Random().nextInt(3);
        switch (x) {
            case 0:
                if (!(vamp.getY()-1 < 0)) {
                    vamp.setY(vamp.getY() - 1);
                }
                break;
            case 1:
                //player may not be greater than length position
                if (vamp.getY()+ 1 < (length)) {
                    vamp.setY(vamp.getY() + 1);
                }
                break;
            case 2:
                if (vamp.getX() +1 < (height)) {
                    vamp.setX(vamp.getX() + 1);
                }
                break;
            //at least the player shall not be under zero
            case 3:
                if (!(vamp.getX()-1 <  0)) {
                    vamp.setX(vamp.getX() - 1);
                }
                break;
        }
    } */
    //first create the horde, amount determined by the vampires parameter.
    public void createVampireHorde() {
        for (int i = 0; i < vampires; i++) {
            Vampire vampire = new Vampire();
            vampire.setAlive(true);
            this.vampireHorde.add(vampire);
        }
    }
    //distribute the vampires on the map.
    public void setVampireCoordination() {
        for (int i = 0; i < vampireHorde.size(); i++) {
            int x = new Random().nextInt(length);
            int y = new Random().nextInt(height);
            //if the char dungeon coordinate is free and not vacated by a player or another Vampire, set it down.
            //TODO Problem setting individual coordinates, should have looped instead.
            if(dungeon [x][y] == '.' && !(dungeon[x][y] == '@' && dungeon[x][y]== 'V')) {
                vampireHorde.get(i).setX(x);
                vampireHorde.get(i).setY(y);
            }
            else {
                i--;
            }
        }
    }
    public void theHordeRepresents() {
        for (Vampire vampir :
                vampireHorde) {
            dungeon[vampir.getX()][vampir.getY()] = vampir.getVampire();
        }
    }

}
