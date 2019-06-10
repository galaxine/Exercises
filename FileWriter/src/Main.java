import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line: t.read("src/testinput1.txt")) {
            System.out.println(line);

        }
        t.save("src/testinput1.2.txt", "perkele \n merkele \n ormssadfnsadfsdf");
        for (String line: t.read("src/testinput1.2.txt")) {
            System.out.println(line);
        }
    }
}
