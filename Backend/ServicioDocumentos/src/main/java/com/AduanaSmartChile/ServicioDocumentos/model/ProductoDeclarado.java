package com.AduanaSmartChile.ServicioDocumentos.model;

import jakarta.persistence.*;

@Embeddable
public class ProductoDeclarado  {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer cantidad;

}
