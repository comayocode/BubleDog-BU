package com.bubble_dog.Services;

import java.util.Date;
import java.util.List;

import com.bubble_dog.Models.DetallesServicioModel;

public interface IDetallesServicioService {

    DetallesServicioModel findById(Integer id);

    DetallesServicioModel findByCedula(String cedula);

    DetallesServicioModel findByDate(Date fecha);

    List<DetallesServicioModel> findAll();
}
