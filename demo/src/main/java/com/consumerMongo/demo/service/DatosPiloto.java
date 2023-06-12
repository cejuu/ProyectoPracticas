package com.consumerMongo.demo.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "datosPilotos")
public class DatosPiloto {

    @Id
    private String id;
    private String mensaje;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "pilotos [id=" + id + ", mensaje=" + mensaje + "]";
    }
}