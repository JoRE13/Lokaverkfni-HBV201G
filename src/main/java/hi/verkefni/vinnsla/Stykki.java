package hi.verkefni.vinnsla;

/**
 * Represents a game piece in a board game, managing the visual representation
 * (image) and its corresponding numerical value.
 * The class maps a name from CSS that refers to an image to a numerical value
 * which might be used in game logic.
 */
public class Stykki {
    private String nafn; // Name of the CSS class that holds the image for the game piece.
    private int tala; // Corresponding number for the image.

    // Array of names corresponding to numbers; used to map the 'nafn' to 'tala'.
    private String[] nums = { "einn", "tveir", "thrir", "fjorir", "fimm", "sex", "sjo", "atta", "niu" };

    /**
     * Constructor that creates a game piece by assigning a numerical value based on
     * the specified name.
     * The name should correspond to one of the predefined names in the 'nums'
     * array. The index of the name
     * in the array (plus one) is used as the numerical value of the game piece.
     * 
     * @param nafn The name of the image in the CSS file. This name should be one of
     *             the entries in the 'nums' array.
     */
    public Stykki(String nafn) {
        this.nafn = nafn;
        for (int i = 0; i < nums.length; i++) {
            if (nafn.equals(nums[i])) {
                tala = i + 1;
                break;
            }
        }
    }

    /**
     * Returns the name of the CSS class associated with this game piece.
     * 
     * @return The name of the CSS class.
     */
    public String getNafn() {
        return nafn;
    }

    /**
     * Returns the numerical value associated with this game piece.
     * 
     * @return The numerical value.
     */
    public int getTala() {
        return tala;
    }
}
