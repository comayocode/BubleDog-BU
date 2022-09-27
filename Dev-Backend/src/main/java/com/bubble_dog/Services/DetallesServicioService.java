package com.bubble_dog.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bubble_dog.Models.DetallesServicioModel;
import com.bubble_dog.repository.DetallesServicioRepository;


@Service
public class DetallesServicioService implements IDetallesServicioService{

    @Autowired
    DetallesServicioRepository detallesServicio;

    @Override
    public DetallesServicioModel findById(Integer id) {
        Optional<DetallesServicioModel> detalleOptional = detallesServicio.findById(id);
        return detalleOptional.orElse(null);
    }

    @Override
    public DetallesServicioModel findByCedula(String cedula) {
        
        return null;
    }

    @Override
    public DetallesServicioModel findByDate(Date fecha) {
        
        return null;
    }

    @Override
    public List<DetallesServicioModel> findAll() {
        
        return detallesServicio.findAll();
    }
    
}
