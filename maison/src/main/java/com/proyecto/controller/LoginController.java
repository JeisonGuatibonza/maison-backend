package com.proyecto.controller;

import com.proyecto.dto.LoginRequest;
import com.proyecto.service.UsuarioService;
import com.proyecto.util.JwtUtil;
import com.proyecto.entities.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/maison/usuarios")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // 1. Buscamos el usuario usando tu servicio actual conectado a Aiven
            UsuarioEntity usuario = usuarioService.buscarPorUsername(loginRequest.getUsername());

            if (usuario != null) {
                // 2. Validación manual y directa de texto plano
                if (usuario.getPassword().equals(loginRequest.getPassword())) {
                    
                    // 3. Generamos el token con el String del username/email
                    String token = jwtUtil.generateToken(usuario.getUsername());

                    // 4. Lo devolvemos en un JSON limpio estructurado para tu app de Flutter
                    Map<String, String> response = new HashMap<>();
                    response.put("token", token);
                    
                    return ResponseEntity.ok(response);
                }
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o clave incorrectos");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}