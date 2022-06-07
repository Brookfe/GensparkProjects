import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class DragonCaveTest {


    @Test
    void selectCave(){
        String userInput = "1";
        Scanner obj = new Scanner(System.in);

        InputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn( input );
        int e = Integer.parseInt(userInput);

        assertEquals( e, DragonCave.selectCave());

    }

}
