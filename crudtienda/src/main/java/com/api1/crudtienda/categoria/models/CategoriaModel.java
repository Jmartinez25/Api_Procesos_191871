package com.api1.crudtienda.categoria.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCategoria;

    private String descripcionCategoria;
}
