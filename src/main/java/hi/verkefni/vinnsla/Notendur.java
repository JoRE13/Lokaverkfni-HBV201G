package hi.verkefni.vinnsla;

import java.util.HashSet;

/**
 * Manages a collection of {@link Notandi} objects using a HashSet to store
 * them.
 * This class provides methods to add users, check for their existence, and
 * retrieve user objects.
 */
public class Notendur {

    private HashSet<Notandi> tafla = new HashSet<>(); // A HashSet to hold user objects.

    /**
     * Constructs a new empty collection of users.
     */
    public Notendur() {
    }

    /**
     * Adds a user to the collection.
     * If the user already exists in the collection, they will not be added again
     * due to the
     * properties of the HashSet.
     *
     * @param u The {@link Notandi} user to be added to the collection.
     */
    public void add(Notandi u) {
        tafla.add(u);
    }

    /**
     * Checks if a user with the specified username exists in the collection.
     * 
     * @param userName The username to search for in the collection.
     * @return true if a user with the specified username exists, otherwise false.
     */
    public boolean contains(String userName) {
        for (Notandi x : tafla) {
            if (x.getNotendaNafn().equals(userName))
                return true;
        }
        return false;
    }

    /**
     * Retrieves a user by their username from the collection.
     * If no user with the specified username is found, this method returns null.
     *
     * @param userName The username of the user to retrieve.
     * @return The {@link Notandi} object corresponding to the specified username,
     *         or null if no such user exists.
     */
    public Notandi getUser(String userName) {
        for (Notandi x : tafla) {
            if (x.getNotendaNafn().equals(userName))
                return x;
        }
        return null;
    }
}
