package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HeimaController {
    private Notandi user;

    @FXML
    private Label fxUser;
    @FXML
    private Label fxCoins;
    @FXML
    private Button fxKubbur;

    public void initialize() {
        // Guest user
        user = new Notandi("Guest", "1234");
        fxCoins.setText("Coins: " + String.valueOf(ViewSwitcher.getCoins()));
        fxKubbur.getStyleClass().add("kubburOut");
        fxUser.setText(ViewSwitcher.getCurrentUser().getNotendaNafn());

    }

    @FXML
    protected void onKaupa(ActionEvent actionEvent){
        ViewSwitcher.setCoins(ViewSwitcher.getCoins()+50);
        fxCoins.setText("Coins: " + String.valueOf(ViewSwitcher.getCoins()));
    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        // ViewSwitcher.switchTo(View.NYSKRANING);
    }

    @FXML
    protected void onKubburPressed(ActionEvent actionEvent) {
        ViewSwitcher.setCoins(ViewSwitcher.getCoins() - 10);
        ViewSwitcher.switchTo(View.KUBBUR);
        // PauseTransition pause = new PauseTransition(Duration.seconds(5));
        // pause.setOnFinished(event -> ViewSwitcher.switchTo(View.KUBBUR));
        // pause.play();
    }

    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        // NotandiDialog d = new NotandiDialog();
        // user = d.getNotandi();
        // try {
        // fxUser.setText(user.getNotendaNafn());
        // } catch (NullPointerException e) {

        // }

    }

    @FXML
    protected void inKubbur(MouseEvent mouseEvent){
        fxKubbur.getStyleClass().remove("kubburOut");
        fxKubbur.getStyleClass().add("kubburIn");
    }

    @FXML
    protected void outKubbur(MouseEvent mouseEvent){
        fxKubbur.getStyleClass().remove("kubburIn");
        fxKubbur.getStyleClass().add("kubburOut");
    }
}
