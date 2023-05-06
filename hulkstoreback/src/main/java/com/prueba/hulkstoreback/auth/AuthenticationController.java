package com.prueba.hulkstoreback.auth;

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
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) throws ExceptionService {
        try {
            empleadoService.registrarEmpleado(request.getEmpleado());
            return ResponseEntity.ok(service.register(request));
        } catch (ExceptionService e) {
            throw new ExceptionService(e);
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
