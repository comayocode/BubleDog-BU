package com.bubble_dog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bubble_dog.Models.ServicioModel;
import com.bubble_dog.repository.ServicioRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements  IServicioService{
    @Autowired
    private ServicioRepository detalleServicioRepository;


    @Override
    public ServicioModel create(ServicioModel servicioModel) {
        return detalleServicioRepository.save(servicioModel);
    }

    @Override
    public ServicioModel findById(Integer id) {
        Optional<ServicioModel> detalleServicio = detalleServicioRepository.findById(id);
        System.out.println(detalleServicio.get());
        return detalleServicio.orElse(null);
    }

    @Override
    public ServicioModel findByDate(Date fecha) {

        return null;
    }

    @Override
    public List<ServicioModel> findAll() {
        return detalleServicioRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        detalleServicioRepository.deleteById(id);
    }
}