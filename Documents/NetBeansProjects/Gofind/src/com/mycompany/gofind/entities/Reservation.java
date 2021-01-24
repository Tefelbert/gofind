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
public class Reservation {
    int idReservation;
    Logement logement;
    Utilisateur utilisateur;
    String dateReservation;

    public String getDateReservation() {
        return dateReservation;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Logement getLogement() {
        return logement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
}
