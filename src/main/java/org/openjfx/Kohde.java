package org.openjfx;

import scalafx.scene.input.KeyCode;

public class Kohde {

    String nimi;
    String osoite;
    String vuosi;
    String vuokra;

    public Kohde(String nimi, String osoite, String vuosi, String vuokra) {
        this.nimi = nimi;
        this.osoite = osoite;
        this.vuosi = vuosi;
        this.vuokra = vuokra;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }

    public void setVuokra(String vuokra) {
        this.vuokra = vuokra;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public String getVuosi() {
        return vuosi;
    }

    public String getVuokra() {
        return vuokra;
    }

}
