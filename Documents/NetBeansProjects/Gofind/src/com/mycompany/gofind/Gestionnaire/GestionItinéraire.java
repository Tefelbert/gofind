/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;

import com.mycompany.gofind.entities.Itineraire;
import com.mycompany.gofind.entities.crud.ItineraireDAO;
import java.sql.SQLException;

/**
 *
 * @author x22
 */
public class GestionItinéraire {
                ItineraireDAO itineraire = new ItineraireDAO();
    
        public void createItineraire(Itineraire i) throws SQLException, Exception{
        
            itineraire.createItineraire(i);
        
        //Ecrire le code de l'envoie de mail ici.
       
}
}
