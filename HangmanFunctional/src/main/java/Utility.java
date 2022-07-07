import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utility {

    // list of words
    public static ArrayList<String> words = new ArrayList<>();


    /*
    randomWordGen: method to import words from the words file
    */
    public static void importWords (  ) throws IOException {
        words = (ArrayList<String>) Files.readAllLines(Paths.get("src/main/resources/words.txt"));

    } // end importWords




} // end Utility
