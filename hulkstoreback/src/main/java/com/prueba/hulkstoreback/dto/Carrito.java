package com.prueba.hulkstoreback.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hs_carrito_compras")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_carrito_compra;

    private Integer id_producto;

    private Integer id_empleado;

    private int cantidad_carrito;
}
