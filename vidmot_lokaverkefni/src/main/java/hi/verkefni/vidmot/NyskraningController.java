package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
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
        HeimaController.notendur.add(new Notandi(fxUserID.getText(),fxPassword.getText()));
        ViewSwitcher.switchTo(View.HEIM);
    }
}
