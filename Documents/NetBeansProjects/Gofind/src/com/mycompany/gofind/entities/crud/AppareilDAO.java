/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities.crud;

import com.jdbc.JDBCExample;
import com.mycompany.gofind.entities.Appareil;
import com.mycompany.gofind.entities.Appareil;
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
public class AppareilDAO {
    
    


   

    public void createAppareil(Appareil u) throws SQLException, Exception {
        try {
            String sql = "INSERT INTO Appareil (marque,imei,date_ajout_appareil) VALUES (?, ?, ?)";

            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
            
            statement.setString(1, u.getMarque());
            statement.setString(2, u.getImei());
            statement.setDate(3, new Date(System.currentTimeMillis()));          
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Nouvelle appareil bien ajouter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

   public void updateAppareil(Appareil a) throws SQLException, Exception {
        try {
            String sql = "Update Appareil SET  imei = '" + a.getImei() + "', marque = '" + a.getMarque() + "' WHERE idAppareil = '" + a.getIdAppareil() + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Mis a jour Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

      public void suprimerAppareil(int idAppareil) throws SQLException, Exception {
        try {
            String sql = " DELETE FROM Appareil WHERE idAppareil = '" + idAppareil + "'";
            PreparedStatement statement = JDBCExample.getConnection().prepareStatement(sql);
     
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Supression Effectuer!!!!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
 public List<Appareil> listAppareil() throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM Appareil";

            Statement statement = JDBCExample.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            List<Appareil> listApp = new ArrayList<>();

            while (result.next()) {
                Appareil a = new Appareil();

              //  u.setIdAppareil(count);
              //  result.getInt(1);
                a.setIdAppareil(result.getInt(1));
                a.setImei(result.getString(2));
                a.setMarque(result.getString(3));
                listApp.add(a);

            }

            return listApp;
        } catch (SQLException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);

            throw new SQLException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }

    public static void main(String[] arg) {
        try {
            AppareilDAO uDao = new AppareilDAO();
            Appareil app = new Appareil();
            
            app.setImei("12sdf4554553g4");
            app.setMarque("samsung");          
            uDao.createAppareil(app);      
            System.out.println(uDao.listAppareil().size()); /*+ " " + uDao.findByLoginAndPassword("willy", "willy1234").getLogin());*/
        } catch (SQLException ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AppareilDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
