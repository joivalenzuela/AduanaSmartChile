package com.AduanaSmartChile.ServicioDocumentos.controller;

import com.AduanaSmartChile.ServicioDocumentos.model.DeclaracionJurada;
import com.AduanaSmartChile.ServicioDocumentos.service.DeclaracionJuradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documentos/declaraciones_juradas")
public class DeclaracionJuradaController {

    @Autowired
    private DeclaracionJuradaService declaracionJuradaService;

    @GetMapping
    public ResponseEntity<List<DeclaracionJurada>> listar() {
        List<DeclaracionJurada> declaraciones = declaracionJuradaService.findAll();
        if(declaraciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(declaraciones);
    }
}
