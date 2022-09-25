package com.bubble_dog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bubble_dog.Models.ServicioModel;
import com.bubble_dog.Services.DetalleServicioService;
import com.bubble_dog.exception.RespuestaEstado;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private DetalleServicioService detalleServicioService;

    @GetMapping
    public ResponseEntity<List<ServicioModel>> findAll() throws  Exception{
        return new ResponseEntity<>(detalleServicioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RespuestaEstado findById(@PathVariable("id") Integer id_servicio) throws Exception {
        ServicioModel detalleServicio = detalleServicioService.findById(id_servicio);
        if(detalleServicio == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }

        return RespuestaEstado.PROCESO_EXITOSO;
    }

    @PostMapping
    public  RespuestaEstado create(@RequestBody ServicioModel servicio) throws  Exception {
        ServicioModel servicioModel = detalleServicioService.create(servicio);
        if(servicioModel == null) {
            return RespuestaEstado.ERROR_DE_PETICION;
        }

        return RespuestaEstado.PROCESO_EXITOSO;
    }

    @DeleteMapping("/{id}")
    public RespuestaEstado delete(@PathVariable("id") Integer id) throws Exception {
        ServicioModel servicioModel = detalleServicioService.findById(id);
        if(servicioModel == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }

        return RespuestaEstado.DELETED;
    }
}