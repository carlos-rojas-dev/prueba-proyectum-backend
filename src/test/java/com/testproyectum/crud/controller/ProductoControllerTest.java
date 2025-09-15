package com.testproyectum.crud.controller;
  
import com.testproyectum.crud.model.Usuario;
import com.testproyectum.crud.repository.ProductoRepository;
import com.testproyectum.crud.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductoControllerTest {

     private static final String RESET = "\u001B[0m";
     private static final String RED = "\u001B[31m";
     private static final String GREEN = "\u001B[32m";
     private static final String YELLOW = "\u001B[33m";
     private static final String BLUE = "\u001B[34m";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private String token;

    @BeforeEach
    void setUp() throws Exception {
        productoRepository.deleteAll();
        usuarioRepository.deleteAll();
         
        System.out.println(BLUE + "Preparando datos de prueba..." + RESET);

        // Crear usuario de prueba 
        Usuario u = new Usuario();
        u.setUsername("Carlos"); 
        u.setNombre("Carlos Rojas Quintanilla");
        u.setEmail("carlos.rojas.ti@hotmail.com");
        u.setClave("1234");    
        usuarioRepository.save(u);

        // Realizar login y obtener token
        String loginRequest = """
            {
                "username": "Carlos",
                "clave": "1234"
            }
        """;

        MvcResult result = mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();
        token = responseJson.split("\"token\":\"")[1].split("\"")[0];
        

        System.out.println(GREEN + "Login exitoso. Token obtenido." + RESET);
    }

    @Test
    void testCrearYListarProductos() throws Exception {
        String nuevoProducto = """
            {
                "nombre": "Laptop xyz",
                "precio": 1200,
                "stock": 10
            }
        """;
        
        System.out.println(BLUE + "Enviando POST /productos..." + RESET);

        // 1️⃣ Crear producto (con token en el header Authorization)
         mockMvc.perform(post("/productos")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(nuevoProducto))
                .andExpect(status().isOk());

                System.out.println(GREEN + "Producto creado correctamente" + RESET);

                // 2️⃣ Listar productos
                System.out.println(BLUE + "Consultando GET /productos..." + RESET);

                MvcResult getResult =  mockMvc.perform(get("/productos")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Laptop xyz"))
                .andExpect(jsonPath("$[0].precio").value(1200))
                .andExpect(jsonPath("$[0].stock").value(10))
                .andReturn();

        String responseBody = getResult.getResponse().getContentAsString();

        System.out.println(GREEN + "✅ Listado de productos correcto" + RESET);
        System.out.println(YELLOW + "📦 Respuesta de la API: " + RESET + responseBody);
    }

}
