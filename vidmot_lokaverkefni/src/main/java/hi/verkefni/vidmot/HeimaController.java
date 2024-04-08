package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HeimaController {
    private Notandi user;
    public static Notendur notendur = new Notendur();
    @FXML
    private Label fxUser;

    public void initialize(){

    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.NYSKRANING);
    }
    @FXML
    protected void onKubburPressed(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.KUBBUR);
    }
    @FXML
    protected void onInnskraning(ActionEvent actionEvent){
        NotandiDialog d = new NotandiDialog();
        user = d.getNotandi();
        try {
            fxUser.setText(user.getNotendaNafn());
        } catch(NullPointerException e){

        }

    }
}
