package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

/**
 * Klasinn AskrifandiDialog sem erfir frá Dialog<"Askrifandi>  sem skiptir um dialog.
 * @author Jóhannes Reykdal Einarsson
 */
public class NotandiDialog extends Dialog<Notandi> {

    @FXML
    private TextField fxNotendanafn;//fxml breyta sem heldur utan um það sem slegir er inn í textasviðið.
    @FXML
    private PasswordField fxLykilord;
    @FXML
    private ButtonType fxILagi;//fxml breyta fyrir í lagi hnapp


    /**
     * Smiður fyrir klasann.
     */
    public NotandiDialog() {
        setDialogPane(lesaNotandiDialog());
        // sett regla um hvenær í lagi hnappur er virkur
        iLagiRegla();
        // Búum til hlut af nýjum nafnlausum innri klasa sem útfærir interface
        // Callback fyrir klasana ButtonType og Leikmenn
        // Callback hefur eina aðferð og við endurforritum hana
        setResultConverter(b -> {                                 // b er af taginu ButtonType
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return new Notandi(fxNotendanafn.getText(), fxLykilord.getText());
            } else {
                return null;
            }
        });         // endir á d.setResultConverter
    }

    /**
     * Býr til DialogPane fyrir "askrifandi-view.fxml".
     * @return skilar DialogPane sem var búið til
     */
    private DialogPane lesaNotandiDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("innskraning-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Skilgreinir hvenær Í lagi hnappur er virkur
     */
    private void iLagiRegla() {
        // fletta upp í lagi hnappnum út frá hnappategund
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        Boolean oleyfilegt = fxNotendanafn.getText().isEmpty() ||  fxLykilord.getText().isEmpty()
                || !HeimaController.notendur.legal(fxNotendanafn.getText(), fxLykilord.getText());
        BooleanBinding oleyfilegtBinding = Bindings.createBooleanBinding(()-> oleyfilegt);
        
        iLagi.disableProperty().bind(oleyfilegtBinding);
    }

    /**
     * Birtir svar og skilar dialog
     * @return
     */
    public Notandi getNotandi() {
        // Dialog birtur og svarið fengið
        Optional<Notandi> utkoma = showAndWait();
        return utkoma.orElse(null);
    }
}
