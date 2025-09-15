
package com.testproyectum.crud.controller;

import org.springframework.web.bind.annotation.*;

import com.testproyectum.crud.model.Usuario;
import com.testproyectum.crud.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existing.setNombre(usuario.getNombre());
        existing.setEmail(usuario.getEmail());
        existing.setEdad(usuario.getEdad());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
