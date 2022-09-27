package com.bubble_dog.Services;

import java.util.Date;
import java.util.List;


import com.bubble_dog.Models.ServicioModel;

public interface IServicioService {

    ServicioModel create(ServicioModel servicioModel);
    
    ServicioModel update(ServicioModel servicioModel);

    ServicioModel findById(Integer id);

    ServicioModel findByDate(Date fecha);

    List<ServicioModel> findAll();

    void delete(Integer id);
}