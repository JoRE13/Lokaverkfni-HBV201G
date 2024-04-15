package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application class that runs the program using JavaFX.
 * This class initializes the primary stage and sets up the initial view.
 * 
 * @author Jóhannes Reykdal Einarsson
 * @author Einar Andri Víðisson
 */
public class KubburApplication extends Application {

    /**
     * Starts the application by setting up the primary stage and loading the home
     * view.
     * This method is called after the JavaFX application has been initialized.
     * It prepares a new scene with a Pane as its root, switches to the home view,
     * and displays the stage.
     * 
     * @param stage The primary stage for this application, onto which
     *              the application scene can be set.
     * @throws IOException if there is an issue in loading the initial view.
     */
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.HEIM);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * 
     * @param args command line arguments passed to the application.
     *             Not used in this application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
