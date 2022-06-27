import java.util.Random;
import java.util.Scanner;

public class Goblin extends Humanoid {

    private int face = 0x1F47A;
    private int health;                 // the health of goblin
    private int strength;               // the strength of goblin
    private int position;         // the location of goblin


    /*
    Goblin: default constructor
     */
    public Goblin() {

    } // end Goblin




    public Goblin( Random rand ) {
        this.health = rand.nextInt(10 );
        this.strength = rand.nextInt(10 );
        this.position = rand.nextInt( Utility.area );;
    } // end Goblin




    /*
    getFace: retrieves the face
     */
    public int getFace() {
        return face;
    } // end getFace




    /*
    getStrength: retrieves the strength
     */
    public int getStrength() {
        return strength;
    } // end getStrength




    /*
    getHealth: retrieves the health
     */
    public int getHealth() {
        return health;
    } // end getHealth




    /*
    getPosition: retrieves the coordinates
     */
    public int getPosition() {
        return this.position;
    } // end getPosition




    /*
    setStrength: sets the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    } // end setStrength




    /*
    setHealth: sets the health
     */
    public void setHealth(int health) {
        this.health = health;
    } // end setHealth




    /*
    setPosition: sets the coordinates
     */
    public void setPosition( int x ) {
        this.position = x;
    } // end setPosition




    /*
    setFace: sets the face
     */
    public void setFace(int face) {

        this.face = face;
    } // end setFace




    /*
     attack: Goblin attacking Human
       */
    public String attack ( Human h ) {
        Random rand = new Random();

        String fight;


        int fStrength = rand.nextInt( this.getStrength() + 1 );

        System.out.println( "Human health before attack: " + h.getHealth() );
        h.setHealth( h.getHealth() - fStrength );

        if ( h.getHealth() <= 0 ) {
            fight = "Human is Dead";
            System.out.println( fight );
            return fight;
        }


        fight = "Human health after attack:: " + h.getHealth();
        System.out.println(fight);

        return fight;

    } // end attack




    /*
    move: changes the location of the Goblin
    */
    public int move( ) {
        int idx = 0;
        String m = "";
        Scanner s = new Scanner( System.in );

        do {
            System.out.println( "Press 'n' to move up, Press 's' to move down, Press 'w' to move left, Press 'e' to move right" );
            try {
                m = s.next();
            } catch ( Exception e ) {
                System.out.println( e.getMessage() );
            }
        } while ( !m.equalsIgnoreCase("n") & !m.equalsIgnoreCase("s") & !m.equalsIgnoreCase("w") & !m.equalsIgnoreCase("e") );


        if ( m.equalsIgnoreCase("n" ) ) {
            idx = ( this.position - Utility.width );

        } else if ( m.equalsIgnoreCase( "s" ) ) {
            idx = ( this.position + Utility.width );

        } else if ( m.equalsIgnoreCase( "w") ) {
            idx = ( this.position - 1 );

        } else if ( m.equalsIgnoreCase( "e" ) ) {
            idx = ( this.position + 1 );
        }

        return idx;

    } // end move




    public String toString( ){

        return this.face + " " + this.health + " " + this.strength + " " + this.position;
    }// toString



} // end Goblin
