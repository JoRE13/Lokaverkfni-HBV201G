package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import hi.verkefni.vinnsla.Notendur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.beans.binding.StringBinding;

public class HeimaController {
    private Notandi user;
    public static Notendur notendur = new Notendur();
    @FXML
    private Label fxUser;
    @FXML
    private Label fxCoins;

    public void initialize() {
        // Guest user
        user = new Notandi("Guest", "1234");
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
}
