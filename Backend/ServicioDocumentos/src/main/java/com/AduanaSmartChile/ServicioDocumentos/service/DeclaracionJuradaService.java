package com.AduanaSmartChile.ServicioDocumentos.service;

import com.AduanaSmartChile.ServicioDocumentos.model.DeclaracionJurada;
import com.AduanaSmartChile.ServicioDocumentos.repository.DeclaracionJuradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DeclaracionJuradaService {

    @Autowired
    private DeclaracionJuradaRepository declaracionJuradaRepository;

    public List<DeclaracionJurada> findAll() {
        return declaracionJuradaRepository.findAll();
    }

    public DeclaracionJurada findbyId(long id) {
        return declaracionJuradaRepository.findById(id).get();
    }

    public DeclaracionJurada save(DeclaracionJurada declaracionJurada) {
        return declaracionJuradaRepository.save(declaracionJurada);
    }

    public void delete(Long id) {
        declaracionJuradaRepository.deleteById(id);
    }
}
