package com.hpecds.academy2.ApiSatelites.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.PutExchange;

import com.hpecds.academy2.ApiSatelites.model.Piloto;
import com.hpecds.academy2.ApiSatelites.service.kafka.ProducerKafka;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProducerKafka producerKafka;

    public Piloto getNombrePiloto(String pilotoNombre) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "841a61941emsh3c81b21df19f593p16b638jsnc4b7cb5dac36");
        headers.set("X-RapidAPI-Host", "rapidapi.com/dariuxmx/api/formula-1-standings/");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        final ResponseEntity<String> responseAPIF1 = restTemplate
                .exchange("https://rapidapi.com/dariuxmx/api/formula-1-standings/" + pilotoNombre, HttpMethod.GET,
                        requestEntity, String.class);

        if (responseAPIF1.getStatusCode().equals(HttpStatus.OK)) {
            JSONObject response = new JSONObject(responseAPIF1.getBody());

            JSONObject infoDatosF1 = response.getJSONObject("location");
            String nombreDatos = infoDatosF1.getString("name");
            String escuderiaDatos = infoDatosF1.getString("region");
            String paisDatos = infoDatosF1.getString("country");
            String puntosDatos = infoDatosF1.getString("localtime");

            Piloto datosEnviar = new Piloto();

            producerKafka.sendMessageToKafka(datosEnviar.toString());
            return datosEnviar;
        }

        return null;

    }
}
