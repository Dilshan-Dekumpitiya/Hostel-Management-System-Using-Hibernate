package org.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    void onAction(ActionEvent event) throws IOException, RuntimeException {
        Stage stage = (Stage) pane.getScene().getWindow();


        Stage stage2 = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_window_form.fxml"))));
        stage.setTitle("D24 Hostel Management System");

        //stage.setMaximized(true);

     //   stage.close();

        //stage2.show();
        stage.show();
    }

}
