package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Empleado;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Respuesta registrarEmpleado(Empleado empleado) throws ExceptionService {
        Respuesta resp = new Respuesta();
        Empleado reg;
        try {
            reg = empleadoRepository.save(empleado);
            resp.setMensaje("Se registro el empleado correctamente");
        }catch (DataIntegrityViolationException div){
            reg = null;
            resp.setMensaje("Ya existe un empleado con este numero de indetifacion: "
                    + empleado.getIden_empleado());
        }catch (Exception ex){
            reg = null;
            ex.printStackTrace();
        }

        resp.setDato(reg);
        return resp;

    }

    @Override
    public String eliminarEmpleado(Integer idEmpleado) throws ExceptionService {
        String msg;
        try {
            empleadoRepository.deleteById(idEmpleado);
            msg = "Se elimino el empleado correctamente.";
        }catch (Exception ex){
            msg = "Ocurrio un problema al eliminar el empleado";
            ex.printStackTrace();
        }

        return msg;
    }

    @Override
    public Respuesta consultarEmpleadoPorId(Integer idEmpleado) throws ExceptionService {
        Respuesta resp = new Respuesta();
        Empleado empleado;
        try {
            empleado = empleadoRepository.findById(idEmpleado).orElseThrow();
            resp.setMensaje("Registro consultado correctamente.");
        }catch (Exception ex){
            empleado = null;
            resp.setMensaje("Ocurrio un problema al consultar el empleado.");
            ex.printStackTrace();
        }

        resp.setDato(empleado);
        return resp;
    }

    @Override
    public Respuesta consultarEmpleados() {
        Respuesta resp = new Respuesta();
        List<Empleado> empleados = empleadoRepository.findAll();
        resp.setDato(empleados);
        resp.setMensaje("Registros consultados correctamente.");
        return resp;
    }

    @Override
    public Empleado consularPorIdentificacion(String identificacion) throws ExceptionService {
        Empleado reg;
        try {
            reg = empleadoRepository.findByIdenEmpleado(identificacion).get();
        }catch (Exception ex){
            reg = null;
            ex.printStackTrace();
        }

        return reg;
    }
}
