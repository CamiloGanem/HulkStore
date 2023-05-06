package com.prueba.hulkstoreback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private String mensaje;
    private Object dato;
}
