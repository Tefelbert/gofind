/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author x22
 */
public class CovoiturageController implements Initializable {

    @FXML
    private AnchorPane rootMainMenuAdmin;
    @FXML
    private JFXButton btnDeleteItem;
    @FXML
    private JFXButton btnUpdateItem;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnMainMenu;
    @FXML
    private JFXButton btnAddItem;
    @FXML
    private TextField txtSearch;
    @FXML
    private JFXButton btnMainMenu1;
    @FXML
    private JFXButton btnUpdateItem1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteItem(ActionEvent event) {
    }

    @FXML
    private void updateItem(ActionEvent event) {
    }

    @FXML
    private void btnLogOut(ActionEvent event) {
    }

    @FXML
    private void btnMainMenu(ActionEvent event) {
    }

    @FXML
    private void addItem(ActionEvent event) {
    }
    
}
