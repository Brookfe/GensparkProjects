import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class GuessTheNumberTest {
    @Test
    void greetingTest(){
        String userName = "James";
        InputStream input = new ByteArrayInputStream( userName.getBytes() );
        System.setIn( input );
        try{
            assertEquals(userName, GuessTheNumber.greeting() );
        } catch ( Exception e ){
            System.out.println( e.getMessage() );
        }

    }

    @Test
    void guessNumTest(){
        String userInput = "1";
        InputStream input = new ByteArrayInputStream( userInput.getBytes() );
        System.setIn( input );
        int exp = Integer.parseInt( userInput );

        try {
            assertEquals( exp, GuessTheNumber.guessNum() );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void replayGame(){
        String userInput = "y";
        InputStream input = new ByteArrayInputStream( userInput.getBytes() );
        System.setIn( input );

        try {
            assertEquals( userInput, GuessTheNumber.replayGame() );
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }


}
