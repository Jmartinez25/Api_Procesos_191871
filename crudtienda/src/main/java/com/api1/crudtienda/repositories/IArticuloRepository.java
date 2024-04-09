package com.api1.crudtienda.repositories;

import com.api1.crudtienda.models.ArticulosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticuloRepository extends JpaRepository<ArticulosModel, Long> {

}
