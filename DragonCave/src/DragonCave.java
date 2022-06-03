import java.util.Scanner;

public class DragonCave {

    public static void main(String [] args){
        Scanner scannerObj = new Scanner(System.in); // Scanner object
        int caveNum = 0;
        int firstCave = 1;
        int secondCave = 2;
        boolean flag;

        do {
            flag = false;
            System.out.println("Which cave will you go into? (1 or 2)");

            try {
                caveNum = Integer.parseInt(scannerObj.next());
            } catch ( Exception e ){
                System.out.println("Only number 1 or number 2\n");
                flag = true;
                continue;
            }
            if ( caveNum != firstCave && caveNum != secondCave ){
                flag = true;
                System.out.println( "Only Cave 1 or Cave 2\n");
            }

        } while ( flag );

        if ( caveNum == firstCave ) {
            System.out.println("You approach the cave... \n" +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you, and says 'Welcome buddy!!!' ");

        } else if ( caveNum == secondCave ) {
            System.out.println("You approach the cave... \n" +
                    "It is dark and spooky... \n" +
                    "A large dragon jumps out in front of you! \n" +
                    "Gobbles you down in one bite! ");

        }

    }

}
