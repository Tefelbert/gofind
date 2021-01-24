/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Utilisateur;
import com.mycompany.gofind.entities.crud.UtilisateurDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author x22
 */
public class ListeController implements Initializable {

    @FXML
    private Button btnRecherche;
    @FXML
    private TextField txtNom;
    @FXML
    private ImageView img;
    @FXML
    private TextField txtQuartier;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TableView<Utilisateur> tvUser;
    @FXML
    private TableColumn<Utilisateur, Integer> colId;
    @FXML
    private TableColumn<Utilisateur, String> colNom;
    @FXML
    private TableColumn<Utilisateur, String> colPrenom;
    @FXML
    private TableColumn<Utilisateur, String> colEmail;
    @FXML
    private TableColumn<Utilisateur, String> colDate;
    @FXML
    private TableColumn<Utilisateur, String> colQuartier;
    @FXML
    private Pane txtlabel;
    @FXML
    private Label txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            showUser();
        } catch (Exception ex) {
            Logger.getLogger(ListeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 

     
    public void showUser() throws Exception{
        
        UtilisateurDAO lit = new UtilisateurDAO();
        ObservableList<Utilisateur> list = lit.listUtilisateur();
        colId.setCellValueFactory(new PropertyValueFactory<Utilisateur,Integer>("idUtilisateur"));
        colNom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
        colQuartier.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("quartier"));
        colDate.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("dateCreation"));
        tvUser.setItems(list);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

  
  
 
     }
    

