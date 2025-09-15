package com.testproyectum.crud.controller;

import com.testproyectum.crud.dto.LoginResponse;
import com.testproyectum.crud.dto.UsuarioDTO;
import com.testproyectum.crud.model.Usuario;
import com.testproyectum.crud.repository.UsuarioRepository;
import com.testproyectum.crud.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credenciales) {
        String username = credenciales.get("username");
        String clave = credenciales.get("clave");

        Usuario usuario = usuarioRepository.findAll().stream()
                .filter(u -> u.getUsername().equals(username) && u.getClave().equalsIgnoreCase(clave))
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }

        // Buscar el usuario en la BD po email
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioOpt.isEmpty()) { 
            return ResponseEntity.status(401).body(Map.of("error", "Usuario no encontrado"));
        }

        Usuario usuariofinal = usuarioOpt.get();

        String token = jwtUtil.generateToken(usuariofinal.getEmail());

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuariofinal.getId(), usuariofinal.getNombre(), usuariofinal.getEmail());

        LoginResponse loginResponse = new LoginResponse(token, usuarioDTO);

        return ResponseEntity.ok(Map.of(
            "token", loginResponse.getToken(),
            "usuario", loginResponse.getUsuario()
        ));
 
    }
}