package com.api1.crudtienda.articulo.services;

import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.articulo.repositories.IArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {
    @Autowired
    IArticuloRepository articuloRepository;

    public List<ArticulosModel> findAllArticle(){
        return (List<ArticulosModel>) articuloRepository.findAll();
    }

    public ArticulosModel createArticle(ArticulosModel articulo){
        return articuloRepository.save(articulo);
    }

    public ArticulosModel getArticleById(Long id){
        return articuloRepository.findById(id).get();
    }

    public ArticulosModel updateArticle(ArticulosModel articulo, Long id){
        Optional<ArticulosModel> articleExist = articuloRepository.findById(id);

        articleExist.get().setNombreArticulo(articulo.getNombreArticulo());
        articleExist.get().setDescripcionArticulo(articulo.getDescripcionArticulo());
        articleExist.get().setPrecio(articulo.getPrecio());
        articleExist.get().setStock(articulo.getStock());
        articleExist.get().setEstadoArticulo(articulo.getEstadoArticulo());
        articleExist.get().setCategoriaModel(articulo.getCategoriaModel());
        return articuloRepository.save(articleExist.get());
    }

    public void delete(Long id){
        articuloRepository.deleteById(id);
    }
}
