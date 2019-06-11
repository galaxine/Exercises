package dictionary;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class MindfulDictionary {
    private HashMap<String, String> dict;
    private String file;
    private FileReader read;
    public MindfulDictionary(String file) {
        this.dict = new HashMap<String, String>();
        this.file = file;

    }

    public boolean load() {
        Scanner fileReader = new Scanner(file);
        if (!file.isEmpty()) {

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
            return true;
        } else  {
            return false;
        }
    }

    // translation, if the same word is added, nothing happens.
    public void add(String word, String translation) {
        if (!dict.containsKey(word)) {
            dict.put(word,translation);
        }

    }

    //returns the word translation; if the word isn't
    // recognized. retuns null otherwise
    public String translate(String word) {
        if (dict.containsKey(word)) {
            return dict.get(word);
        }
        else if (dict.containsValue(word)) {
            for (String string :
                    dict.keySet()) {
                if (dict.get(string).equals(word)) {
                    return string;
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        //remove the transaltion by the key
        if (dict.containsKey(word)) {
            dict.remove(word);
        } else if (dict.containsValue(word)) {
            for (String string: dict.keySet()
                 ) {
                if (dict.get(string).equals(word)) {
                    dict.remove(string);
                    //prevent concurrentModification exception
                    break;
                }
            }
        }
    }
}
