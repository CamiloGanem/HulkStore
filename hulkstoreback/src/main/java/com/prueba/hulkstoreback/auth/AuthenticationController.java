package com.prueba.hulkstoreback.auth;

import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.exception.ExceptionService;
import com.prueba.hulkstoreback.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final EmpleadoService empleadoService;

    @PostMapping("/registrar")
    public ResponseEntity<Respuesta> register(
            @RequestBody RegisterRequest request
    ) throws ExceptionService {
        Respuesta resp = service.validateUserAndEmploye(
                request.getEmail(),
                request.getEmpleado().getIden_empleado()
        );
        try {
            if(resp.getDato().equals(true)){
                empleadoService.registrarEmpleado(request.getEmpleado());
                service.register(request);
            }
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }

        return ResponseEntity.ok(resp);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/getTokenUser")
    public ResponseEntity<Respuesta> getTokenUser(){
        return ResponseEntity.ok(service.getTokenUser());
    }

}
