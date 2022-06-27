import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    Random r = new Random();
    Game g = new Game( r );



    @Test
    void checkGoblinsTest( ) {
        g.getLand().setTrees( 5 );
        g.getLand().getTrees()[2] = 0x1F47A;

        assertTrue(g.checkGoblins());

    } // end checkGoblinsTest




} // end GameTest
