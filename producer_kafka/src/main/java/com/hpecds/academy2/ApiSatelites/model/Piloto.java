package com.hpecds.academy2.ApiSatelites.model;

public class Piloto {

    private String nombrePiloto;
    private Integer escuderiaPiloto;
    private String puntosMundial;
    private String pais;

    public String getNombrePiloto() {
        return this.nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public Integer getEscuderiaPiloto() {
        return this.escuderiaPiloto;
    }

    public void setEscuderiaPiloto(Integer escuderiaPiloto) {
        this.escuderiaPiloto = escuderiaPiloto;
    }

    public String getPuntosMundial() {
        return this.puntosMundial;
    }

    public void setPuntosMundial(String puntosMundial) {
        this.puntosMundial = puntosMundial;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Piloto [nombre=" + nombrePiloto + ", escuderiaPiloto=" + escuderiaPiloto + ", puntosMundial="
                + puntosMundial
                + ", pais=" + pais + "]";
    }

}
