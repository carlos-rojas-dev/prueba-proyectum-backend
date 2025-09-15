package com.testproyectum.crud.controller;

import org.junit.jupiter.api.Test;

public class ColoresTest {

    // Códigos ANSI para colores
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    @Test
    void testConColores() {
        System.out.println(BLUE + "Iniciando test de productos..." + RESET);
        System.out.println(GREEN + "Producto creado correctamente" + RESET);
        System.out.println(YELLOW + "Advertencia: stock bajo" + RESET);
        System.out.println(RED + "Error esperado: producto no encontrado" + RESET);
    }
    
}
