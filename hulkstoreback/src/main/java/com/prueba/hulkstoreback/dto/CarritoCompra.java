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
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_carrito_compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", foreignKey = @ForeignKey(name = "id_producto", value = ConstraintMode.CONSTRAINT))
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "id_empleado", foreignKey = @ForeignKey(name = "id_empleado", value = ConstraintMode.CONSTRAINT))
    private Empleado empleado;

    private int cantidad_carrito;
}
