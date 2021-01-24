/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Logement;
import com.mycompany.gofind.entities.Logement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x22
 */
public class LogementDAO {
    
   

    public void createLogement(Logement u) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Logement (duree,localisation,nom_proprio,periode) VALUES ( ?, ?, ?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            
            statement.setString(1, u.getDuree());
            statement.setString(2, u.getLocalisation());
            statement.setString(3, u.getNomProprio());
            statement.setString(4, u.getPeriode());
            statement.setDate(5, new Date(System.currentTimeMillis()));          
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nouvelle Logement bien ajouter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

   public void updateLogement(Logement a) throws SQLException, Exception {
        try {
            String sql = "Update Logement SET  duree = '" + a.getDuree()+ "', localisation = '" + a.getLocalisation()+ "', periode = '" + a.getPeriode()+ "', nom_proprio = '" + a.getNomProprio()+ "' WHERE idLogement = '" + a.getIdLogement() + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Mis a jour Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

      public void suprimerLogement(int idLogement) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Logement WHERE idLogement = '" + idLogement + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

       public List<Logement> listLogement() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM Logement";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            List<Logement> listLoge = new ArrayList<>();

            while (result.next()) {
                Logement u = new Logement();

              //  u.setIdLogement(count);
              //  result.getInt(1);
                u.setIdLogement(result.getInt(1));
                u.setLocalisation(result.getString(2));
                u.setNomProprio(result.getString(3));
                u.setPeriode(result.getString(4));
                u.setDuree(result.getString(5));

                listLoge.add(u);

            }

            return listLoge;
        } catch (SQLException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            LogementDAO uDao = new LogementDAO();
            
           

            System.out.println(uDao.listLogement().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LogementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
