package com.AduanaSmartChile.ServicioDocumentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Declaracion_Jurada")
@NoArgsConstructor
@AllArgsConstructor
public class DeclaracionJurada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 13, nullable = false)
    private String runDeclarante;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    @org.hibernate.annotations.ColumnDefault("false")
    private boolean estaAprobada;

    @ElementCollection
    @CollectionTable(name = "productos_declarados",
            joinColumns = @JoinColumn(name = "Declaracion_Jurada"))
    private List<ProductoDeclarado> productos = new ArrayList<>();

}
