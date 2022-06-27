import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandTest {
    Land l = new Land( 10 );
    Human h = new Human( );


    @Test
    void placeBlocksTest( ) {
        int block = 0x1F332;
        l.placeBlocks();

        assertEquals( block, l.getTrees()[0] );

    } // end placeBlocksTest


    @Test
    void drawTest( ) {

    } // end drawTest


    @Test
    void placeHGTest( ) {
        int f = 0x1F9D4;
        l.placeHG( h );

        assertEquals( f, l.getTrees()[h.getPosition()] );
    } // end placeHGTest


    @Test
    void repositionTest( ) {
        h.setPosition( 5 );
        String userInput = "e";
        byte[] inputArray = userInput.getBytes();
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );

        l.reposition( h );

        assertEquals( h.getFace(), l.getTrees()[6] );


    } // end repositionTest


} // end LandTest
