package com.proyecto.management;

import com.proyecto.entities.LookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CrudLooksMaison")
public interface LookManagement extends JpaRepository<LookEntity, Integer> {
    
}