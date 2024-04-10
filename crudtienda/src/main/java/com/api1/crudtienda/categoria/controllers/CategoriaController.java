package com.api1.crudtienda.categoria.controllers;

import com.api1.crudtienda.articulo.models.ArticulosModel;
import com.api1.crudtienda.categoria.models.CategoriaModel;
import com.api1.crudtienda.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public CategoriaModel getById(@PathVariable Long id){
        return categoriaService.getCategoriaById(id);
    }

    @GetMapping
    public List<CategoriaModel> getAll(){
        return categoriaService.findAllCategoria();
    }

    @PostMapping
    public void createCategoria(@RequestBody CategoriaModel categoriaModel){
        categoriaService.CreateCategoria(categoriaModel);
    }

    @PutMapping("/{id}")
    public void updateCategoria(@RequestBody CategoriaModel categoriaModel, @PathVariable Long id){
        categoriaService.updateCategoria(categoriaModel, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id){
        categoriaService.delete(id);
    }

    @GetMapping("/articulo/{id}")
    public void getAllArticulosByCategoria(@PathVariable Long id) {
        categoriaService.getAllArticuloByCategoria(id);
    }
}
