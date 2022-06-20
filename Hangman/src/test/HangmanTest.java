import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanTest {

    Hangman manTest = new Hangman();
    ArrayList wordsTest = new ArrayList<String>();
    String w = "hello";




    @BeforeAll
    static void init( ) {
        System.out.println( "Junit testing!!!" );

    }

    @Test
    void genWordTest(  ) {

        wordsTest.add("Hello");
        manTest.genWord( wordsTest );
        assertEquals( "Hello", manTest.word );

    } // end genWordTest


    @Test
    void genDashLineTest( ) {
        var expected = new StringBuilder("-----");
        manTest.dashLine = new StringBuilder();
        manTest.genDashLine(w);

        assertEquals( expected.toString(), manTest.dashLine.toString() );

    } // end genDashLineTest


    @Test
    void intakeUserGuessTest( ) {
        char userInput = 'b';
        var inputArray = new byte[1];
        inputArray[0] = (byte)userInput;
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );

        assertEquals( 'b', manTest.intakeUserGuess() );

    } // end intakeUserGuessTest



    @Test
    void checkCharTest( ) {
        manTest.word = "hello";
        manTest.letter = 'h';
        manTest.dashLine = new StringBuilder();
        manTest.missedLetters = new StringBuilder();
        manTest.genDashLine( manTest.word );
        manTest.checkChar( manTest.letter, manTest.word );

        assertTrue(manTest.isRight);

    } // end checkCharTest




    @Test
    void updateLineTest(  ) {
        manTest.dashLine = new StringBuilder();
        manTest.word = "hello";
        manTest.letter = 'h';
        manTest.genDashLine(manTest.word);
        manTest.updateLine( 0, manTest.letter );

        assertEquals("h----", manTest.dashLine.toString() );

    } // end updateLineTest



    @Test
    void checkWinTest( ) {
        manTest.word = "hello";
        manTest.dashLine = new StringBuilder( "hel" );
        manTest.chances = 0;
        String userInput = "n";
        byte[] inputArray = userInput.getBytes();
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );
        manTest.checkWin();

        assertEquals( -1, manTest.chances );



    } // end checkWinTest

    @Test
    void resetGameTest( ) {
        String userInput = "n";
        byte[] inputArray = userInput.getBytes();
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );
        manTest.resetGame();

        assertEquals( -1, manTest.chances);

    } // end resetGameTest


    @Test
    void playAgainTest( ) {
        String userInput = "y";
        byte[] inputArray = userInput.getBytes();
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );

        assertEquals( "y", manTest.playAgain() );

    } // end playAgaintest


    @Test
    void drawHangManTest( ) {
        manTest.chances = 6;
        manTest.drawHangMan();

        assertEquals( 6, manTest.chances );


    } // end drawHangManTest



} // end HangmanTest
