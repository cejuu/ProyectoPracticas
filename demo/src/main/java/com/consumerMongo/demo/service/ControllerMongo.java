package com.consumerMongo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/api/baseDatos")
public class ControllerMongo {

    @Autowired
    ConsumerMongo consumerMongo;
    
    @GetMapping({ "/listarAll" })
    public String getDatos() {
        return consumerMongo.obtenerInfoMongo();
    }
    
}