package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NyskraningController {

    @FXML
    private TextField fxUserID;
    @FXML
    private PasswordField fxPassword;

    @FXML
    protected void onNyskraning(ActionEvent actionEvent){
        if (!fxUserID.getText().isEmpty() && !fxPassword.getText().isEmpty()) {
            ViewSwitcher.newUser(fxUserID.getText(), fxPassword.getText());
            ViewSwitcher.setCoins(100);
            ViewSwitcher.switchTo(View.HEIM);
        }
    }

    @FXML
    protected void onHeim(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }
}
