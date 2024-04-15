package hi.verkefni.vidmot;

/**
 * Enum representing the different views in the JavaFX application.
 * Each view corresponds to a specific FXML file that defines the user interface
 * layout.
 */
public enum View {
    KUBBUR("kubbur-view.fxml"), // View for the game screen
    HEIM("heima-view.fxml"), // View for the home page
    NYSKRANING("nyskraning-view.fxml"), // View for the new user registration screen
    INNSKRANING("innskraning-view.fxml"), // View for the user login screen
    BUD("bud-view.fxml"); // View for the shopping or purchase screen

    private String fileName; // Filename of the FXML file associated with the view

    /**
     * Constructor for the view enum.
     * Initializes a new instance of the View enum with the specified FXML file
     * name.
     * 
     * @param fileName The filename of the FXML document that corresponds to the
     *                 view.
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Retrieves the filename of the FXML document associated with this view.
     * This method allows other parts of the application to load the appropriate
     * FXML file
     * based on the selected view.
     * 
     * @return A string representing the filename of the FXML document.
     */
    public String getFileName() {
        return fileName;
    }
}
