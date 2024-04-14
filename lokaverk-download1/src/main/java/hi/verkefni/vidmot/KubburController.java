package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Kubbur;
import hi.verkefni.vinnsla.Stykki;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.util.Arrays;

/**
 * Controller fyrir forritið sem bregst við atburðum frá notenda.
 *
 * @author Jóhannes Reykdal Einarsson og Einar Andri Víðisson
 */

public class KubburController {
    @FXML
    private TextField fxTala;// tilviksbreyta fyrir textasviðið.
    @FXML
    private GridPane fxBord;// tilviksbreytan fyrir gridpane sem heldur utan um hnappana.
    @FXML
    private Label fxStig;// tilviksbreyta fyrir label sem heldur utan um stig leikmannsins.
    @FXML
    private Label fxOngoing;// tilviksbreyta fyrir label sem segir hvort leikur sé í gangi.

    private int kast = 0; // Heldur utan um hversu oft er giskað áður en réttri tölu er náð

    private Button[] visited = new Button[9]; // Heldur utan hvort sé búið að giska rétt á reitinn eða ekki.

    private String[] validTala = { "1", "2", "3", "4", "5", "6", "7", "8", "9" }; // Fylki sem heldur utan um leyfilegar
                                                                                  // tölur sem hægt er að slá inn í
                                                                                  // textasviðið.

    private Kubbur kubbur = new Kubbur(3, 3); // Býr til spilaborðið þ.e. hlut kubbur af klasanum Kubbur.

    /**
     * Tengir viðmótið við vinnsluna
     */
    public void initialize() {
        fxStig.textProperty().bind(kubbur.stigProperty());
        fxOngoing.textProperty().bind(Bindings.createStringBinding(() -> {
            if (kubbur.fjoldiProperty().getValue() == 9)
                return "Leik Lokið";
            return "Leikur í gangi";
        }, kubbur.fjoldiProperty()));

    }

    /**
     * Bregst við því þegar notandi slær nýrri tölu inn í textasviðið. Það tekur
     * sérhvern hnapp
     * sem ekki er búið að giska rétt á og er disabled, tekur myndina af honum og
     * virkjar hann aftur.
     *
     * @param keyEvent þegar slegið er inn í textasviðið
     */
    @FXML
    protected void onNyTala(KeyEvent keyEvent) {
        if (!Arrays.asList(validTala).contains(fxTala.getText())) {
            fxTala.clear();
            return;
        }

        validTala = Arrays.stream(validTala).filter(t -> !t.equals(fxTala.getText())).toArray(String[]::new);

        fxBord.setDisable(false);
        for (Node b : fxBord.getChildren()) {
            if (b.isDisabled()) {
                boolean visit = false;
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i] == b) {
                        visit = true;
                    }
                }
                if (!visit) {
                    eydaMynd((Button) b);
                    b.setDisable(false);
                }
            }
        }
    }

    /**
     * eyðir myndinni sem sett er á hnappinn þegar ýtt er á hann.
     *
     * @param b hnappur í gridpane fxBord
     */
    public void eydaMynd(Button b) {
        int i = GridPane.getRowIndex(b);
        int j = GridPane.getColumnIndex(b);
        Stykki stykki = kubbur.getBordStykki(i, j);
        b.getStyleClass().removeAll(stykki.getNafn());
    }

    /**
     * Bregst við því þegar ýtt er á hnapp. Setur mynd á hnapp og gefur stig ef ýtt
     * er
     * á "réttan" hnapp. Þrjú stig fyrir fyrstu tilraun, 2 fyrir aðra, eitt stig
     * fyrir þriðju og
     * engin eftir það.
     *
     * @param actionEvent þegar ýtt er á hnapp.
     * @throws InterruptedException
     */
    @FXML
    protected void onSetjaStykki(ActionEvent actionEvent) throws InterruptedException {
        if (fxTala.getText().isEmpty()) {
            return;
        }
        fxTala.setDisable(true);
        Button reitur = (Button) actionEvent.getSource(); // hvaða reitur var valinn á borðinu
        int i = GridPane.getRowIndex(reitur);
        int j = GridPane.getColumnIndex(reitur);
        Stykki stykki = kubbur.getBordStykki(i, j);
        setjaMynd(stykki, reitur);
        reitur.setDisable(true);
        if (stykki.getTala() == Integer.parseInt(fxTala.getText())) {
            fxBord.setDisable(true);
            fxTala.setDisable(false);
            fxTala.clear();
            if (kast < 3) {
                kubbur.setStig((3 - kast));
            }
            visited[kubbur.fjoldiProperty().getValue()] = reitur;
            kubbur.setFjoldi();
            kast = 0;

        } else {
            kast++;
        }
    }

    /**
     * Setur mynd á hnapp.
     *
     * @param stykki stykkið sem gefur hvaða mynd á að setja á hnapp b
     * @param b      hnappur sem setja mynd á.
     */
    private void setjaMynd(Stykki stykki, Button b) {
        b.getStyleClass().add(stykki.getNafn());
    }

    @FXML
    protected void tilBaka(ActionEvent actionEvent) {
        if (fxOngoing.getText().equals("Leikur í gangi")) {
            return;
        }
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + kubbur.getStig() - 5);
        ViewSwitcher.switchTo(View.HEIM);
    }

}
