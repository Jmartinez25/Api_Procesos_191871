package com.api1.crudtienda.articulo.repositories;

import com.api1.crudtienda.articulo.models.ArticulosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticuloRepository extends JpaRepository<ArticulosModel, Long> {
    boolean existsByNombreArticuloIgnoreCase(String nombreArticulo);
}
