/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Itineraire;
import com.mycompany.gofind.entities.Itineraire;
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
public class ItineraireDAO {
    
   

    public void createItineraire(Itineraire u) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Itineraire (date_arrive,date_depart,point_arrive,point_depart,duree_voyage,nombre_place) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            
            statement.setString(1, u.getDateArrive());
            statement.setString(2, u.getDateDepart());
            statement.setString(3, u.getPointArrivee());
            statement.setString(4, u.getPointDepart());
            statement.setInt(5, u.getDuree());
            statement.setInt(6, u.getNombrePlace());         
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nouvelle Itineraire bien ajouter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

   public void updateItineraire(Itineraire i) throws SQLException, Exception {
        try {
            String sql = "Update Itineraire SET  date_arrive = '" + i.getDateArrive() + "', date_depart = '" + i.getDateDepart() + "', point_arrive = '" + i.getPointArrivee()+ "', point_depart = '" + i.getPointDepart()+ "', nombre_place = '" + i.getNombrePlace()+ "', duree_voyage = '" + i.getDuree()+ "' WHERE idItineraire = '" + i.getIdTrajet()+ "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Mis a jour Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

      public void suprimerItineraire(int idItineraire) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Itineraire WHERE idItineraire = '" + idItineraire + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
 public List<Itineraire> listItineraire() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM Itineraire";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            List<Itineraire> listIti = new ArrayList<>();

            while (result.next()) {
                Itineraire u = new Itineraire();

              //  u.setIdItineraire(count);
              //  result.getInt(1);
                u.setIdTrajet(result.getInt(1));
                u.setDateArrive(result.getString(2));
                u.setDateDepart(result.getString(3));
                u.setDuree(result.getInt(4));
                u.setNombrePlace(result.getInt(5));
                u.setPointArrivee(result.getString(6));
                u.setPointDepart(result.getString(7));

                listIti.add(u);

            }

            return listIti;
        } catch (SQLException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            ItineraireDAO uDao = new ItineraireDAO();
            
           

            System.out.println(uDao.listItineraire().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
