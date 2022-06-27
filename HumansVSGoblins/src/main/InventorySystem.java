import java.util.Random;

public class InventorySystem extends Humanoid{

    private int face = 0x1F3E5;
    private int gun;
    private int position;




    /*
    InventorySystem: default constructor
     */
    public InventorySystem( ) {} // end InventorySystem




    public InventorySystem ( Random rand ) {
        this.gun = rand.nextInt( 3 + 1);
        this.position = rand.nextInt( Utility.area );

    } // end InventorySystem




    /*
    getGun: retrieves the gun value
     */
    public int getGun() {
        return gun;
    }// end getGun




    /*
    getFace: retrieves the face
      */
    public int getFace() {

        return face;
    }// end getFace




    /*
    getPosition: retrieves the position
     */
    public int getPosition() {

        return position;
    }// end getPosition




    /*
    setGun: sets the value of gun
     */
    public void setGun(int gun) {
        this.gun = gun;
    } // end setGun




    public int move() {
        return 0;
    }



    public String toString( ){

        return this.face + " " + this.gun + " " + this.position;
    }// toString


} // end InventorySystem
