package com.testproyectum.crud.repository;

import com.testproyectum.crud.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
