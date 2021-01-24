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
public class Itineraire {
    int idTrajet;
    String pointDepart;
    String pointArrivee;
    String dateDepart;
    String dateArrive;
    int duree;
    int nombrePlace;

    public Itineraire() {
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public int getDuree() {
        return duree;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public String getPointArrivee() {
        return pointArrivee;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getPointDepart() {
        return pointDepart;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public void setPointArrivee(String pointArrivee) {
        this.pointArrivee = pointArrivee;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

   
    
}
