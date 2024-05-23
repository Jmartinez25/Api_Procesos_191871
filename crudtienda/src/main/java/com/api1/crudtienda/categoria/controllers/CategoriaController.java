package com.api1.crudtienda.categoria.controllers;

import com.api1.crudtienda.RequestResponseGeneric.RequestGeneric;
import com.api1.crudtienda.RequestResponseGeneric.ResponseGeneric;
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

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGeneric> getById(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.getCategoriaById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseGeneric> getAll() {
        return new ResponseEntity<>(categoriaService.findAllCategoria(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseGeneric> createCategoria(@RequestBody RequestGeneric<CategoriaModel> requestGeneric) {
        return new ResponseEntity<>(categoriaService.CreateCategoria(requestGeneric.getData()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGeneric> updateCategoria(@RequestBody RequestGeneric<CategoriaModel> requestGeneric, @PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.updateCategoria(requestGeneric.getData(), id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") Long id) {
        categoriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/articulo/{id}")
    public ResponseEntity<ResponseGeneric> getAllArticulosByCategoria(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.getAllArticuloByCategoria(id), HttpStatus.OK);
    }
}
