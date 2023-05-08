package com.prueba.hulkstoreback.repository;

import com.prueba.hulkstoreback.dto.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value = "SELECT * FROM hs_empleados WHERE iden_empleado LIKE :identificacion", nativeQuery = true)
    Optional<Empleado> findByIdenEmpleado(String identificacion);
}
