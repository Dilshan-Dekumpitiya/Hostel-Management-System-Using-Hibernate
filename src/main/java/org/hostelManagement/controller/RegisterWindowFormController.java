package org.hostelManagement.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hostelManagement.bo.BOFactory;
import org.hostelManagement.bo.custom.UserBO;
import org.hostelManagement.dto.UserDTO;
import org.hostelManagement.util.regex.RegExFactory;
import org.hostelManagement.util.regex.RegExType;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWindowFormController implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtRePassword;

    @FXML
    private PasswordField txtPasswordHint;

    @FXML
    private JFXButton btnRegister;
    private RegExFactory regExFactory;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        regExFactory = RegExFactory.getInstance();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        if(validity()) {
            String user_name = txtUserName.getText();
            String user_password = txtPassword.getText();
            String user_re_password = txtRePassword.getText();
            String password_hint = txtPasswordHint.getText();

            if(checkRegex()) {
                UserDTO userDTO = new UserDTO(user_name, user_password, user_re_password);

                UserDTO isExit = (UserDTO) userBO.searchUser(user_name);
                if (isExit == null) {
                    boolean isAdded = userBO.addUser(userDTO);


                    if (isAdded) {
                        new Alert(Alert.AlertType.CONFIRMATION, "User Registered!").show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "User is already Registered!").show();
                }
            }else {

                new Alert(Alert.AlertType.ERROR, "User name or Password type is not match!").show();
            }
        }else{

            new Alert(Alert.AlertType.ERROR, "Please fill all field :( !!!").show();
        }

    }

    private boolean checkRegex() {
        return regExFactory.getPattern(RegExType.NAME).matcher(txtUserName.getText()).matches() &&
                regExFactory.getPattern(RegExType.PASSWORD).matcher(txtPassword.getText()).matches() &&
                txtPassword.getText().equals(txtRePassword.getText());
    }

    private boolean validity() {

        return !txtUserName.getText().isEmpty() &&
                !txtPassword.getText().isEmpty() &&
                !txtRePassword.getText().isEmpty() &&
                !txtPasswordHint.getText().isEmpty();


    }

    @FXML
    void txtPasswordHintOnAction(ActionEvent event) {
        btnRegister.fire();

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        txtRePassword.requestFocus();

    }

    @FXML
    void txtRePasswordOnAction(ActionEvent event) {
        txtPasswordHint.requestFocus();

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

        txtPassword.requestFocus();

    }

}
