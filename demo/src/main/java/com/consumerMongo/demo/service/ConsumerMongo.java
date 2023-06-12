package com.consumerMongo.demo.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsumerMongo {

    private final MongoTemplate mongoTemplate;

    public ConsumerMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String obtenerInfoMongo() {
        Query query = new Query();
        List<DatosPiloto> resultados = mongoTemplate.find(query, DatosPiloto.class, "mensajesKafka");
        // Haz algo con los resultados obtenidos
        for (DatosPiloto tiempoCiudad : resultados) {
            System.out.println(tiempoCiudad.getMensaje());
        }
        return resultados.toString();
    }
}
