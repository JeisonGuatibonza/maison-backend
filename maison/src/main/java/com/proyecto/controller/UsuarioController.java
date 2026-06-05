package com.proyecto.controller;

import com.proyecto.entities.UsuarioEntity;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/maison/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<UsuarioEntity> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioEntity> guardar(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    @DeleteMapping("/eliminar/{username}")
    public ResponseEntity<Void> eliminar(@PathVariable String username) {
        usuarioService.eliminar(username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{username}")
    public ResponseEntity<UsuarioEntity> actualizar(@PathVariable String username, @RequestBody UsuarioEntity usuario) {
        usuario.setUsername(username);
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }
}