package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OpinionesController {

    private final RestTemplate restTemplate;

    public OpinionesController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/productos")
    public Object obtenerProductos() {
        return restTemplate.getForObject(
                "http://micro-productos-service/api/productos",
                Object.class
        );
    }

    @PostMapping("/opinion")
    public String recibirOpinion(@RequestBody String opinion) {
        System.out.println("Opinión recibida: " + opinion);
        return "Opinión recibida correctamente";
    }
}