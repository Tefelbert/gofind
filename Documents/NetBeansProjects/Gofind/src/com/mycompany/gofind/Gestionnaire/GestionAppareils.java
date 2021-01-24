/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;

import com.mycompany.gofind.entities.Appareil;
import com.mycompany.gofind.entities.crud.AppareilDAO;
import java.sql.SQLException;

/**
 *
 * @author x22
 */
public class GestionAppareils {
    
                AppareilDAO app = new AppareilDAO();
    
        public void createAppareil(Appareil a) throws SQLException, Exception{
        
            app.createAppareil(a);
        
        //Ecrire le code de l'enaoie de mail ici.
       
}
}