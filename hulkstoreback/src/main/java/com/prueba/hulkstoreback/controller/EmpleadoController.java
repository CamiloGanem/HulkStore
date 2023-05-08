package com.prueba.hulkstoreback.controller;

import com.prueba.hulkstoreback.dto.Empleado;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/registrar")
    public ResponseEntity<Respuesta> registrarEmpleado(@RequestBody Empleado empleado) throws ExceptionService {
        Respuesta resp;
        try {
            resp = empleadoService.registrarEmpleado(empleado);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/eliminar/{idEmpledo}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("idEmpledo") Integer idEmpleado) throws ExceptionService {
        try {
            empleadoService.eliminarEmpleado(idEmpleado);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }

        return ResponseEntity.ok("Se elimino el empleado correctamente");
    }

    @GetMapping("/consultarPorId/{idEmpleado}")
    public ResponseEntity<Respuesta> consultarEmpleadoPorId(@PathVariable("idEmpleado") Integer idEmpleado) throws ExceptionService {
        Respuesta resp;
        try {
            resp = empleadoService.consultarEmpleadoPorId(idEmpleado);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/consultarTodos")
    public ResponseEntity<Respuesta> consultarEmpleados() {
        Respuesta resp = empleadoService.consultarEmpleados();
        return ResponseEntity.ok(resp);
    }

}
