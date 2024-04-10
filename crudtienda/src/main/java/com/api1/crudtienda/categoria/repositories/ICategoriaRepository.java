package com.api1.crudtienda.categoria.repositories;

import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.categoria.models.CategoriaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaRepository extends CrudRepository<CategoriaModel, Long> {

    @Query("SELECT a FROM ArticulosModel a WHERE a.categoriaModel = :categoriaModel")
    List<ArticulosModel> findAllArticlesByCategory(@Param("categoriaModel") CategoriaModel categoriaModel);

}
