package com.api1.crudtienda.articulo.controllers;

import com.api1.crudtienda.articulo.services.ArticuloService;
import com.api1.crudtienda.articulo.models.ArticulosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
