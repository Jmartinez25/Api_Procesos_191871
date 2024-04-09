package com.api1.crudtienda.services;

import com.api1.crudtienda.models.ArticulosModel;
import com.api1.crudtienda.repositories.IArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

        articleExist.get().setName(articulo.getName());
        articleExist.get().setDescription(articulo.getDescription());
        articleExist.get().setPrice(articulo.getPrice());
        articleExist.get().setStock(articulo.getStock());
        return articuloRepository.save(articleExist.get());
    }

    public void delete(Long id){
        articuloRepository.deleteById(id);
    }
}
