import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*Todo 1. create a test playground. DONE
         2. make the player move around. DONE
         3. test that the player can not move outside. DONE
         4. test that the vampires can move freely inside the dungeon randomly DONE ?
         5. test that the vampires do not collide with each other Done
         6. test that the vampires can be removed if the player collides with them. DONE
         7. test that turn based movement works. Vampires move one step for each player step.
           take moves: one step player, one step vampire, check for dead vampires, until the move parameter is 0
         8. test that the lamp works.
         9. test that the terminal gui looks as intended.
         10. test that the conditions for losing or winning the game is valid.
   */
public class Dungeon {
    private  boolean vampireMove;
    ArrayList<Integer> number = new ArrayList<Integer>();
    private int length;
    private int height;
    private int vampires;
    private int moves=0;
    private char[][] dungeon;
    private Player player = new Player();
    private Lamp lamp;
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
        this.lamp = new Lamp(moves);
        this.vampireMove = vampiresMove;
        dungeon = new char[height][length];
        vampireHorde = new ArrayList<Vampire>();
    }
    //runs the game.
    public void run() {
        //those are done ONCE
        buildDungeon();
        createVampireHorde();
        status();
        theHordeRepresents();
        printDungeon();
        //the dungeon updates here.
        while (true) {
            //1. take commands
            ArrayList<Character> commands = takeCommand(scanner.nextLine());
            //2. execute Command, switch boolean for vampireMoves = true
            //assign the move on this while loop afterwards, looping those instructions x times.
            moves = commands.size();
            while(moves>0) {
                executeCommands(commands.get(0));
                commands.remove(0);
                thisKillsTheVampire();
                removeVampires(vampireHorde);
                buildDungeon();
                theHordeRepresents();
                randomVampireMovement();
                thisKillsTheVampire();
                removeVampires(vampireHorde);
                buildDungeon();
                theHordeRepresents();
                moves--;
            }
            //the battery goes lower now by one
            player.playerDies(lamp);
            status();
            printDungeon();
            if(!player.isAlive() || vampireHorde.size() == 0) {
                winOrLose();
                break;
            }
        }

    }
    private void buildDungeon() {
        // first create the dungeon in a double array char
        for (int i = 0; i < (height); i++) {
            for (int j = 0; j < (length); j++) {
                dungeon[i][j] = '.';
            }
        }
            dungeon[player.getX()][player.getY()] = player.getAt();

            }

    public void printDungeon() {
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
     * @param command
     */
    //since there is now a loop for the run method, we can just as well take the ArrayList, then remove the
    public void executeCommands(char command) {
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
                }
    }
    //All vampires move once.
    public void randomVampireMovement() {
        if(vampireMove) {
            for (Vampire vamp : vampireHorde
            ) {
                int x = new Random().nextInt(4);
                number.add(x);
                switch (x) {
                    case 0:
                        //1. it wants to go up, but there is a wall.
                        //2. it wants to go up, but there is a wampire.
                        if (!(vamp.getY() - 1 < 0)) {
                            if (dungeon[vamp.getX()][vamp.getY() - 1] != 'V') {
                                vamp.setY(vamp.getY() - 1);
                            }
                        }
                        break;
                    case 1:
                        //player may not be greater than length position
                        if (vamp.getY() + 1 < (length)) {
                            if (dungeon[vamp.getX()][vamp.getY() + 1] != 'V') {
                                vamp.setY(vamp.getY() + 1);
                            }
                        }
                        break;
                    case 2:
                        if (vamp.getX() + 1 < (height)) {
                            if (dungeon[vamp.getX() + 1][vamp.getY()] != 'V') {
                                vamp.setX(vamp.getX() + 1);
                            }
                        }
                        break;
                    //at least the player shall not be under zero
                    case 3:
                        if (!(vamp.getX() - 1 < 0)) {
                            if (dungeon[vamp.getX() - 1][vamp.getY()] != 'V') {
                                vamp.setX(vamp.getX() - 1);
                            }

                        }
                        break;
                }
            }
        }

    }


    /**
     * creates the Vampirehorde as decided by the parameter vampires.
     * If the amount of vampires is greateer than the amount of tiles, then it says so.
     * If the amount is lower, we loop by the amount of the vampire parameter:
     * 1.create a new Vampire.
     * 2.assign two random coordinates to the x and y values for the vampire.
     * 3.check if the coordinates are not the same as the player and not the same as the other Vampire's Coordinates
     *      add the Vampire to the vampireHorde after setting the alive parameter for the vampire to true
     *      (I think that parameter is redundant).
     * if not, decrement and try again.
     */
    public void createVampireHorde() {
        if(vampires >= length * height) {
            System.out.println("there are more vampires than there is available space.");
        } else {
            for (int i = 0; i < vampires; i++) {

                Vampire vampire = new Vampire();
                int x = new Random().nextInt(height);
                int y = new Random().nextInt(length);
                vampire.setX(x);
                vampire.setY(y);
                if(notSameCoordinatesAsPlayer(x,y) && eachIsOne(vampire) ){
                    vampire.setAlive(true);
                    vampireHorde.add(vampire);
                    dungeon[vampireHorde.get(i).getX()][vampireHorde.get(i).getY()] = vampire.getVampire();
                } else {
                    i--;
                }

            }
        }
    }

    // mke sure that each vampire has an individual coordinate.
    public boolean eachIsOne(Vampire vamp){
        int copy = 0;
        // fi the size of the horde is zero, then there is yet to be a duplicate
        if(vampireHorde.size() == 0) {
            return true;
        }else {
            // if the size is greater than 0, we can test for duplicate locations.
            // i think it is a bit like bubble sort.
            for (Vampire vampire : vampireHorde
            ) {
                //if one vamp has the same location, it might be the same vampire we checked with.
                //we increment
                if (vampire.getX() == vamp.getX() && (vampire.getY() == vamp.getY())) {
                        return false;
                    }
                }
            }
            // else, each vampire was once an individual, full of life, before they became victim
            // to the undying thirst.
            return true;
        }

    public void theHordeRepresents() {
        for (Vampire vampir :
                vampireHorde) {
            dungeon[vampir.getX()][vampir.getY()] = vampir.getVampire();
        }
    }
    public boolean notSameCoordinatesAsPlayer(int x, int y) {
        // see if the vampire sits on the same x coordinate
        if(x == player.getX()) {
            // see if the vampire sits on the same y coordinate
            if(y == player.getY()) {
                //return false, because the vampire sits on the same coordinates as the player.
                return false;
            }
        }
        //return true because the vampire has not the same coordinates
        return true;
    }
    //method displays the current entitities' stats
    public void status() {
        System.out.println(lamp.getTimer() + "\n");
        System.out.println(player.toString());
        System.out.println();
        for (Vampire vampir :
                vampireHorde) {
            System.out.println(vampir.toString());
        }
        System.out.println();

    }
    //This method takes out every dead vampire from the horde....
    // it seems not to do so yet.
    public void removeVampires(ArrayList<Vampire> vampireHorde) {
        ArrayList<Vampire> toBeCulled = new ArrayList<Vampire>();
        for (Vampire vampir :
                vampireHorde) {
            if(!vampir.isAlive()) {
                toBeCulled.add(vampir);
            }
        }
        //this one makes problems, so the hashcode makes problems
        vampireHorde.removeAll(toBeCulled);
    }

    //every vampire's boolean for alive is set to false, if the coordinate of the vampire
    // aligns with the player's
    public void thisKillsTheVampire() {
        for (Vampire vampir :
                vampireHorde) {
            if(player.getX() == vampir.getX() && player.getY() ==vampir.getY()) {
                vampir.setAlive(false);
            }
        }
    }

    public void winOrLose() {
        if (!player.isAlive() && vampireHorde.size() > 0) {
            System.out.println("YOU LOSE");
        }
        if (vampireHorde.size() == 0) {
            System.out.println("YOU WIN");
        }
    }
}