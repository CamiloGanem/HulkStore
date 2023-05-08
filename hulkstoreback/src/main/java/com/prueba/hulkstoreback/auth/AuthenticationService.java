package com.prueba.hulkstoreback.auth;

import com.prueba.hulkstoreback.Usuario;
import com.prueba.hulkstoreback.config.JwtService;
import com.prueba.hulkstoreback.dto.Empleado;
import com.prueba.hulkstoreback.dto.Respuesta;
import com.prueba.hulkstoreback.repository.EmpleadoRepository;
import com.prueba.hulkstoreback.repository.UsuarioRepository;
import com.prueba.hulkstoreback.security.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final EmpleadoRepository empleadoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String tokenUser;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .primer_nombre(request.getFirtName())
                .apellido(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generarToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generarToken(user);
        this.tokenUser = jwtToken;
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .usuario(user)
                .build();
    }

    public Respuesta validateUserAndEmploye(String emailUser, String identificacion){
        Usuario userExist = repository.findByEmail(emailUser).orElse(null);
        Empleado emploExist = empleadoRepository.findByIdenEmpleado(identificacion).orElse(null);

        Respuesta resp = new Respuesta();
        boolean existe = true;
        String msg = "Se registró el usuario correctamente";

        if(emploExist != null){
            msg = "Ya existe un usuario con el mismo numero de identificaión: " + identificacion;
            existe = false;
        }else if(userExist != null){
            msg = "Ya existe un usuario con el mismo email: " + emailUser;
            existe = false;
        }

        resp.setMensaje(msg);
        resp.setDato(existe);
        return resp;
    }

    public Respuesta getTokenUser(){
        Respuesta resp = new Respuesta();
        resp.setDato(this.tokenUser);
        return resp;
    }

}
