package com.prueba.hulkstoreback.repository;

import com.prueba.hulkstoreback.dto.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    @Query(value = "SELECT * FROM hs_carrito_compras WHERE id_empleado = :idEmpleado", nativeQuery = true)
    List<Carrito> findByIdEmpleado(Integer idEmpleado);

    @Query(value = "SELECT * FROM hs_carrito_compras WHERE id_carrito_compra = :idCarrito", nativeQuery = true)
    List<Carrito> findByIdCarrito(Integer idCarrito);
}
