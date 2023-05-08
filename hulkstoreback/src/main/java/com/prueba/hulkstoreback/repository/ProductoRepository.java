package com.prueba.hulkstoreback.repository;

import com.prueba.hulkstoreback.dto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
