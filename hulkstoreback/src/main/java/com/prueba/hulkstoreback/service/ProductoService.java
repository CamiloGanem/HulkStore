package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Producto;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;

public interface ProductoService {
    Respuesta registrarProducto(Producto producto) throws ExceptionService;

    String eliminarProducto(Integer idEmpleado) throws ExceptionService;

    Respuesta consultarProductoPorId(Integer idEmpleado) throws ExceptionService;

    Respuesta consultarProductos();

}
