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
public class Appareil {
    int idAppareil;
    String marque;
    String imei;

    public Appareil() {
        this.idAppareil =0;
        this.marque = "";
        this.imei = "";
    }

    public int getIdAppareil() {
        return idAppareil;
    }

    public String getImei() {
        return imei;
    }

    public String getMarque() {
        return marque;
    }

    public void setIdAppareil(int idAppareil) {
        this.idAppareil = idAppareil;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    

    
}
