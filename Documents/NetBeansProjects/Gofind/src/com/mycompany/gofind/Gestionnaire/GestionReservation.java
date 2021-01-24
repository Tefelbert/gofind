/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;


import com.mycompany.gofind.entities.Reservation;
import com.mycompany.gofind.entities.crud.ReservationDAO;

import java.sql.SQLException;

/**
 *
 * @author x22
 */
public class GestionReservation {
                ReservationDAO reserv = new ReservationDAO();
    
        public void createReservation(Reservation r) throws SQLException, Exception{
        
            reserv.createReservation(r);
        
        //Ecrire le code de l'envoie de mail ici.
        
    }

}
