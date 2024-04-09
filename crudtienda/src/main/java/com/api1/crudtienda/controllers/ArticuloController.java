package com.api1.crudtienda.controllers;

import com.api1.crudtienda.models.ArticulosModel;
import com.api1.crudtienda.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/{id}")
    public ArticulosModel getById(@PathVariable Long id){
       return articuloService.getArticleById(id);
    }

    @GetMapping
    public List<ArticulosModel> getAll(){
        return articuloService.findAllArticle();
    }

    @PostMapping
    public void createArticulo(@RequestBody ArticulosModel articulosModel){
        articuloService.createArticle(articulosModel);
    }

    @PutMapping("/{id}")
    public void updateArticulo(@RequestBody ArticulosModel articulosModel, @PathVariable Long id){
        articuloService.updateArticle(articulosModel, id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable("id") Long id){
        articuloService.delete(id);
    }


}
