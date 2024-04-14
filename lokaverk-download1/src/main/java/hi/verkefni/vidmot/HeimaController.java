package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class HeimaController {
    private Notandi user;

    @FXML
    private Label fxUser;
    @FXML
    private Label fxCoins;
    @FXML
    private Button fxKubbur;

    private static final String SPURNING="Má bjóða þér að kaupa meira?";
    private static final String TILKYNNING="Peningaupphæðin þín er orðin ansi lág...";
    private static final String ILAGI ="Ja!";
    private static final String NEI ="nei";

    private int counter = 0;


    public void initialize() {
        fxCoins.setText("Coins: " + String.valueOf(ViewSwitcher.getCurrentUser().getPeningur()));
        fxKubbur.getStyleClass().add("kubburOut");
        fxUser.setText(ViewSwitcher.getCurrentUser().getNotendaNafn());
    }
    @FXML
    protected void KaupaMeira(MouseEvent mouseEvent){
        if(ViewSwitcher.getCurrentUser().getPeningur()<100 && counter < 1){
            onLoka();
            counter++;
        }
    }
    private void onLoka(){
        ButtonType bType = new ButtonType(ILAGI,
                ButtonBar.ButtonData.OK_DONE);
        ButtonType hType = new ButtonType(NEI, ButtonBar.ButtonData.CANCEL_CLOSE); // ButtonType er merktur með CANCEL_CLOSE (er enum)
        Alert a = stofnaAlert(bType,hType);
        a.showAndWait();
        if (a.getResult().equals(bType)) {
            ViewSwitcher.switchTo(View.BUD);
        }
    }

    /**
     * Hjálparfall fyrir onLoka. Býr til Alert dialoginn.
     * @param bILagi Í lagi hnappurinn
     * @return Alert dialoginn
     */
    private Alert stofnaAlert(ButtonType bILagi, ButtonType bHaettaVid) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.WARNING,  SPURNING, bILagi, bHaettaVid);
        a.setHeaderText(TILKYNNING);
        return a;
    }

    @FXML
    protected void onKaupa(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.BUD);
    }

    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.NYSKRANING);
    }

    @FXML
    protected void onKubburPressed(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur()-10);
        ViewSwitcher.switchTo(View.KUBBUR);
        // PauseTransition pause = new PauseTransition(Duration.seconds(5));
        // pause.setOnFinished(event -> ViewSwitcher.switchTo(View.KUBBUR));
        // pause.play();
    }

    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.INNSKRANING);

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
