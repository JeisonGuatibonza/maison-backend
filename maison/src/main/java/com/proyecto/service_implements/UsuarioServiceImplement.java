package com.proyecto.service_implements;

import com.proyecto.entities.UsuarioEntity;
import com.proyecto.management.UsuarioManagement;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Autowired
    private UsuarioManagement usuarioManagement;

    @Override
    public List<UsuarioEntity> listarTodos() {
        return usuarioManagement.findAll();
    }

    @Override
    public UsuarioEntity buscarPorUsername(String username) {
        return usuarioManagement.findById(username).orElse(null);
    }

    @Override
    public UsuarioEntity guardar(UsuarioEntity usuario) {
        return usuarioManagement.save(usuario);
    }

    @Override
    public void eliminar(String username) {
        usuarioManagement.deleteById(username);
    }
}