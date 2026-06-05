package com.proyecto.management;

import com.proyecto.entities.DesignerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CrudDesignersMaison")
public interface DesignerManagement extends JpaRepository<DesignerEntity, Integer> {
    
}