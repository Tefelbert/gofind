/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;

import com.mycompany.gofind.entities.Logement;
import com.mycompany.gofind.entities.crud.LogementDAO;
import java.sql.SQLException;

/**
 *
 * @author x22
 */
public class GestionLogements {
                LogementDAO loge = new LogementDAO();
    
        public void createLogement(Logement l) throws SQLException, Exception{
        
            loge.createLogement(l);
        
        //Ecrire le code de l'enloie de mail ici.
       
        }}
