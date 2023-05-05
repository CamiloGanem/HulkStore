package com.prueba.hulkstoreback.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hs_empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_empleado;
    private String iden_empleado;
    private String nombres_empleado;
    private String apellidos_empleados;
    private Date fecha_nac_empleado;
}
