import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Hangman {
    String playerName;  // the name of the player
    int result;  // the result
    String word;   // the random word
    char letter; // the letter players input
    String playAgain; // if the player wants to  play again
    StringBuilder missedLetters; // the missed letters
    StringBuilder dashLine; // consists of the correct guess
    int chances; // the number of tries
    boolean isRight; // if each guess is right




    /*
    Hangman: default constructor
     */
    public Hangman( ){
        this.result = 0;
    } // end Hangman




    /*
    start: starts the game
     */
    public void start() throws IOException {
        chances = 6;
        isRight = false;
        dashLine = new StringBuilder();
        missedLetters  = new StringBuilder();
        Utility.importWords( );
        genWord( Utility.words );
        System.out.println( this.word );
        genDashLine( this.word );
        inputName(  );

        while ( chances > 0 ) {
            drawHangMan( );
            this.letter = intakeUserGuess( );
            checkChar( this.letter, this.word );
            checkWin( );

        }
    } // end start




    /*
    inputName: takes in player's name
     */
    public void inputName(  ) {
        Scanner scannerObj = new Scanner( System.in );
        System.out.println( "Please input your name: ");
        try {
            this.playerName = scannerObj.next();

        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    } // end inputName




    /*
    genWord: generates a random word
     */
    public void genWord ( ArrayList<String> listWords )  {
        Random rand = new Random();

        try {
            this.word = listWords.get( rand.nextInt( listWords.size() ) );

        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }


    } // end wordGen




    /*
    genDashLine: generates lines based on the length of the word
     */
    public void genDashLine ( String w ) {

        dashLine.append("-".repeat(w.length()));

    } // end genDashLine




    /*
    intakeUserGuess: intakes user guess
     */
    public char intakeUserGuess ( )  {
        char l;
        String input="";
        Scanner scannerObj = new Scanner( System.in );
        System.out.println("Guess a letter.");

        try {
            input = scannerObj.next();
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }

        if ( !Character.isLetter(input.charAt(0)) || input.length() != 1 ) {
            intakeUserGuess( );
        }

        l = input.charAt( 0 );

        return l;

    } // end intakeUserGuess




    /*
    checkChar: checks if the char is in the word
     */
    public void checkChar ( char c, String w ) {
        this.isRight = false;

        for ( int i = 0; i < w.length(); i++ ) {
            if ( c == w.charAt( i ) ) {
                updateLine( i, c );
                this.isRight = true;
            }
        }

        if ( !this.isRight ) {
            this.missedLetters.append( c );
            this.chances--;
        }


    } // end checkChar


    /*
    updateLine: updates the dash line with char
     */
    public void updateLine ( int index, char ch ) {

        dashLine.setCharAt( index, ch );

    } // end updateLine



    /*
    checkWin: compares the dashline with the word
     */
    public void checkWin()  {

        if ( word.equalsIgnoreCase( dashLine.toString() ) ) {
            System.out.printf( "Yes! The secret word is \"%s\"! You have won! ",  word);
            this.result++;
            resetGame();
        }


        if ( chances == 0) {
            System.out.println( "HangMan!!! Game Over! The Word: " + word );
            drawHangMan();
            resetGame();
        }

    } // end checkWin




    /*
    resetGame: it resets the game
     */
    public void resetGame () {
        this.playAgain = playAgain( );

        if ( this.playAgain.equalsIgnoreCase( "y" )) {
            this.chances = 6;
            this.isRight = false;
            this.dashLine = new StringBuilder();
            this.missedLetters  = new StringBuilder();
            genWord( Utility.words );

            genDashLine( this.word );
            while ( chances > 0 ) {
                drawHangMan();
                this.letter = intakeUserGuess( );
                checkChar( this.letter, this.word );
                checkWin();

            }

        } else if ( this.playAgain.equalsIgnoreCase( "n" ) ) {
            System.out.println( "Good Bye " + this.playerName +"!!!" );
            checkResult();
            chances = -1;
        }

    } // end resetGame




    /*
    playAgain: asks if you want to play again
     */
    public String playAgain (  ) {
        Scanner scannerObj = new Scanner( System.in );
        String ans = "";

        System.out.println( "Do you want to play again? Y (yes) or N (no) " );
        try {
            ans = scannerObj.next();
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }

        if ( !ans.equalsIgnoreCase("n") && !ans.equalsIgnoreCase("y") ){
            playAgain( );
        }

        return ans;

    } // end resetGame




    /*
    checkResult: checks for the previous results
     */
    public void checkResult( )  {

        try {
            List<String> resultP = Files.readAllLines(Paths.get(this.playerName+"-result.txt"));
            if ( Integer.valueOf(resultP.get(1).split(" ")[1] ) < this.result ) {
                System.out.println( "Good Job! Scored a new Record!" );
                Files.write( Paths.get(this.playerName + "-result.txt"), Collections.singleton(this.toString()));
            }

        } catch ( Exception e ) {
            System.out.println( "We have recorded your results " );

        }
         
    } // end checkResult




    /*
    drawHangMan: draws the hangman
     */
    public void drawHangMan( ) {

        if ( chances == 6 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 5 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( "O   |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 4 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( " O  |");
            System.out.println( "     ");
            System.out.println( " |  |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 3 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( " O  |");
            System.out.println( "  /  ");
            System.out.println( " |  |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 2 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( " O  |");
            System.out.println("\\/  ");
            System.out.println( "|   |");
            System.out.println( "     ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 1 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( " O  |");
            System.out.println( "\\/  ");
            System.out.println( " |   |");
            System.out.println( "  \\  ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }
        if ( chances == 0 ) {
            System.out.println( "HANGMAN");
            System.out.println( "+---+");
            System.out.println( "     ");
            System.out.println( " O   |");
            System.out.println( "\\/   ");
            System.out.println( " |   |");
            System.out.println("/\\  ");
            System.out.println( "    |");
            System.out.println( "     ");
            System.out.println( "    ===");
            System.out.println( "Missed letters: " + missedLetters );

            System.out.println( dashLine );

        }

    } // end DrawHangMan




    /*
    toString: prints the name and the result
     */
    public String toString() {

        return "Name: " + this.playerName + "\nResult: " + this.result;
    }// toString




} // end Hangman
