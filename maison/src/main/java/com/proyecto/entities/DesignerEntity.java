package com.proyecto.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "designers")
public class DesignerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Lob
    @Column(name = "imagen_base64", columnDefinition = "LONGTEXT")
    private String imagenBase64;

    // Constructores
    public DesignerEntity() {
    }

    // Getters y Setters
    public Integer getId() { 
        return id; 
    }
    
    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public LocalDate getFechaNacimiento() { 
        return fechaNacimiento; 
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) { 
        this.fechaNacimiento = fechaNacimiento; 
    }

    public String getImagenBase64() { 
        return imagenBase64; 
    }
    
    public void setImagenBase64(String imagenBase64) { 
        this.imagenBase64 = imagenBase64; 
    }
}