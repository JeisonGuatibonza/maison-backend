package com.proyecto.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "looks")
public class LookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "anio_creacion", nullable = false)
    private Integer anio;

    @Column(nullable = false, length = 50)
    private String temporada; // Ej: Primavera-Verano, Otoño-Invierno

    @Lob
    @Column(name = "imagen_base64", columnDefinition = "LONGTEXT")
    private String imagenBase64;

    // 🌟 Atributo numérico plano. Ya no hay @ManyToOne ni @JoinColumn complejos.
    @Column(name = "designer_id", nullable = false)
    private Integer designerId;

    // Opcional: Atributo plano para el nombre si quieres guardarlo o devolverlo directo
    @Column(name = "disenador_nombre", length = 100)
    private String disenadorNombre;

    // Constructores
    public LookEntity() {
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public String getDisenadorNombre() {
        return disenadorNombre;
    }

    public void setDisenadorNombre(String disenadorNombre) {
        this.disenadorNombre = disenadorNombre;
    }
}