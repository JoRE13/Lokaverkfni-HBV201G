package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;

public class HeimaController {
    private Notandi user;

    @FXML
    private Label fxUser;
    @FXML
    private Label fxCoins;
    @FXML
    private Button fxKubbur;
    @FXML
    private Button fxBud;
    @FXML
    private Button fxInnskraning;
    @FXML
    private Button fxNyskraning;
    @FXML
    private Button fxLogout;

    private static final String SPURNING = "Má bjóða þér að kaupa meira?";
    private static final String TILKYNNING = "Peningaupphæðin þín er orðin ansi lág...";
    private static final String ILAGI = "Ja!";
    private static final String NEI = "nei";

    private int counter = 0;

    public void initialize() {
        fxKubbur.getStyleClass().add("kubburOut");
        if (ViewSwitcher.getCurrentUser() != null) {
            fxCoins.setText("Coins: " + String.valueOf(ViewSwitcher.getCurrentUser().getPeningur()));
            fxUser.setText(ViewSwitcher.getCurrentUser().getNotendaNafn());
            // fxKubbur.setDisable(false);
            fxBud.setVisible(true);
            fxInnskraning.setVisible(false);
            fxNyskraning.setVisible(false);
            fxLogout.setVisible(true);
        } else {
            // fxKubbur.setDisable(true);
            fxBud.setVisible(false);
            fxInnskraning.setVisible(true);
            fxNyskraning.setVisible(true);
            fxLogout.setVisible(false);
        }
    }

    @FXML
    protected void onLogout(ActionEvent actionEvent) {
        ViewSwitcher.setCurrentUser(null);
        ViewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    protected void onKaupa(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.BUD);
    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.NYSKRANING);
    }

    @FXML
    protected void onKubburPressed(ActionEvent actionEvent) {
        if (ViewSwitcher.getCurrentUser() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Þú þarft að skrá þig inn til að spila", ButtonType.OK);
            a.setHeaderText("Ekki skráður inn");
            a.show();
            return;
        }

        if (ViewSwitcher.getCurrentUser().getPeningur() < 23) {
            ButtonType bType = new ButtonType(ILAGI, ButtonBar.ButtonData.OK_DONE);
            ButtonType hType = new ButtonType(NEI, ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert a = new Alert(Alert.AlertType.WARNING, "Þú þarft a.m.k. 23 krónur til að spila. Kaupa meira?", bType,
                    hType);
            a.setHeaderText("Ekki nægilegt fjármagn");

            a.showAndWait();
            System.out.println("Button clicked. a.getResult() = " + a.getResult() + ", bType = " + bType);
            if (a.getResult().equals(bType)) {
                ViewSwitcher.switchTo(View.BUD);
            }
            return;
        }
        ViewSwitcher.switchTo(View.KUBBUR);
    }

    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.INNSKRANING);
    }

    @FXML
    protected void inKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburOut");
        fxKubbur.getStyleClass().add("kubburIn");
    }

    @FXML
    protected void outKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburIn");
        fxKubbur.getStyleClass().add("kubburOut");
    }
}
