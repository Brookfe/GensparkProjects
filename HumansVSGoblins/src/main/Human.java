import java.util.Random;
import java.util.Scanner;

public class Human extends Humanoid {


    private int face = 0x1F9D4;
    private int health;             // the health of human
    private int strength;           // the strength of human
    private int position;      // the location of human




    /*
    Human: default constructor
     */
    public Human() { } // end Human




    /*
    Human: constructor
     */
    public Human ( Random rand ) {
        this.health = rand.nextInt(10);
        this.strength = rand.nextInt( 10);
        this.position = rand.nextInt( Utility.area );
    } // end Human




    /*
    getHealth: retrieves the health
     */
    public int getHealth() {
        return health;
    } // end getHealth




    /*
    getStrength: retrieves the strength
     */
    public int getStrength() {
        return strength;
    } // end getStrength




    /*
    getPosition: retrieves the coordinates
     */
    public int getPosition() {
        return position;
    } // end getPosition




    /*
    getFace: retrieves the face
     */
    public int getFace() {
        return face;
    } // end getFace




    /*
    setHealth: sets the health
     */
    public void setHealth(int health) {
        this.health = health;
    } // end setHealth




    /*
    setStrength: sets the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    } // end setStrength




    /*
    setPosition: sets the coordinates
     */
    public void setPosition(int x ) {
        this.position = x;

    } // end setPosition




    /*
    setFace: sets the face
     */
    public void setFace(int face) {

        this.face = face;
    } // end setFace




    /*
    attack: Human attacking Goblin
     */
    public String attack( Goblin g ) {
        Random rand = new Random();

        String fight;
        int fStrength = rand.nextInt( this.getStrength() + 1 );
        System.out.println( "Goblin health before attack: " + g.getHealth());

        g.setHealth( g.getHealth() - fStrength );

        if ( g.getHealth() <= 0 ) {
            fight = "Goblin is Dead";
            System.out.println( fight );
            return fight;
        }

        fight = "Goblin health after attack: " + g.getHealth();
        System.out.println( fight );

        return fight;

    } // end attack




    /*
    move: changes the location of the human
     */
    public int move(  ) {
        int idx = 0;
        String m = "";
        Scanner s = new Scanner( System.in );

        do {
            System.out.println( "\nPress 'n' to move up, Press 's' to move down, Press 'w' to move left, Press 'e' to move right" );
            try {
                m = s.next();
            } catch ( Exception e ) {
                System.out.println( e.getMessage() );
            }
            //idx = Utility.changeCord( this.getCoordinates(), Utility.width );
        } while ( !m.equalsIgnoreCase("n") & !m.equalsIgnoreCase("s")
                & !m.equalsIgnoreCase("w") & !m.equalsIgnoreCase("e"));


        if ( m.equalsIgnoreCase("n" ) ) {
            idx =  this.position - Utility.width ;

        } else if ( m.equalsIgnoreCase( "s" ) ) {
            idx = ( this.position + Utility.width );

        } else if ( m.equalsIgnoreCase( "w") ) {
            idx = ( this.position - 1 );

        } else if ( m.equalsIgnoreCase( "e" ) ) {
            idx = ( this.position + 1 );
        }

        return idx;

    } // end move




    /*
    consumeTreasure: consumes treasures
     */
    public void consumeTreasure ( InventorySystem t ) {
        System.out.println( "Human health before: " + this.getHealth() );
        System.out.println( "Treasure " + t.getGun() );
        this.setHealth( this.getHealth() + t.getGun() );

        System.out.println( "Human health after: " + this.getHealth() );

    } // end consumeTreasure




    public String toString(){

        return this.face + " " + this.health + " " + this.strength + " " + this.position;
    }// toString




} // end Human
