package org.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private AnchorPane loginPane;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) loginPane.getScene().getWindow();


        Stage stage2 = new Stage();
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard-view.fxml"))));
        stage2.setTitle("Dashboard");

        stage2.setMaximized(true);


        stage.close();

        stage2.show();
    }
}
