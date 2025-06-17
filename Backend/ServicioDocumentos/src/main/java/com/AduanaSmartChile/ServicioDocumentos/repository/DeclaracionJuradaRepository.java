package com.AduanaSmartChile.ServicioDocumentos.repository;

import com.AduanaSmartChile.ServicioDocumentos.model.DeclaracionJurada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclaracionJuradaRepository extends JpaRepository<DeclaracionJurada,Long> {
}
