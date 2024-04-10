package com.api1.crudtienda.categoria.services;

import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.categoria.models.CategoriaModel;
import com.api1.crudtienda.categoria.repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAllCategoria(){
        return (List<CategoriaModel>) categoriaRepository.findAll();
    }

    public CategoriaModel CreateCategoria(CategoriaModel categoriaModel){
        return categoriaRepository.save(categoriaModel);
    }

    public CategoriaModel getCategoriaById(Long id){
        return categoriaRepository.findById(id).get();
    }

    public CategoriaModel updateCategoria (CategoriaModel categoriaModel, Long id){
        Optional<CategoriaModel> categoriaExist = categoriaRepository.findById(id);
        categoriaExist.get().setNombreCategoria(categoriaModel.getNombreCategoria());
        return categoriaRepository.save(categoriaExist.get());
    }


    public void delete(Long id){
        Optional<CategoriaModel> categoriaExist = categoriaRepository.findById(id);
        categoriaRepository.delete(categoriaExist.get());
    }

    public List<ArticulosModel> getAllArticuloByCategoria (Long id){
        CategoriaModel categoriaModel = categoriaRepository.findById(id).orElse(null);
            return categoriaRepository.findAllArticlesByCategory(categoriaModel);
    }
}
