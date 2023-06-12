package com.hpecds.academy3.ConsumerKafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final MongoTemplate mongoTemplate;

    public ConsumerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @KafkaListener(topics = "datosPitlos")
    public void receiveMessage(String message) {
        System.out.println("El último tiempo consultado es: " + message);

        DatosPiloto datosPitlos = new DatosPiloto();
        datosPitlos.setMensaje(message);

        mongoTemplate.insert(datosPitlos, "mensajesKafka");
    }
}