package com.proyecto.service_implements;

import com.proyecto.entities.DesignerEntity;
import com.proyecto.management.DesignerManagement;
import com.proyecto.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DesignerServiceImplement implements DesignerService {

    @Autowired
    private DesignerManagement designerManagement;

    @Override
    public List<DesignerEntity> listarTodos() {
        return designerManagement.findAll();
    }

    @Override
    public DesignerEntity buscarPorId(Integer id) {
        return designerManagement.findById(id).orElse(null);
    }

    @Override
    public DesignerEntity guardar(DesignerEntity designer) {
        return designerManagement.save(designer);
    }

    @Override
    public void eliminar(Integer id) {
        designerManagement.deleteById(id);
    }
}