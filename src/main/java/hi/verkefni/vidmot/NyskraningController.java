package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the new user registration screen.
 * This class handles the registration process, validating input fields, and
 * providing user feedback.
 */
public class NyskraningController {

    @FXML
    private TextField fxUserID; // TextField for user input of username.
    @FXML
    private PasswordField fxPassword; // PasswordField for user input of password.
    @FXML
    private PasswordField fxPasswordAgain; // PasswordField for user to re-enter password for confirmation.
    @FXML
    private Label fxNaNUser; // Label to display username-related error messages.
    @FXML
    private Label fxWrongPassword; // Label to display password mismatch error messages.

    /**
     * Initializes the controller by setting the default styles for input fields.
     */
    public void initialize() {
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
        fxPasswordAgain.setStyle("-fx-border-color: black");
    }

    /**
     * Handles the registration process when the register button is clicked.
     * Validates the user inputs for errors like empty fields, username
     * availability, and password match.
     * If validation passes, a new user is created and the user is redirected to the
     * home view.
     *
     * @param actionEvent The event that triggered this method.
     */
    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        if (fxUserID.getText().isEmpty() || fxUserID.getText().isBlank() || fxPassword.getText().isEmpty()
                || fxPassword.getText().isBlank()) {
            fxUserID.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Hlutir mega ekki vera tómir");
        } else if (ViewSwitcher.notendur.contains(fxUserID.getText())) {
            fxUserID.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn er frátekið");
        } else if (!fxPassword.getText().equals(fxPasswordAgain.getText())) {
            fxPassword.setStyle("-fx-border-color: red");
            fxPasswordAgain.setStyle("-fx-border-color: red");
            fxWrongPassword.setText("Lykilorð eru ekki eins");
        } else {
            ViewSwitcher.newUser(fxUserID.getText(), fxPassword.getText());
            ViewSwitcher.getCurrentUser().setPeningur(0);
            ViewSwitcher.switchTo(View.HEIM);
        }
    }

    /**
     * Navigates to the home view without registering.
     *
     * @param actionEvent The event that triggered this method.
     */
    @FXML
    protected void onHeim(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.HEIM);
    }

    /**
     * Resets the border color and error messages of the username field upon focus.
     *
     * @param mouseEvent The mouse event that triggered this method.
     */
    @FXML
    protected void onUsername(MouseEvent mouseEvent) {
        fxUserID.setStyle("-fx-border-color: black");
        fxNaNUser.setText("");
    }

    /**
     * Resets the border color and error messages of the password fields upon focus.
     *
     * @param mouseEvent The mouse event that triggered this method.
     */
    @FXML
    protected void onPassword(MouseEvent mouseEvent) {
        fxPassword.setStyle("-fx-border-color: black");
        fxPasswordAgain.setStyle("-fx-border-color: black");
        fxWrongPassword.setText("");
    }
}
