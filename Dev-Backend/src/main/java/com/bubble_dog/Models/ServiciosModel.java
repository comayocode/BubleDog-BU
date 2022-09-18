package com.bubble_dog.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="servicio")
public class ServiciosModel {
    @Id
    private String id_servicio;
    private String nombre_servicio;
    private String costo_servicio;
    private String detalles_servicio;

    public ServiciosModel() {
    }

    public ServiciosModel(String id_servicio, String nombre_servicio, String costo_servicio, String detalles_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.costo_servicio = costo_servicio;
        this.detalles_servicio = detalles_servicio;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public String getCosto_servicio() {
        return costo_servicio;
    }

    public String getDetalles_servicio() {
        return detalles_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public void setCosto_servicio(String costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public void setDetalles_servicio(String detalles_servicio) {
        this.detalles_servicio = detalles_servicio;
    }

}
