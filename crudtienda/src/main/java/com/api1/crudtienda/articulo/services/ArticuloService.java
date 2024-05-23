package com.api1.crudtienda.articulo.services;

import com.api1.crudtienda.RequestResponseGeneric.ResponseGeneric;
import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.articulo.repositories.IArticuloRepository;
import com.api1.crudtienda.exception.exceptions.BadRequestException;
import com.api1.crudtienda.exception.exceptions.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {
    private final IArticuloRepository articuloRepository;

    public ArticuloService(IArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public ResponseGeneric findAllArticle(){
        List<ArticulosModel> articulosModels = articuloRepository.findAll();
        if (articulosModels.isEmpty()){
            throw new NotFoundExeption("no existen articulos creados","404", HttpStatus.NOT_FOUND);
        }
        return new ResponseGeneric(LocalDateTime.now(),articulosModels,"200");
    }

    public ResponseGeneric createArticle(ArticulosModel articulo){

        if (articulo.getNombreArticulo() == null || articulo.getNombreArticulo().isEmpty()){
            throw new BadRequestException("nombre del articulo es obligatorio","400",HttpStatus.BAD_REQUEST);
        }

        if (articulo.getPrecio() <= 0.0){
            throw new BadRequestException("el precio del articulo tiene que ser mayor que 0","400",HttpStatus.BAD_REQUEST);
        }

        if (articulo.getStock() <= 0){
            throw new BadRequestException("el stock del articulo tiene que ser mayor que 0","400",HttpStatus.BAD_REQUEST);
        }

        if (articuloRepository.existsByNombreArticuloIgnoreCase(articulo.getNombreArticulo())){
            throw new BadRequestException("ya existe un articulo con el mismo nombre: "+articulo.getNombreArticulo(),"400",HttpStatus.BAD_REQUEST);
        }

        if (articulo.getCategoriaModel() == null){
            throw new NotFoundExeption("no es posible crear el articulo por que no existe la categoria","404",HttpStatus.NOT_FOUND);
        }

        return new ResponseGeneric(LocalDateTime.now(),articuloRepository.save(articulo),"201");
    }

    public ResponseGeneric getArticleById(Long id){
        Optional<ArticulosModel> articulosModel = articuloRepository.findById(id);
        if (articulosModel.isEmpty()){
            throw new NotFoundExeption("No existe el articulo solicitado","404",HttpStatus.NOT_FOUND);
        }
        return new ResponseGeneric(LocalDateTime.now(),articulosModel,"200");
    }

    public ResponseGeneric updateArticle(ArticulosModel articulo, Long id){
        Optional<ArticulosModel> articleExist = articuloRepository.findById(id);

        if (articleExist.isEmpty()){
            throw new NotFoundExeption("No existe el articulo solicitado","404",HttpStatus.NOT_FOUND);
        }

        if (articulo.getCategoriaModel() == null){
            throw new NotFoundExeption("no es posible crear el articulo por que no existe la categoria","404",HttpStatus.NOT_FOUND);
        }

        articleExist.get().setNombreArticulo(articulo.getNombreArticulo() != null ? articulo.getNombreArticulo(): articleExist.get().getNombreArticulo());
        articleExist.get().setDescripcionArticulo(articulo.getDescripcionArticulo() != null ? articulo.getDescripcionArticulo() : articleExist.get().getDescripcionArticulo());
        articleExist.get().setPrecio(articulo.getPrecio() <= 0.0 ? articulo.getPrecio() : articleExist.get().getPrecio());
        articleExist.get().setStock(articulo.getStock() != null && articulo.getStock() > 0 ? articulo.getStock() : articleExist.get().getStock());
        articleExist.get().setEstadoArticulo(articulo.getEstadoArticulo() != null ? articulo.getEstadoArticulo() : articleExist.get().getEstadoArticulo());
        articleExist.get().setCategoriaModel(articulo.getCategoriaModel());
        return new ResponseGeneric(LocalDateTime.now(),articuloRepository.save(articleExist.get()),"204");
    }

    public void delete(Long id){
        Optional<ArticulosModel> articleExist = articuloRepository.findById(id);

        if (articleExist.isEmpty()){
            throw new NotFoundExeption("No existe el articulo solicitado","404",HttpStatus.NOT_FOUND);
        }
        articuloRepository.delete(articleExist.get());
    }
}
