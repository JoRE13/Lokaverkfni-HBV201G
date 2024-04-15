package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A utility class that handles switching views in a JavaFX application.
 * This class manages the scenes and users, allowing transitions between
 * different views and managing user sessions.
 */
public class ViewSwitcher {

    private static Scene scene; // The main scene for the application.

    public static Notendur notendur = new Notendur(); // Manages a collection of user objects.
    public static Notandi currentUser; // Currently logged in user, initially not set.

    /**
     * Creates a new user with the specified username and password, adds them to the
     * user manager,
     * and sets them as the current user.
     *
     * @param username The username for the new user.
     * @param password The password for the new user.
     */
    public static void newUser(String username, String password) {
        Notandi u = new Notandi(username, password);
        notendur.add(u);
        currentUser = u;
    }

    /**
     * Sets the specified user as the current user of the application.
     *
     * @param user The user to set as the current user.
     */
    public static void setCurrentUser(Notandi user) {
        currentUser = user;
    }

    /**
     * Returns the current user of the application.
     *
     * @return The currently logged in user.
     */
    public static Notandi getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the main scene for the application. This scene is used as the container
     * for all views.
     *
     * @param scene The main scene to be used by the application.
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Switches the current view to the specified view. This method loads the FXML
     * file associated with the view,
     * sets it as the root of the main scene, and handles any IOExceptions that
     * occur during loading.
     *
     * @param view The view to switch to.
     */
    public static void switchTo(View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }
        try {
            Parent root;
            System.out.println("Loading from FXML");
            // Load the FXML file for the view and set it as the root of the scene.
            root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
