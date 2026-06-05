package com.proyecto.service;

import com.proyecto.entities.LookEntity;
import java.util.List;

public interface LookService {
    List<LookEntity> listarTodos();
    LookEntity buscarPorId(Integer id);
    LookEntity guardar(LookEntity look);
    void eliminar(Integer id);
}