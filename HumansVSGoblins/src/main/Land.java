import java.util.Arrays;

public class Land {

    private int[] trees;



    /*
    Land: default constructor
     */
    public Land() { } // end Land




    /*
    Land: constructor to set up the dimension of the land
     */
    public Land ( int d ) {

        this.trees =  new int[d];

    } // end Land




    /*
    getTrees: retrieves the trees
     */
    public int[] getTrees() {

        return trees;

    } // end getTrees



    /*
    setTrees:
     */
    public void setTrees( int trees ) {

        this.trees = new int [ trees ];
    } // end setTrees




    /*
    placeBlocks: places the block on the ground
     */
    public void placeBlocks ( ) {
        for ( int i = 0; i < this.getTrees().length; i++ ) {
            this.trees[i] = 0x1F332;
        }

    } // end placeBlocks




    /*
    draw: draws the layout for the game
     */
    public void draw (){

        for ( int j = 0; j < Utility.area; j ++) {
            if ( j % Utility.width == 0 ) {
                System.out.println();
            }
            System.out.print( Character.toChars( (int)this.trees[j] ));
        }

    } // end draw




    /*
    placeHG: places Humanoid on the land
     */
    public void placeHG( Humanoid h ) {
        int i = h.getPosition() ;

        this.trees[i] = h.getFace();

    } // end placeHS




    /*
    reposition: changes the location of Humanoid
    */
    public void reposition( Humanoid h ) {
        int oldBlock;
        int newBlock;
        int face = h.getFace();

        oldBlock = h.getPosition();
        this.trees[oldBlock] = 0x1F332;

        do {
            newBlock = h.move();
        } while ( newBlock < 0 || newBlock >= Utility.area );

        h.setPosition( newBlock );
        this.trees[h.getPosition()] = face;

    } // end reposition




    public String toString() {

        return Arrays.toString( this.trees);
    }
} // end Land