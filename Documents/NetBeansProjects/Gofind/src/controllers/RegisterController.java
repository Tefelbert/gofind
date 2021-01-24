/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mycompany.gofind.entities.Utilisateur;
import com.mycompany.gofind.entities.crud.UtilisateurDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author Tef Elbert
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnSave;
    @FXML
    private ComboBox<String> txtGender;
    @FXML
    private TextField txtQuartier;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPasswordConfirm;
    @FXML
    Label lblStatus,lblStatuspass;
    
    /**
     * Initializes the controller class.
     */
    PreparedStatement preparedStatement;
    Connection connection;
    
    public RegisterController() {
        connection = (Connection) ConnectionUtil.conDB();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtGender.getItems().addAll("Male", "Female", "Other");
        txtGender.getSelectionModel().select("Male");
    }   
    
    @FXML
    private void HandleEvents(MouseEvent event) throws Exception{

        //check if not empty
        if (txtEmail.getText().isEmpty() || txtLogin.getText().isEmpty() ||txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty() ) {
            lblStatus.setTextFill(Color.RED);
            lblStatus.setText("Veuillez remplir tous les champs");
        }else if( txtPassword.getText().equals(txtPasswordConfirm.getText())){
            saveData();
        } else {
        	lblStatus.setTextFill(Color.RED);
                lblStatus.setText("les deux mot de passe ne correspondent pas !!!!");	
        }  
    }

    
    private void clearFields() {
        txtFirstname.clear();
        txtLastname.clear();
        txtEmail.clear();
        txtQuartier.clear();
        txtPassword.clear();
        txtPasswordConfirm.clear();
    }
        private String saveData() throws Exception {
          
            UtilisateurDAO user = new UtilisateurDAO();
            Utilisateur u = new Utilisateur();
          
            
            //u.setIdUtilisateur(1);
            try {
            u.setLogin(txtLogin.getText());
            u.setNom(txtFirstname.getText());
            u.setPassword(txtPassword.getText());
            u.setPrenom(txtLastname.getText());
            u.setQuartier(txtQuartier.getText());
            u.setSexe(txtGender.getValue().toString());
            u.setEmail(txtEmail.getText());
            user.create(u);
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Ajout reussit!!!");

            //clear fields
            clearFields();
            return "Success";
            
            } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());
            return "Exception";
            }
           
            

        }
        
}
