/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Voiture;
import com.mycompany.gofind.entities.Voiture;
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
public class VoitureDAO {
      

    public void createVoiture(Voiture u) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Voiture (marque,nombre_place,date_ajout) VALUES ( ?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            
            statement.setString(1, u.getMarqueVoiture());
            statement.setInt(2, u.getNbrePlace());        
            statement.setDate(3, new Date(System.currentTimeMillis()));
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nouvelle Voiture bien ajouter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

   public void updateVoiture(Voiture i) throws SQLException, Exception {
        try {
            String sql = "Update Voiture SET  marque = '" + i.getMarqueVoiture() + "', nombre_place = '" + i.getNbrePlace()+ "' WHERE idVoiture = '" + i.getIdVoiture()+ "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Mis a jour Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

      public void suprimerVoiture(int idVoiture) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Voiture WHERE idVoiture = '" + idVoiture + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

         public List<Voiture> listVoiture() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM Voiture";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            List<Voiture> listVoit = new ArrayList<>();

            while (result.next()) {
                Voiture u = new Voiture();

              //  u.setIdVoiture(count);
              //  result.getInt(1);
                u.setIdVoiture(result.getInt(1));
                u.setMarqueVoiture(result.getString(2));
                u.setNbrePlace(result.getInt(3));
                listVoit.add(u);

            }

            return listVoit;
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            VoitureDAO uDao = new VoitureDAO();
            
           

            System.out.println(uDao.listVoiture().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VoitureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
