package com.prueba.hulkstoreback.controller;

import com.prueba.hulkstoreback.dto.Producto;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping("/registrar")
    public ResponseEntity<Respuesta> registrarproducto(@RequestBody Producto producto) throws ExceptionService {
        Respuesta resp;
        try {
            resp = productoService.registrarProducto(producto);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/eliminar/{idEmpledo}")
    public ResponseEntity<String> eliminarproducto(@PathVariable("idEmpledo") Integer idProducto) throws ExceptionService {
        String msg;
        try {
            msg = productoService.eliminarProducto(idProducto);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/consultarPorId/{idProducto}")
    public ResponseEntity<Respuesta> consultarproductoPorId(@PathVariable("idProducto") Integer idProducto) throws ExceptionService {
        Respuesta resp;
        try {
            resp = productoService.consultarProductoPorId(idProducto);
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/consultarTodos")
    public ResponseEntity<Respuesta> consultarproductos() {
        Respuesta resp = productoService.consultarProductos();
        return ResponseEntity.ok(resp);
    }

}
