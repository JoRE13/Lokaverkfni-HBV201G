package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NyskraningController {

    @FXML
    private TextField fxUserID;
    @FXML
    private PasswordField fxPassword;
    @FXML
    private PasswordField fxPasswordAgain;
    @FXML
    private Label fxNaNUser;
    @FXML
    private Label fxWrongPassword;

    public void initialize(){
        fxUserID.setStyle("-fx-border-color: black");
        fxPassword.setStyle("-fx-border-color: black");
        fxPasswordAgain.setStyle("-fx-border-color: black");
    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent){
        if (fxUserID.getText().isEmpty()){
            fxUserID.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn má ekki vera tómt");

        } else if (ViewSwitcher.notendur.contains(fxUserID.getText())) {
            fxUserID.setStyle("-fx-border-color: red");
            fxNaNUser.setText("Notendanafn er frátekið");

        } else if(!fxPassword.getText().equals(fxPasswordAgain.getText()) || fxPasswordAgain.getText().isEmpty() || fxPasswordAgain.getText().isEmpty()){
            fxPassword.setStyle("-fx-border-color: red");
            fxPasswordAgain.setStyle("-fx-border-color: red");
            fxWrongPassword.setText("Lykilorð ganga ekki upp");
        }
        else {
            ViewSwitcher.newUser(fxUserID.getText(), fxPassword.getText());
            ViewSwitcher.getCurrentUser().setPeningur(100);
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
        fxNaNUser.setText("");
    }
    @FXML
    protected void onPassword(MouseEvent mouseEvent){
        fxPassword.setStyle("-fx-border-color: black");
        fxPasswordAgain.setStyle("-fx-border-color: black");
        fxWrongPassword.setText("");
    }


}
