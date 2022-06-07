import java.util.IllegalFormatException;
import java.util.Scanner;
public class DragonCave {

    // static class variables
    static int caveNum;
    static final int firstCave = 1;
    static final int secondCave = 2;
    static boolean flag;
    static Scanner scannerObj = new Scanner(System.in); // Scanner object

    // method: to accept the user input
    /*
    selectCave : accept the cave number from the user
     */
    static int selectCave ( ) throws NumberFormatException, IllegalStateException {
        int res;

        res = Integer.parseInt( scannerObj.next() );

        return res;

    } // end selectCave


    // main method to start the program
    public static void main(String [] args){


        do {
            flag = false;

            System.out.println("Which cave will you go into? (1 or 2)");
            try {
                caveNum = selectCave( );
            } catch ( Exception e ){
                System.out.println("Only number 1 or number 2\n");
                flag = true;
                continue;
            }
            if ( caveNum != firstCave && caveNum != secondCave ){
                flag = true;
                System.out.println( "Only Cave 1 or Cave 2\n");
            }

        } while ( flag );

        if ( caveNum == firstCave ) {
            System.out.println("You approach the cave... \n" +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you, and says 'Welcome buddy!!!' ");

        } else if ( caveNum == secondCave ) {
            System.out.println("You approach the cave... \n" +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you! \n" +
                    "Gobbles you down in one bite! ");

        }
        scannerObj.close();

    }

}
