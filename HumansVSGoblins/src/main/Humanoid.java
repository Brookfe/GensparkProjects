import java.util.Random;

public abstract class Humanoid {

    private int face;
    private int strength;
    private int health;
    private int position;      // location of human




    /*
    getStrength: retrieves the strength
     */
    public int getStrength() {

        return this.strength;
    } // end getStrength




    /*
    getHealth: retrieves the health
     */
    public int getHealth() {
        return this.health;
    }




    /*
    getFace: retrieves the face
    */
    public int getFace() {

        return this.face;
    }// end getFace




    /*
    getPosition: retrieves the coordinates
     */
    public int getPosition() {
        return this.position;
    } // end getPosition




    /*
    setHealth: sets the health
     */
    public void setHealth(int health) {

        this.health = health;
    } // end setHealth




    /*
    setPosition: changes the location
     */
    public void setPosition(int x ) {

        this.position = x;
    } // end setPosition




    public abstract int move(  );




    /*
    attack: Human attacking Goblin
     */
    public String attack( Humanoid g ){
        Random rand = new Random();

        String fight;
        int fStrength = rand.nextInt( this.getStrength() + 1 );

        g.setHealth( g.getHealth() - fStrength );

        if ( g.getHealth() <= 0 ) {
            fight = "Goblin is Dead";
        }

        fight = " Human attacked the Goblin and reduced the health of the Goblin by ";

        return fight;

    } // end attack



} // end Humanoid
