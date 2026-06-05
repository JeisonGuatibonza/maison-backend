package com.proyecto.controller;

import com.proyecto.entities.DesignerEntity;
import com.proyecto.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/maison/designers")
@CrossOrigin(origins = "*")
public class DesignerController {

    @Autowired
    private DesignerService designerService;

    @GetMapping("/listar")
    public List<DesignerEntity> listar() {
        return designerService.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DesignerEntity> buscarPorId(@PathVariable Integer id) {
        DesignerEntity designer = designerService.buscarPorId(id);
        return designer != null ? ResponseEntity.ok(designer) : ResponseEntity.notFound().build();
    }

    @PostMapping("/guardar")
    public ResponseEntity<DesignerEntity> guardar(@RequestBody DesignerEntity designer) {
        return ResponseEntity.ok(designerService.guardar(designer));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        designerService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DesignerEntity> actualizar(@PathVariable Integer id, @RequestBody DesignerEntity designer) {
        if (designerService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        designer.setId(id);
        return ResponseEntity.ok(designerService.guardar(designer));
    }
}