package com.api1.crudtienda.articulo.controllers;

import com.api1.crudtienda.RequestResponseGeneric.ResponseGeneric;
import com.api1.crudtienda.articulo.services.ArticuloService;
import com.api1.crudtienda.articulo.models.ArticulosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGeneric> getById(@PathVariable Long id){
        return new ResponseEntity<>(articuloService.getArticleById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseGeneric> getAll(){
        return new ResponseEntity<>(articuloService.findAllArticle(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseGeneric> createArticulo(@RequestBody ArticulosModel articulosModel){
        return new ResponseEntity<>(articuloService.createArticle(articulosModel),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGeneric> updateArticulo(@RequestBody ArticulosModel articulosModel, @PathVariable Long id){
        return new ResponseEntity<>(articuloService.updateArticle(articulosModel, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteArticulo(@PathVariable("id") Long id){
        articuloService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
