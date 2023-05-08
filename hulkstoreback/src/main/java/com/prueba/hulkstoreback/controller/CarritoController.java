package com.prueba.hulkstoreback.controller;

import com.prueba.hulkstoreback.dto.Carrito;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/registrar")
    public ResponseEntity<Carrito> registrar(@RequestBody Carrito carrito) throws ExceptionService {
        try {
            return ResponseEntity.ok(carritoService.registrarCarrito(carrito));
        } catch (ExceptionService e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/eliminar/{idCarrito}")
    public ResponseEntity<Respuesta> eliminarCarritoPorId(@PathVariable("idCarrito") Integer idCarrito) throws ExceptionService {
        try {
            return ResponseEntity.ok(carritoService.eliminarCarritoPorId(idCarrito));
        } catch (ExceptionService e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/consultar/{idEmpleado}")
    public ResponseEntity<List<Carrito>> consultarCarritoPorIdEmpleado(@PathVariable("idEmpleado") Integer idEmpleado){
        return ResponseEntity.ok(carritoService.consultarCarritoPorIdEmpleado(idEmpleado));
    }
}
