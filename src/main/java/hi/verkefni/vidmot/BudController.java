package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;

/**
 * Controller class for handling user interactions in the application.
 * This class is responsible for responding to user actions, such as button
 * clicks,
 * and updating the user's balance accordingly.
 */
public class BudController {

    /**
     * Handles the action when the 'Home' button is clicked.
     * Switches the view back to the home screen.
     *
     * @param actionEvent The event that triggered the method.
     */
    @FXML
    protected void onHeim(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.HEIM);
    }

    /**
     * Handles the action when the 'Get 50' button is clicked.
     * Adds 50 currency units to the current user's balance and shows a confirmation
     * alert.
     *
     * @param actionEvent The event that triggered the method.
     */
    @FXML
    protected void onGet50(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 50);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 50 krónur");
        a.show();
    }

    /**
     * Handles the action when the 'Get 100' button is clicked.
     * Adds 100 currency units to the current user's balance and shows a
     * confirmation alert.
     *
     * @param actionEvent The event that triggered the method.
     */
    @FXML
    protected void onGet100(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 100);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 100 krónur");
        a.show();
    }

    /**
     * Handles the action when the 'Get 150' button is clicked.
     * Adds 150 currency units to the current user's balance and shows a
     * confirmation alert.
     *
     * @param actionEvent The event that triggered the method.
     */
    @FXML
    protected void onGet150(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 150);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 150 krónur");
        a.show();
    }

    /**
     * Initializes the controller. This method is called after the FXML fields have
     * been injected.
     * Currently, this method does not contain implementation but can be used to
     * perform
     * any necessary setup for the controller.
     */
    public void initialize() {

    }

}
