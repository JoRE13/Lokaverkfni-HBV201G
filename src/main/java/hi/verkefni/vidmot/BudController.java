package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;

public class BudController {
    @FXML
    protected void onHeim(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.HEIM);
    }

    @FXML
    protected void onGet50(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 50);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 50 krónur");
        a.show();
    }

    @FXML
    protected void onGet100(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 100);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 100 krónur");
        a.show();
    }

    @FXML
    protected void onGet150(ActionEvent actionEvent) {
        ViewSwitcher.getCurrentUser().setPeningur(ViewSwitcher.getCurrentUser().getPeningur() + 150);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Takk fyrir að kaupa!");
        a.setContentText("Þú hefur fengið 150 krónur");
        a.show();
    }

    public void initialize() {

    }

}
