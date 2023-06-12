package com.hpecds.academy2.ApiSatelites.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hpecds.academy2.ApiSatelites.model.Piloto;

@RestController
@RequestMapping(path = "/api/infoPilotos")
public class PilotoController {

    @Autowired
    PilotoService pilotoService;

    @GetMapping({ "/list" })
    public String getFormulario() {
        return "<html><body><h2>Introduzca del piloto:</h2><form method=\"POST\" action=\"/api/infoPilotos/tiempo\"><input type=\"text\" name=\"ciudad\"><br/><br/><input type=\"submit\" value=\"Consultar\"></form></body></html>";
    }

    @PostMapping("/tiempo")
    public ResponseEntity<?> getTiempo(@RequestParam String piloto) {

        Piloto tiempo = pilotoService.getNombrePiloto(piloto);

        if (tiempo != null) {
            return ResponseEntity.ok().body(tiempo);
        } else {
            return ResponseEntity.internalServerError().body("La piloto no existe");
        }
    }
}
