import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoblinTest {

    Goblin g = new Goblin();
    Human h = new Human();


    @Test
    void attackTest( ){
        g.setStrength( 3 );
        h.setHealth( 5 );

        String outcome = g.attack( h );

        assertEquals( "Human health after attack:: " + h.getHealth(), outcome );

    } // end attackTest



} // end GoblinTest
