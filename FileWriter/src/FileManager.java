import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read (String file) throws FileNotFoundException {
        File files = new File(file);
        List<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(files);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            text.add(line);
        } return text;
    }

    public void save(String file, String text) throws IOException {
        FileWriter texts = new FileWriter(file);
        texts.write(text);
        texts.close();
    }

    public void save (String file, List<String> texts) throws IOException {

    }
}
