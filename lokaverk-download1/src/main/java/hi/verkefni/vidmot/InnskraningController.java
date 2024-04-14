package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InnskraningController {
    @FXML
    private TextField fxUserID;
    @FXML
    private PasswordField fxPassword;
    @FXML
    private Label fxNaNUser;
    @FXML
    private Label fxWrongPassword;

    public void initialize(){
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");

    }

    @FXML
    protected void onInnskraning(ActionEvent actionEvent){
        if (fxUserID.getText().isEmpty() || !ViewSwitcher.notendur.contains(fxUserID.getText())){
            fxUserID.setStyle("-fx-border-color: red");
            fxPassword.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn og/eða lykilorð er vitlaust");

        }
        else if(!ViewSwitcher.notendur.getUser(fxUserID.getText()).getLykilord().equals(fxPassword.getText())){
            fxUserID.setStyle("-fx-border-color: red");
            fxPassword.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn og/eða lykilorð er vitlaust");
        }
        else {
            Notandi u = ViewSwitcher.notendur.getUser(fxUserID.getText());
            ViewSwitcher.setCurrentUser(u);
            ViewSwitcher.switchTo(View.HEIM);
        }
    }

    @FXML
    protected void onHeim(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    protected void onUsername(MouseEvent mouseEvent){
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
        fxNaNUser.setText("");
    }
    @FXML
    protected void onPassword(MouseEvent mouseEvent){
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
        fxWrongPassword.setText("");
    }
}
