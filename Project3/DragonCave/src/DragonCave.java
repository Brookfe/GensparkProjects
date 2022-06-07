package DragonCave;

import java.util.Scanner;

public class DragonCave {

    // static class variables
    static int caveNum;
    static final int firstCave = 1;
    static final int secondCave = 2;
    static boolean flag;

    // method: to accept the user input
    /*
    selectCave : accept the cave number from the user
     */
    static int selectCave ( Scanner obj ) throws Exception {
        System.out.println("Which cave will you go into? (1 or 2)");

        return Integer.parseInt( obj.next() );

    } // end selectCave


    // main method to start the program
    public static void main(String [] args){
        Scanner scannerObj = new Scanner(System.in); // Scanner object

        do {
            flag = false;

            try {
                caveNum = selectCave( scannerObj );
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
            scannerObj.close();

        } else if ( caveNum == secondCave ) {
            System.out.println("You approach the cave... \n" +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you! \n" +
                    "Gobbles you down in one bite! ");
            scannerObj.close();
        }
    }
}
