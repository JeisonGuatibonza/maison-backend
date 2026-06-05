package com.proyecto.controller;

import com.proyecto.entities.LookEntity;
import com.proyecto.service.LookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/maison/looks")
@CrossOrigin(origins = "*")
public class LookController {

    @Autowired
    private LookService lookService;

    @GetMapping("/listar")
    public List<LookEntity> listar() {
        return lookService.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LookEntity> buscarPorId(@PathVariable Integer id) {
        LookEntity look = lookService.buscarPorId(id);
        return look != null ? ResponseEntity.ok(look) : ResponseEntity.notFound().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<LookEntity> guardar(@RequestBody LookEntity look) {
        return ResponseEntity.ok(lookService.guardar(look));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        lookService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<LookEntity> actualizar(@PathVariable Integer id, @RequestBody LookEntity look) {
        if (lookService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        look.setId(id);
        return ResponseEntity.ok(lookService.guardar(look));
    }
}