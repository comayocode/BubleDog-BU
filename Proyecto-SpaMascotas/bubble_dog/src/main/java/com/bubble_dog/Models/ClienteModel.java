package com.bubble_dog.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class ClienteModel {
    
    @Id
    private int cedula;

    @Column(name="Nombre")
    private String  nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="Nombre_Mascota")
    private String nombreMascota;
    @Column(name="Raza")
    private String raza;
    @Column(name="Vacunado")
    private String vacunado;
    @Column(name="Fecha_entrega")
    private LocalDate fecha_entrega;
    @Column(name="Hora_entrega")
    private LocalTime hora_entrega;
    
    public ClienteModel() {
    }

    public ClienteModel(int cedula, String nombre, String apellido, String email, String nombreMascota, String raza,
            String vacunado, LocalDate fecha_entrega, LocalTime hora_entrega) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.vacunado = vacunado;
        this.fecha_entrega = fecha_entrega;
        this.hora_entrega = hora_entrega;
    }

    

    @Override
    public String toString() {
        return "ClienteModel [apellido=" + apellido + ", cedula=" + cedula + ", email=" + email + ", fecha_entrega="
                + fecha_entrega + ", hora_entrega=" + hora_entrega + ", nombre=" + nombre + ", nombreMascota="
                + nombreMascota + ", raza=" + raza + ", vacunado=" + vacunado + "]";
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public String getVacunado() {
        return vacunado;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public LocalTime getHora_entrega() {
        return hora_entrega;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setHora_entrega(LocalTime hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    
}
