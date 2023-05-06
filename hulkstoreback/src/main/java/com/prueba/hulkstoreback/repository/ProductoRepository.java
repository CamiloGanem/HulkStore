package com.prueba.hulkstoreback.repository;

import com.prueba.hulkstoreback.dto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
