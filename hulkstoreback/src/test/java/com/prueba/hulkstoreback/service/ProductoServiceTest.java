package com.prueba.hulkstoreback.service;

import com.prueba.hulkstoreback.dto.Producto;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.repository.ProductoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductoServiceTest {


    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    public void testRegistrarProducto() throws ExceptionService {
        Producto producto = new Producto();
        producto.setCodigo_producto("0010");
        producto.setNombre_producto("PruebaTest");
        producto.setDescripcion_producto("");
        producto.setPrecio_producto(1000.00);
        producto.setCantidad_producto(2);

        Mockito.when(productoRepository.save(Mockito.any(Producto.class))).thenReturn(producto);

        Respuesta resp = productoService.registrarProducto(producto);

        Assertions.assertEquals("Se registro el prodcuto correctamente.", resp.getMensaje());
        Assertions.assertEquals(producto, resp.getDato());
    }
}
