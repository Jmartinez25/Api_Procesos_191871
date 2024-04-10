package com.api1.crudtienda.articulo.models;

import com.api1.crudtienda.categoria.models.CategoriaModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;

@Data
@Entity
@Table(name = "articulo")
public class ArticulosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArticulo;

    private String descripcionArticulo;

    private Number stock;

    private double precio;

    private String estadoArticulo;

    @ManyToOne
    @JoinColumn(name = "categoriaModel")
    private CategoriaModel categoriaModel;
}
