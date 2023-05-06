package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Producto;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Respuesta registrarProducto(Producto producto) throws ExceptionService {
        Respuesta resp = new Respuesta();
        Producto reg;
        try {
            reg = productoRepository.save(producto);
            resp.setMensaje("Se registro el prodcuto correctamente.");
        }catch (Exception ex){
            reg = null;
            resp.setMensaje("Ocurrio un problema al registrar el producto");
            ex.printStackTrace();
        }

        resp.setDato(reg);
        return resp;
    }

    @Override
    public String eliminarProducto(Integer idEmpleado) throws ExceptionService {
        String msg;
        try {
            productoRepository.deleteById(idEmpleado);
            msg = "Se elimino el producto correctamente";
        }catch (Exception ex){
            msg = "Ocurrio un problema al eliminar el producto";
            ex.printStackTrace();
        }
        return msg;
    }

    @Override
    public Respuesta consultarProductoPorId(Integer idEmpleado) throws ExceptionService{
        Respuesta resp = new Respuesta();
        Producto reg;
        try {
            reg = productoRepository.findById(idEmpleado).orElseThrow();
            resp.setMensaje("Registro consultado correctamente.");
        }catch (Exception ex){
            reg = null;
            resp.setMensaje("Ocurrio un problema al consultar el producto.");
            ex.printStackTrace();
        }
        resp.setDato(reg);
        return resp;
    }

    @Override
    public Respuesta consultarProductos() {
        Respuesta resp = new Respuesta();
        List<Producto> productos = productoRepository.findAll();
        resp.setDato(productos);
        resp.setMensaje("Registros consultados correctamente.");
        return resp;
    }

}
