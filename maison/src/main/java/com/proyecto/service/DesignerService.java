package com.proyecto.service;

import com.proyecto.entities.DesignerEntity;
import java.util.List;

public interface DesignerService {
    List<DesignerEntity> listarTodos();
    DesignerEntity buscarPorId(Integer id);
    DesignerEntity guardar(DesignerEntity designer);
    void eliminar(Integer id);
}