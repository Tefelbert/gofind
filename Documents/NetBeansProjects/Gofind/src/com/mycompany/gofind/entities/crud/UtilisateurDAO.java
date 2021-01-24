/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;


import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Utilisateur;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author willyk
 */
public class UtilisateurDAO {

    public Utilisateur findByLoginAndPassword(String login, String password) throws SQLException, Exception {
        try {
            String sql = "SELECT idUtilisateur, login, nom, password, prenom, quartier, sexe, dateCreation , email FROM Utilisateur where login='" + login + "' and password='" + password + "'";

            Statement statement = JDBCExample.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            Utilisateur u = null;

            while (result.next()) {
                u = new Utilisateur();
                
                u.setIdUtilisateur(result.getInt(1));
                u.setLogin(result.getString(2));
                u.setNom(result.getString(3));
                u.setPassword(result.getString(4));
                u.setPrenom(result.getString(5));
                u.setQuartier(result.getString(6));
                u.setSexe(result.getString(7));
                u.setDateCreation(result.getString(8));
                u.setEmail(result.getString(9));
            }

            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public Utilisateur findByIdUser(int idUser) throws SQLException, Exception {
        try {
            String sql = "SELECT idUtilisateur, login, nom, password, prenom, quartier, sexe, dateCreation, email FROM Utilisateur where idUtilisateur='" + idUser + "'";

            Statement statement = JDBCExample.getConnection().createStatement();

            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            Utilisateur u = new Utilisateur();

            while (result.next()) {

                u.setIdUtilisateur(result.getInt(1));
                u.setLogin(result.getString(2));
                u.setNom(result.getString(3));
                u.setPassword(result.getString(4));
                u.setPrenom(result.getString(5));
                u.setQuartier(result.getString(6));
                u.setSexe(result.getString(7));
                u.setDateCreation(result.getString(8));
                u.setEmail(result.getString(9));

            }

            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public ObservableList<Utilisateur> listUtilisateur() throws SQLException, Exception {
        try {
            String sql = "SELECT idUtilisateur, login, nom, password, prenom, quartier, sexe, dateCreation, email FROM Utilisateur";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            ObservableList<Utilisateur> listUser = FXCollections.observableArrayList();
            Utilisateur user;
            while (result.next()) {               
                 user = new Utilisateur(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
                 listUser.add(user);
            }

            return listUser;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public void create(Utilisateur u) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Utilisateur (nom, prenom, login, password, quartier, sexe, dateCreation,email) VALUES (?,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            statement.setString(1, u.getNom());
            statement.setString(2, u.getPrenom());
            statement.setString(3, u.getLogin());
            statement.setString(4, u.getPassword());
            statement.setString(5, u.getQuartier());
            statement.setString(6, u.getSexe());
            statement.setDate(7, new Date(System.currentTimeMillis()));
            statement.setString(8, u.getEmail());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public void update(Utilisateur u) throws SQLException, Exception {
        try {
            String sql = "Update Utilisateur SET email = '" + u.getEmail()+ "', nom = '" + u.getNom() + "', prenom = '" + u.getPrenom() + "', login = '" + u.getLogin() + "', password = '" + u.getPassword() + "' WHERE idUtilisateur = '" + u.getIdUtilisateur() + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Mis a jour reussie !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
    
    
     public void suprimerUtilisateur(int idUtilisateur) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Utilisateur WHERE idUtilisateur = '" + idUtilisateur + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            UtilisateurDAO uDao = new UtilisateurDAO();
            Utilisateur u = new Utilisateur();


            System.out.println(uDao.listUtilisateur().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
