package com.AduanaSmartChile.ServicioDocumentos.controller;

import com.AduanaSmartChile.ServicioDocumentos.model.DeclaracionJurada;
import com.AduanaSmartChile.ServicioDocumentos.service.DeclaracionJuradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<DeclaracionJurada> guardar(@RequestBody DeclaracionJurada declaracionJurada) {
        DeclaracionJurada declaracionNueva = declaracionJuradaService.save(declaracionJurada);
        return ResponseEntity.status(HttpStatus.CREATED).body(declaracionNueva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeclaracionJurada> buscar(@PathVariable Long id) {
        try {
            DeclaracionJurada declaracionJurada = declaracionJuradaService.findbyId(id);
            return ResponseEntity.ok(declaracionJurada);
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeclaracionJurada> actualizar(@PathVariable Long id,
                                                        @RequestBody DeclaracionJurada declaracionJurada) {
        try {
            DeclaracionJurada dj = declaracionJuradaService.findbyId(id);
            dj.setId(id);
            dj.setFecha(declaracionJurada.getFecha());
            dj.setRunDeclarante(declaracionJurada.getRunDeclarante());
            dj.setProductos(declaracionJurada.getProductos());
            dj.setEstaAprobada(declaracionJurada.isEstaAprobada());

            declaracionJuradaService.save(dj);
            return  ResponseEntity.ok(declaracionJurada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            declaracionJuradaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }


}
