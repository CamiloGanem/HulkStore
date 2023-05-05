package com.prueba.hulkstoreback.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hs_productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_producto;
    private String codigo_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Double precio_producto;
    private int cantidad_producto;
}
