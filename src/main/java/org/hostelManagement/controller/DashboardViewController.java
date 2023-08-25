package org.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardViewController {

    @FXML
    private AnchorPane dashboardMainPane;

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) dashboardMainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login-view.fxml"))));

        stage.centerOnScreen();
        stage.show();
    }
}
