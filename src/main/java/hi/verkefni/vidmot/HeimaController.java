package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Notandi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the home screen in a JavaFX application.
 * This class manages interactions with various UI elements on the home screen
 * such as buttons and labels,
 * handling user authentication status, and navigation to different parts of the
 * application.
 */
public class HeimaController {
    private Notandi user; // Current user of the application

    @FXML
    private Label fxUser; // Label to display the user's name
    @FXML
    private Label fxCoins; // Label to display the user's coin balance
    @FXML
    private Button fxKubbur; // Button to navigate to the game screen
    @FXML
    private Button fxBud; // Button to navigate to the shop screen
    @FXML
    private Button fxInnskraning; // Button for logging in
    @FXML
    private Button fxNyskraning; // Button for new user registration
    @FXML
    private Button fxLogout; // Button to log out

    // Constant strings for alerts and confirmation dialogs
    private static final String SPURNING = "Má bjóða þér að kaupa meira?";
    private static final String TILKYNNING = "Peningaupphæðin þín er orðin ansi lág...";
    private static final String ILAGI = "Ja!";
    private static final String NEI = "nei";

    private int counter = 0; // Counter to track certain user interactions, not explicitly used in provided
                             // methods

    /**
     * Initializes the controller. This method is called automatically after the
     * FXML fields are injected.
     * It updates UI components based on the user's authentication status and
     * balance.
     */
    public void initialize() {
        fxKubbur.getStyleClass().add("kubburOut");
        if (ViewSwitcher.getCurrentUser() != null) {
            fxCoins.setText("Coins: " + String.valueOf(ViewSwitcher.getCurrentUser().getPeningur()));
            fxUser.setText(ViewSwitcher.getCurrentUser().getNotendaNafn());
            fxBud.setVisible(true);
            fxInnskraning.setVisible(false);
            fxNyskraning.setVisible(false);
            fxLogout.setVisible(true);
        } else {
            fxBud.setVisible(false);
            fxInnskraning.setVisible(true);
            fxNyskraning.setVisible(true);
            fxLogout.setVisible(false);
        }
    }

    /**
     * Handles the logout action. Resets the current user and navigates back to the
     * home screen.
     *
     * @param actionEvent The event that triggered the logout action.
     */
    @FXML
    protected void onLogout(ActionEvent actionEvent) {
        ViewSwitcher.setCurrentUser(null);
        ViewSwitcher.switchTo(View.HEIM);
    }

    /**
     * Handles navigation to the shopping screen.
     *
     * @param actionEvent The event that triggered this action.
     */
    @FXML
    protected void onKaupa(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.BUD);
    }

    /**
     * Handles navigation to the registration screen.
     *
     * @param actionEvent The event that triggered this action.
     */
    @FXML
    protected void onNyskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.NYSKRANING);
    }

    /**
     * Handles the event where the user presses the game button.
     * It checks if the user is logged in and has enough balance to proceed.
     * If not, it prompts the user to buy more or denies access.
     *
     * @param actionEvent The event that triggered this action.
     */
    @FXML
    protected void onKubburPressed(ActionEvent actionEvent) {
        if (ViewSwitcher.getCurrentUser() == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Þú þarft að skrá þig inn til að spila", ButtonType.OK);
            a.setHeaderText("Ekki skráður inn");
            a.show();
            return;
        }

        if (ViewSwitcher.getCurrentUser().getPeningur() < 20) {
            ButtonType bType = new ButtonType(ILAGI, ButtonBar.ButtonData.OK_DONE);
            ButtonType hType = new ButtonType(NEI, ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert a = new Alert(Alert.AlertType.WARNING, "Þú þarft a.m.k. 20 krónur til að spila. Kaupa meira?", bType,
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

    /**
     * Handles navigation to the login screen.
     *
     * @param actionEvent The event that triggered this action.
     */
    @FXML
    protected void onInnskraning(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.INNSKRANING);
    }

    /**
     * Handles mouse entering on the game button, changing its style.
     *
     * @param mouseEvent The mouse event that triggered this action.
     */
    @FXML
    protected void inKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburOut");
        fxKubbur.getStyleClass().add("kubburIn");
    }

    /**
     * Handles mouse exiting on the game button, changing its style back.
     *
     * @param mouseEvent The mouse event that triggered this action.
     */
    @FXML
    protected void outKubbur(MouseEvent mouseEvent) {
        fxKubbur.getStyleClass().remove("kubburIn");
        fxKubbur.getStyleClass().add("kubburOut");
    }
}