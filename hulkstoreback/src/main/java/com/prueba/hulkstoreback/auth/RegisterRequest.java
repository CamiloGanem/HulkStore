package com.prueba.hulkstoreback.auth;

import com.prueba.hulkstoreback.dto.Empleado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firtName;
    private String lastName;
    private String email;
    private String password;
    private Empleado empleado;

}
