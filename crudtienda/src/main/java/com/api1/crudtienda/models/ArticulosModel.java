package com.api1.crudtienda.models;

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

    private String name;

    private String description;

    private Number stock;

    private String price;

}
