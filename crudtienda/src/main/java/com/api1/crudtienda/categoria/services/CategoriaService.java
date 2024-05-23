package com.api1.crudtienda.categoria.services;

import com.api1.crudtienda.RequestResponseGeneric.ResponseGeneric;
import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.categoria.models.CategoriaModel;
import com.api1.crudtienda.categoria.repositories.ICategoriaRepository;
import com.api1.crudtienda.exception.exceptions.BadRequestException;
import com.api1.crudtienda.exception.exceptions.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final ICategoriaRepository categoriaRepository;

    public CategoriaService(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public ResponseGeneric findAllCategoria() {
        List<CategoriaModel> categoriaModels = (List<CategoriaModel>) categoriaRepository.findAll();
        if (categoriaModels.isEmpty()) {
            throw new NotFoundExeption("lista de categorias no disponibles", "404", HttpStatus.NOT_FOUND);
        }
        return new ResponseGeneric(LocalDateTime.now(), categoriaModels, "200");
    }

    public ResponseGeneric CreateCategoria(CategoriaModel categoriaModel) {

        if (categoriaModel.getNombreCategoria() == null || categoriaModel.getNombreCategoria().isEmpty()) {
            throw new BadRequestException("el nombre de la categoria no puede estar vacio o ser nulo", "400", HttpStatus.BAD_REQUEST);
        }

        if (categoriaRepository.existsByNombreCategoriaIgnoreCase(categoriaModel.getNombreCategoria())) {
            throw new BadRequestException("Ya existe una categoria con el mismo Nombre: " + categoriaModel.getNombreCategoria(), "400", HttpStatus.BAD_REQUEST);
        }
        return new ResponseGeneric(LocalDateTime.now(), categoriaRepository.save(categoriaModel), "201");
    }

    public ResponseGeneric getCategoriaById(Long id) {
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(id);
        if (categoriaModel.isEmpty()) {
            throw new NotFoundExeption("No existe la categoria solicitada", "404", HttpStatus.NOT_FOUND);
        }
        return new ResponseGeneric(LocalDateTime.now(), categoriaRepository.findById(id), "200");
    }

    public ResponseGeneric updateCategoria(CategoriaModel categoriaModel, Long id) {
        Optional<CategoriaModel> categoriaExist = categoriaRepository.findById(id);
        if (categoriaExist.isEmpty()) {
            throw new NotFoundExeption("No existe la categoria solicitada", "404", HttpStatus.NOT_FOUND);
        }

        if (categoriaRepository.existsByNombreCategoriaIgnoreCase(categoriaModel.getNombreCategoria()) && !categoriaExist.get().getNombreCategoria().equals(categoriaModel.getNombreCategoria())) {
            throw new BadRequestException("Ya existe una categoria con el mismo Nombre: " + categoriaModel.getNombreCategoria(), "400", HttpStatus.BAD_REQUEST);
        }

        categoriaExist.get().setNombreCategoria(categoriaModel.getNombreCategoria());
        return new ResponseGeneric(LocalDateTime.now(), categoriaRepository.save(categoriaExist.get()), "204");
    }


    public void delete(Long id) {
        Optional<CategoriaModel> categoriaExist = categoriaRepository.findById(id);
        if (categoriaExist.isEmpty()) {
            throw new NotFoundExeption("No existe la catgoria a eliminar", "404", HttpStatus.NOT_FOUND);
        }
        categoriaRepository.delete(categoriaExist.get());
    }

    public ResponseGeneric getAllArticuloByCategoria(Long id) {
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(id);
        if (categoriaModel.isEmpty()) {
            throw new NotFoundExeption("no la categoria solicitada", "404", HttpStatus.NOT_FOUND);
        }
        return new ResponseGeneric(LocalDateTime.now(),categoriaRepository.findAllArticlesByCategory(categoriaModel.get()),"200");
    }
}
