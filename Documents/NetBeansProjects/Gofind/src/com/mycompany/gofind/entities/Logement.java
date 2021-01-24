/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofind.entities;

/**
 *
 * @author x22
 */
public class Logement {
    
    int idLogement;
    String nomProprio;
    String Localisation;
    String periode;
    String Duree;

    public String getDuree() {
        return Duree;
    }

    public int getIdLogement() {
        return idLogement;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public String getNomProprio() {
        return nomProprio;
    }

    public String getPeriode() {
        return periode;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public void setIdLogement(int idLogement) {
        this.idLogement = idLogement;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    public void setNomProprio(String nomProprio) {
        this.nomProprio = nomProprio;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
    
         
    
    
}


