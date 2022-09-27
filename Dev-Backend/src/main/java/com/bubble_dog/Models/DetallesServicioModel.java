package com.bubble_dog.Models;

import java.util.Date;

//import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "detalles_servicio")
public class DetallesServicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalles_servicio")
    private Integer id_detalles_servicio;

    @Column(name = "hora_fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date hora_fecha_entrega = new Date();

    // Relacion tabla Clientes
    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, optional = false)
    @JoinColumn(name = "idCliente")
    private ClienteModel clienteModel;

    // Relacion tabla servicios
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_servicio")
    private ServicioModel servicioModel;

    //Constructor
    public DetallesServicioModel() {
    }

    

    public DetallesServicioModel(Integer id_detalles_servicio, Date hora_fecha_entrega, ClienteModel clienteModel,
            ServicioModel servicioModel) {
        this.id_detalles_servicio = id_detalles_servicio;
        this.hora_fecha_entrega = hora_fecha_entrega;
        this.clienteModel = clienteModel;
        this.servicioModel = servicioModel;
    }


    // Getters y Setters
    public Integer getId_detalles_servicio() {
        return id_detalles_servicio;
    }

    public void setId_detalles_servicio(Integer id_detalles_servicio) {
        this.id_detalles_servicio = id_detalles_servicio;
    }

    public Date getHora_fecha_entrega() {
        return hora_fecha_entrega;
    }

    public void setHora_fecha_entrega(Date hora_fecha_entrega) {
        this.hora_fecha_entrega = hora_fecha_entrega;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public ServicioModel getServicioModel() {
        return servicioModel;
    }

    public void setServicioModel(ServicioModel servicioModel) {
        this.servicioModel = servicioModel;
    }

    

    
}
