package com.testproyectum.crud.dto;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;

    public UsuarioDTO(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
