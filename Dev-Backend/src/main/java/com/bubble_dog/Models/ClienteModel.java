package com.bubble_dog.Models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre",nullable = false, length = 60)
    private String nombre;

    @Column(name = "apellido",nullable = false, length = 60)
    private String apellidos;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;


    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @Column(name = "nombre_mascota", nullable = true, length = 60)
    private String nombre_mascota;

    @Column(name = "raza", nullable = true, length = 20)
    private String raza;

    @Column(name = "vacunado",nullable = true, length = 5)
    private String vacunado;

    @Column(name = "observacion", nullable = true, length = 100)
    private String observacion;

    //Relacion de las Tablas
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clienteModel")
    private List<ServicioModel> servicioModels;


    public ClienteModel() {
    }

    public ClienteModel(String cedula, String nombre, String apellidos, String telefono, String email, String nombre_mascota, String raza, String vacunado, String observacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.nombre_mascota = nombre_mascota;
        this.raza = raza;
        this.vacunado = vacunado;
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + idCliente +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", nombre_mascota='" + nombre_mascota + '\'' +
                ", raza='" + raza + '\'' +
                ", vacunado='" + vacunado + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }

    public Integer getIdCliente() {
        return idCliente;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getVacunado() {
        return vacunado;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<ServicioModel> getServicioModels() {
        return servicioModels;
    }

    public void setServicioModels(List<ServicioModel> servicioModels) {
        this.servicioModels = servicioModels;
    }
}
