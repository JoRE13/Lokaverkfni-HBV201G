package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class BudController {
    @FXML
    protected void onHeim(ActionEvent actionEvent){
        ViewSwitcher.switchTo(View.HEIM);
    }

    public void initialize(){


    }

}
