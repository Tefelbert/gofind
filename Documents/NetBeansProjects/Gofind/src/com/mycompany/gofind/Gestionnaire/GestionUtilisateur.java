/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.Gestionnaire;

import com.mycompany.gofind.entities.Utilisateur;
import com.mycompany.gofind.entities.crud.UtilisateurDAO;
import java.sql.SQLException;

/**
 *
 * @author willyk
 */
public class GestionUtilisateur {
    
    UtilisateurDAO userDAO  = new UtilisateurDAO();
    
    public void createUtilisateur(Utilisateur u) throws SQLException, Exception{
        
        userDAO.create(u);
        
        //Ecrire le code de l'envoie de mail ici.
        
    }
    
    public void  suprimerUtilisateur(int id){
        try{
            userDAO.suprimerUtilisateur(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
