package hi.verkefni.vinnsla;

/**
 * Represents a user in the application.
 * This class stores user-specific information such as username, password, and
 * monetary balance.
 */
public class Notandi {
    private String notendaNafn; // The username of the user.
    private String lykilord; // The password of the user.
    private int peningur = 100; // The monetary balance of the user, initialized to 100.

    /**
     * Constructs a new user with the specified username and password.
     * The initial monetary balance is set to 100.
     *
     * @param notendanafn The username of the user.
     * @param lykilord    The password of the user.
     */
    public Notandi(String notendanafn, String lykilord) {
        this.notendaNafn = notendanafn;
        this.lykilord = lykilord;
    }

    /**
     * Returns the monetary balance of the user.
     *
     * @return The current monetary balance.
     */
    public int getPeningur() {
        return peningur;
    }

    /**
     * Sets the monetary balance of the user.
     * This method allows updating the balance, for instance, when a user earns or
     * spends money.
     *
     * @param peningur The new monetary balance to set.
     */
    public void setPeningur(int peningur) {
        this.peningur = peningur;
    }

    /**
     * Returns the password of the user.
     *
     * @return The user's password.
     */
    public String getLykilord() {
        return lykilord;
    }

    /**
     * Returns the username of the user.
     *
     * @return The user's username.
     */
    public String getNotendaNafn() {
        return notendaNafn;
    }
}
