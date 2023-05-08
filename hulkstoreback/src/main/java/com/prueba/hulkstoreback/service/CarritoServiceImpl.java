package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Carrito;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public Carrito registrarCarrito(Carrito carrito) throws ExceptionService {
        try {
            return carritoRepository.save(carrito);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Respuesta eliminarCarritoPorId(Integer idCarrito) throws ExceptionService {
        Respuesta resp = new Respuesta();
        try {
            carritoRepository.deleteById(idCarrito);
            resp.setMensaje("Se elimino el registro");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return resp;
    }

    @Override
    public List<Carrito> consultarCarritoPorIdEmpleado(Integer idEmpleado) {
        return carritoRepository.findByIdCarrito(idEmpleado);
    }
}
