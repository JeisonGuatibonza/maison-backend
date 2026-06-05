package com.proyecto.service;

import com.proyecto.entities.UsuarioEntity;
import java.util.List;

public interface UsuarioService {
    List<UsuarioEntity> listarTodos();
    UsuarioEntity buscarPorUsername(String username);
    UsuarioEntity guardar(UsuarioEntity usuario);
    void eliminar(String username);
}