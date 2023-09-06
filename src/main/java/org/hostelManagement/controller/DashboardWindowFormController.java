package org.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.hostelManagement.util.timeDate.TimeDate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardWindowFormController implements Initializable {

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblTime;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblTimeTop;
    @FXML
    private Label lblDateTop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TimeDate.localDateAndTime(lblDate, lblTime);
        TimeDate.localDateAndTime(lblDateTop, lblTimeTop);

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {

        setUI("student_window_form");

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/login_window_form.fxml"));
            loadWindow(anchorPane);
            mainRoot.getChildren().clear();
            mainRoot.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void btnResavationOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/reservation_window_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnRoomOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/room_window_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/user_window_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWindow(AnchorPane anchorPane) {
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    private void setUI(String windowName){
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/"+windowName+".fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
