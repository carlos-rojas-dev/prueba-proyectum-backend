package com.testproyectum.crud.controller;

import com.testproyectum.crud.model.Producto;
import com.testproyectum.crud.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    
    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        existing.setNombre(producto.getNombre());
        existing.setPrecio(producto.getPrecio());
        existing.setStock(producto.getStock());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
