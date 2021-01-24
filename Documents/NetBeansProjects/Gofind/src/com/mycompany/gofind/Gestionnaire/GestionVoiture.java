/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;

import com.mycompany.gofind.entities.Voiture;
import com.mycompany.gofind.entities.crud.VoitureDAO;
import java.sql.SQLException;

/**
 *
 * @author x22
 */
public class GestionVoiture {
    
            VoitureDAO voit = new VoitureDAO();
    
        public void createVoiture(Voiture v) throws SQLException, Exception{
        
            voit.createVoiture(v);
        
        //Ecrire le code de l'envoie de mail ici.
        
    }

   
  }

