package org.hostelManagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hostelManagement.bo.BOFactory;
import org.hostelManagement.bo.custom.DashBoardBO;
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
    private Label lblTimeTop;
    @FXML
    private Label lblDateTop;

    @FXML
    private Label lblTime;
    @FXML
    private Label lblDate;


    @FXML
    private Text lblAvailableRooms;

    @FXML
    private Text lblBookedRooms;

    @FXML
    private Text lblREGStu;

    private DashBoardBO dashboardBO = (DashBoardBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DASHBOARD);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TimeDate.localDateAndTime(lblDateTop, lblTimeTop);
        TimeDate.localDateAndTime(lblDate, lblTime);

        try {
            setTotReservedRoomsCount();
            setTotAvailableRoomsCount();
            setREGStuCount();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setREGStuCount() throws Exception {
        lblREGStu.setText(String.valueOf(dashboardBO.getREGStuCount()));

    }

    private void setTotAvailableRoomsCount() throws Exception {
        lblAvailableRooms.setText(String.valueOf(dashboardBO.getTotOfAvailableRoomsCount()));

    }

    private void setTotReservedRoomsCount() throws Exception {
        lblBookedRooms.setText(String.valueOf(dashboardBO.getAllReservationCount()));
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        setUI("/view/student_window_form.fxml");
    }


    @FXML
    void btnRoomOnAction(ActionEvent event) throws IOException {
        setUI("/view/room_window_form.fxml");
    }


    @FXML
    void btnResavationOnAction(ActionEvent event) throws IOException {
        setUI("/view/reservation_window_form.fxml");
    }


    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        setUI("/view/user_window_form.fxml");
    }

//    private void setUI(String windowName){
//        AnchorPane anchorPane = null;
//        try {
//            anchorPane = FXMLLoader.load(getClass().getResource("/view/"+windowName+".fxml"));
//            loadWindow(anchorPane);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    private void setUI(String location) throws IOException {

        Parent load = FXMLLoader.load(getClass().getResource(location));
        root.getChildren().clear();
        root.getChildren().add(load);

    }

    private void loadWindow(AnchorPane anchorPane) {
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
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
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader= new FXMLLoader(LoginWindowFormController.class.getResource("/view/dashboard_window_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        thisStage.setScene(scene);
        //thisStage.setMaximized(true);
    }

}
