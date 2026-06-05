package com.proyecto.service_implements;

import com.proyecto.entities.LookEntity;
import com.proyecto.management.LookManagement;
import com.proyecto.service.LookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LookServiceImplement implements LookService {

    @Autowired
    private LookManagement lookManagement;

    @Override
    public List<LookEntity> listarTodos() {
        return lookManagement.findAll();
    }

    @Override
    public LookEntity buscarPorId(Integer id) {
        return lookManagement.findById(id).orElse(null);
    }

    @Override
    public LookEntity guardar(LookEntity look) {
        return lookManagement.save(look);
    }

    @Override
    public void eliminar(Integer id) {
        lookManagement.deleteById(id);
    }
}