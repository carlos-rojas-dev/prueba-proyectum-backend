
package com.testproyectum.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testproyectum.crud.dto.UsuarioDTO;
import com.testproyectum.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
       @Query("SELECT new com.testproyectum.crud.dto.UsuarioDTO(u.id, u.nombre, u.email) FROM Usuario u")
    List<UsuarioDTO> findAllUsuariosSinClave();
    
    Optional<Usuario> findByEmail(String email);
}
