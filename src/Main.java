import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(9,4,15,300,false);
        //test loop;
        String test0 = "wwwwwwwwwwwwww";
        String test1 = "ddddddddddddddd";
        String test2 = "aaaaaaaaaaaaaa";
        String test3 = "ssssssssssssss";
        while(true) {
            dungeon.printDungeon();
            System.out.println("giving command");
            dungeon.executeCommands(dungeon.takeCommand(new Scanner(System.in).nextLine()));

       }

    }
}
