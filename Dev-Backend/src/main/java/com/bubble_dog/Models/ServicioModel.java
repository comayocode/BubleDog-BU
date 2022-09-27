package com.bubble_dog.Models;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "servicios")
public class ServicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer id_servicio;

    @Column(name = "nombre_servicio", length = 50)
    private String nombre_servicio;

    @Column(name = "costo_servicio")
    private Integer costo_servicio;

    @Column(name = "hora_fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date hora_fecha_entrega = new Date();

    @Column(name = "detalles_servicio", length = 255)
    private String detalles_servicio;

    //Relacion de las Tablas
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "servicioModel")
    private List<DetallesServicioModel> detallesServicios;
    public ServicioModel() {
    }

    // Constructor

    public ServicioModel(Integer id_servicio, String nombre_servicio, Integer costo_servicio, Date hora_fecha_entrega, String detalles_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.costo_servicio = costo_servicio;
        this.hora_fecha_entrega = hora_fecha_entrega;
        this.detalles_servicio = detalles_servicio;

    }


    //Métodos Getter and Setters

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public Integer getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(Integer costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getDetalles_servicio() {
        return detalles_servicio;
    }

    public void setDetalles_servicio(String detalles_servicio) {
        this.detalles_servicio = detalles_servicio;
    }

    public Date getHora_fecha_entrega() {
        return hora_fecha_entrega;
    }

    public void setHora_fecha_entrega(Date hora_fecha_entrega) {
        this.hora_fecha_entrega = hora_fecha_entrega;
    }

    public List<DetallesServicioModel> getDetallesServicios() {
        return detallesServicios;
    }

    public void setDetallesServicios(List<DetallesServicioModel> detallesServicios) {
        this.detallesServicios = detallesServicios;
    }

    
}
