import java.util.Scanner;

public class GuessTheNumber {
    // refactor the code

    // static class variables
    static final int max = 20;      // upper boundary
    static final int min = 1;       // lower boundary
    static final int maxTries = 6;  // maximum number of tries allowed
    static int ranNum;              // the random number generated
    static int guessNum;            // number guessed by the player
    static int tries = 1;           // number of tries
    static String name;             // player's name
    static String res;              // player's response to replay the game
    static Scanner scannerObj = new Scanner( System.in );


    /*
    genRandomNumber: generates a random number between max and min
     */
    public static int genRandomNumber( int max, int min ){
        return ((int)(Math.random()*(max - min))) + min;
    } // end genRandomNumber


    /*
    greeting: greets player
     */
    public static String greeting ( )throws Exception  {
        System.out.println("Hello! What is your name?");
        name = scannerObj.next();
        return name;
    } // end greeting

    /*
    guessNum: captures player's guess
     */
    public static int guessNum ( ) throws Exception {
        int num = Integer.parseInt( scannerObj.next() );
        return num;
    } // end guessNum


    /*
    replayGame: captures player's preference to replay the game
     */
    public  static String  replayGame ( ) throws Exception{

        System.out.println("Would you like to play again? (y or n)");

        return scannerObj.next();
    }  // end replayGame


    public static void main(String []args) {
        // Asking for name
        try {
            greeting(  );
        } catch ( Exception e ){
            System.out.println( e.getMessage() );
        }

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20\n", name);

        // Generate a number between 1 and 20
        ranNum = genRandomNumber(max, min);

        // do-while loop, print 'Take a guess'; capture the input and compare it to random
        do {
            System.out.println( "Take a guess." );
            try{
                guessNum = guessNum( );
            } catch (Exception e){
                // check if input is not a number
                System.out.println("Please input a number ");
                continue;
            }

            // check if input > 20 or input < 1
            if ( guessNum < min || guessNum > max ){
                System.out.println("Only between 1 and 20!");
                continue;
            }

            // if the guessNum is greater
            if ( guessNum > ranNum ){
                System.out.println("Your guess is too high.");
                // capture number of tries
                ++tries;

            } else if ( guessNum < ranNum ) { // if the guessNum is less
                System.out.println("\nYour guess is too low");
                // capture number of tries
                ++tries;

            } else if ( guessNum == ranNum ) {  // if the guessNum is correct
                System.out.printf("Good job, %s! You guessed my number in %s guesses!\n", name, tries);

                while ( true ) {
                    try {
                        res = replayGame( );
                    } catch ( Exception e ){
                        System.out.println( e.getMessage() );
                    }

                    //if the res is no
                    if( res.equalsIgnoreCase("n" ) ){
                        System.out.println(res);
                        scannerObj.close();
                        System.out.printf("Good Bye %s", name);
                        break;

                    } else if ( res.equalsIgnoreCase("y" ) ) { // if the res is yes
                        // print the response, generate a new ranNum, set the tries to 1
                        System.out.println(res);
                        ranNum = genRandomNumber(max, min);
                        tries = 1;
                        break;
                    } else if ( !res.equalsIgnoreCase("y") && !res.equalsIgnoreCase("n") ) {
                        System.out.println("\nPlease select \"y\" for yes or \"n\" for no \n");
                    }

                }


            }

        } while ( guessNum != ranNum && tries <= maxTries );

        scannerObj.close();

    }



}
