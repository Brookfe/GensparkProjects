import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {

    Human h = new Human();
    Goblin g = new Goblin();
    InventorySystem t = new InventorySystem();


    @Test
    void attackTest( ) {
        h.setStrength( 3 );
        g.setHealth( 5 );
        String outcome = h.attack( g );

        assertEquals("Goblin health after attack: " + g.getHealth(), outcome );


    } // end attackTest




    @Test
    void moveTest( ) {
        h.setPosition( 10 );
        String userInput = "e";
        byte[] inputArray = userInput.getBytes();
        InputStream input = new ByteArrayInputStream( inputArray );
        System.setIn( input );

        assertEquals(11, h.move() );

    } // end moveTest




    @Test
    void consumeTreasureTest( ) {
        h.setHealth( 10 );
        t.setGun( 5 );

        h.consumeTreasure( t );

        assertEquals( 15, h.getHealth() );
    } // end consumeTreasureTest


} // end HumanTest
