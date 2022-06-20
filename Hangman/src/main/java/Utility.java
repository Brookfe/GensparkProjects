import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

    // list of words
    public static ArrayList<String> words = new ArrayList<String>();


    /*
    randomWordGen: method to import words from the words file
    */
    public static void importWords (  ) {

        try {
            Scanner scannerObj = new Scanner( new File( "src/main/resources/words.txt" ) );
            while ( scannerObj.hasNext() ) {
                words.add( scannerObj.nextLine() );
            }

        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }

    } // end randomeNumGen




} // end Utility
