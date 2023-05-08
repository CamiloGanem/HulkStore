package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Carrito;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;

import java.util.List;

public interface CarritoService {
    Carrito registrarCarrito(Carrito carrito) throws ExceptionService;
    Respuesta eliminarCarritoPorId(Integer idCarrito) throws ExceptionService;
    List<Carrito> consultarCarritoPorIdEmpleado(Integer idEmpleado);
}
