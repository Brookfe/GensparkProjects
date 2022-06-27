import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Land land;
    private Human human;
    private Goblin[] goblins;
    private InventorySystem treasures;




    /*
    Game: default constructor
     */
    public Game( ){ } // end Game

    public Game ( Random rand ) {
        this.land = new Land( Utility.area );
        this.human = new Human( rand );
        this.treasures = new InventorySystem( rand );
        this.goblins = new Goblin[rand.nextInt(10) + 1] ; // change one to ten
        for ( int i = 0; i < goblins.length; i++ ) {
            this.goblins[i] = new Goblin( rand );
        }

    } // end Game



    /*
    getLand: retrieves land
     */
    public Land getLand() {

        return land;
    } // end getLand




    /*
    init: starts the game
     */
    public void init( ) {
        Scanner s = new Scanner( System.in );
        this.land.placeBlocks();
        this.land.placeHG( this.human );
        this.land.placeHG( this.treasures );
        for ( Goblin g : this.goblins ) {
            // if human and goblin have the same location
            if ( (this.human.getPosition() == g.getPosition()) || (this.human.getPosition() == this.treasures.getPosition()) ) {
                continue;
            }
            this.land.placeHG( g );
        }
        this.land.draw();

        // play the game
        play( s );
    } // end init




    /*
    checkGoblins: checks if goblins are alive
     */
    public boolean checkGoblins( ) {
        boolean no = false;

        for ( int t : this.land.getTrees() ){
            if ( t == 0x1F47A ) {

                return true;
            }
        }
        return no;
    }// end checkGoblins




    /*
    play
     */
    public void play( Scanner s ) {
        boolean isGoblinsAlive = true;

        while ( this.human.getHealth() > 0 && isGoblinsAlive ) {
            this.land.reposition( this.human );

            if( this.human.getPosition() == this.treasures.getPosition() ) {
                this.human.consumeTreasure( this.treasures );
            }

            for ( Goblin g : this.goblins ) {
                if ( this.human.getPosition() == g.getPosition() ) {
                    combat(this.human, g, s);

                }
            }
            isGoblinsAlive = checkGoblins();
            this.land.draw();

        }

        // if human is dead
        if ( this.human.getHealth() <= 0 && isGoblinsAlive ) {
            System.out.println( "\nGame Over!!!" );
            restartGame( s );
        }

        // if human kills all the goblins
        if ( !isGoblinsAlive ) {
            System.out.println( "\nHuman Won!!!" );
            restartGame( s );
        }

    } // end play




    /*
    restartGame:
     */
    public void restartGame( Scanner s ) {
        Random r = new Random();
        String playAgain = "";

        do {
            System.out.println("\nDo you want to play Again? Yes (y) or No (n) ");
            playAgain = s.next();

        } while ( playAgain.equalsIgnoreCase("y") & playAgain.equalsIgnoreCase( "n" ));

        if ( playAgain.equalsIgnoreCase( "y" ) ) {
            resetValue( r );

            init();

        } else if ( playAgain.equalsIgnoreCase( "n" ) ) {
            System.out.println( "Good Bye!!!" );
            s.close();
        }

    }// end restartGame




    /*
    resetValue
     */
    public void resetValue ( Random rand ){

        this.human = new Human( rand );
        this.land = new Land( Utility.area );
        this.treasures = new InventorySystem( rand );
        this.goblins = new Goblin[rand.nextInt(10) + 1] ;
        for ( int i = 0; i < goblins.length; i++ ) {
            this.goblins[i] = new Goblin( rand );
        }

    } // end resetValue




    /*
    combat: the fight
     */
    public void combat ( Human h, Goblin g, Scanner scannerObj ) {
        int hLoc = h.getPosition();
        int gLoc = g.getPosition();
       // Scanner scannerObj = new Scanner( System.in );
        String hS = "";
        // String gS = "";

        if ( hLoc == gLoc ) {
            //this.land.getTrees()[ hLoc ] = 0x2694;
            while ( h.getHealth() > 0 & g.getHealth() > 0 ){
                System.out.println( "Fight? Yes (y) ");
                try {
                    hS = scannerObj.next();
                } catch ( Exception e ) {
                    System.out.println( e.getMessage() );
                }
                if ( hS.equalsIgnoreCase( "y" ) ) {
                    h.attack( g );

                    if ( g.getHealth() > 0 ) {
                        g.attack( h );
                    }
                }
            }

            if ( h.getHealth() > 0 ) {
                this.land.getTrees()[h.getPosition()] = 0x1F9D4;
            } else if ( g.getHealth() > 0 ) {
                this.land.getTrees()[h.getPosition()] = 0x1F47A;
            }
        }
    } // end combat




    public String toString() {

        return this.land + " " + this.human + " " + Arrays.toString( this.goblins ) + " " + this.treasures;
    }
} // end Game
