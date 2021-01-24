/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Reservation;
import com.mycompany.gofind.entities.Reservation;
import com.mycompany.gofind.entities.Utilisateur;
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
public class ReservationDAO {
    

   

    public void createReservation(Reservation r) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Reservation (date_reservation,logement_de,Reservation) VALUES (?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            
            statement.setDate(1, new Date(System.currentTimeMillis()));
            statement.setString(2, r.getLogement().getNomProprio());
            statement.setString(3, r.getUtilisateur().getLogin());
            statement.setDate(7, new Date(System.currentTimeMillis()));
   
            
            
            
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

   public void updateReservation(Reservation r) throws SQLException, Exception {
        try {
            String sql = "Update Reservation SET  date_reservation = '" + r.getDateReservation() + "',  logement_de = '" + r.getLogement().getNomProprio() + "',  Reservation = '" + r.getUtilisateur().getLogin()+ "' WHERE idReservation = '" + r.getIdReservation()+ "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Modification Réussie!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
 public void suprimerReservation(int idReservation) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Reservation WHERE idReservation = '" + idReservation + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
 
 
  public List<Reservation> listReservation() throws SQLException, Exception {
        try {
            String sql = "SELECT  * FROM Reservation";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            List<Reservation> listReserv = new ArrayList<>();

            while (result.next()) {
                Reservation u = new Reservation();
              //  u.setIdReservation(count);
              //  result.getInt(1);
                u.setIdReservation(result.getInt(1));
                u.setDateReservation(result.getString(2));
//                u.setLogement(result.getString(3));
              // u.setUtilisateur(result.getString(4));
          

                listReserv.add(u);

            }

            return listReserv;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            ReservationDAO uDao = new ReservationDAO();
            
           

            System.out.println(uDao.listReservation().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
