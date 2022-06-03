import java.util.Scanner;
public class GuessTheNumber {

    /*
    genRandomNumber: generates a random number between max and min
     */
    public static int genRandomNumber(int max, int min){

        return ((int)(Math.random()*(max - min))) + min;

    } // end genRandomNumber



    // Guessing the number game within six tries
    /*
    main method: to start the program
     */
    public static void main(String []args) {
        int max = 20; // max
        int min = 1; // min
        int guessNum = 0;  //
        //int guessNum;
        int tries = 1; // number of tries
        int maxTries = 6; // max number of tries allowed
        int ranNum; // random number
        String res;
        Scanner scannerObj = new Scanner(System.in); // scanner object

        // Input name
        System.out.println("Hello! What is your name?");
        String name = scannerObj.next();

        // Greeting statement including the name
        System.out.printf("Well, %s, I am thinking of a number between 1 and 20\n", name);

        // Generate a number between 1 and 20
        ranNum = genRandomNumber(max, min);


        // do-while loop, print 'Take a guess'; capture the input and compare it to random
        do {
            System.out.println("Take a guess.");
            try{
                guessNum = Integer.parseInt(scannerObj.next());
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

                // to play again
                // handle exception: if user inputs for anything other than y or n
                while ( true ){
                    System.out.println("Would you like to play again? (y or n)");
                    res = scannerObj.next();

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
                        System.out.println("Please select y or n\n");
                        continue;
                    }

                }

            }

        } while ( guessNum != ranNum && tries <= maxTries );

    }
}
