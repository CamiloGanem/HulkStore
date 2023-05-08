package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Empleado;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;

public interface EmpleadoService {
    Respuesta registrarEmpleado(Empleado empleado) throws ExceptionService;

    String eliminarEmpleado(Integer idEmpleado) throws ExceptionService;

    Respuesta consultarEmpleadoPorId(Integer idEmpleado) throws ExceptionService;

    Respuesta consultarEmpleados();

    Empleado consularPorIdentificacion(String identificacion) throws ExceptionService;

}
