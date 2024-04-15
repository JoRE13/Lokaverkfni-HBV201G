package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the login screen.
 * This class manages user authentication, handling input validation and
 * navigating to other views based on authentication success.
 */
public class InnskraningController {

    @FXML
    private TextField fxUserID; // TextField for user input of username.
    @FXML
    private PasswordField fxPassword; // PasswordField for user input of password.
    @FXML
    private Label fxNaNUser; // Label to display username/password error messages.
    @FXML
    private Label fxWrongPassword; // Label to display password error messages; not currently used.

    /**
     * Initializes the controller, setting the default styles for the input fields.
     */
    public void initialize() {
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
    }

    /**
     * Handles the login process when the login button is clicked.
     * Validates the user credentials and updates the UI accordingly. If the
     * credentials are correct,
     * it sets the current user in the ViewSwitcher and switches to the home view.
     *
     * @param actionEvent The event that triggered this method.
     */
    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        if (fxUserID.getText().isEmpty() || !ViewSwitcher.notendur.contains(fxUserID.getText())) {
            fxUserID.setStyle("-fx-border-color: red");
            fxPassword.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn og/eða lykilorð er vitlaust");
        } else if (!ViewSwitcher.notendur.getUser(fxUserID.getText()).getLykilord().equals(fxPassword.getText())) {
            fxUserID.setStyle("-fx-border-color: red");
            fxPassword.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn og/eða lykilorð er vitlaust");
        } else {
            Notandi u = ViewSwitcher.notendur.getUser(fxUserID.getText());
            ViewSwitcher.setCurrentUser(u);
            ViewSwitcher.switchTo(View.HEIM);
        }
    }

    /**
     * Navigates to the home view without logging in.
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
        fxPassword.setStyle("-fx-border-color: black");
        fxNaNUser.setText("");
    }

    /**
     * Resets the border color and error messages of the password field upon focus.
     *
     * @param mouseEvent The mouse event that triggered this method.
     */
    @FXML
    protected void onPassword(MouseEvent mouseEvent) {
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
        fxWrongPassword.setText("");
    }
}
