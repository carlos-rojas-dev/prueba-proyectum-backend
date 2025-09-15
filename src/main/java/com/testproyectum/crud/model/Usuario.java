
package com.testproyectum.crud.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nombre;
    private String email;
    private int edad;
    private String clave;

    public Usuario() {}

    public Usuario(String nombre, String email, int edad, String clave, String username) {
        this.username = username;
        this.clave = clave;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;  
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
