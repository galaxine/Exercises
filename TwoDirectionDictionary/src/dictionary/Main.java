package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MindfulDictionary s = new MindfulDictionary("src/words.txt");
        s.load();
        s.translate("olut");
        s.save();
    }
}
