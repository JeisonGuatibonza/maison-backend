package com.proyecto.management;

import com.proyecto.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CrudUsuariosMaison")
public interface UsuarioManagement extends JpaRepository<UsuarioEntity, String> {
    
}