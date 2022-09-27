package com.bubble_dog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubble_dog.Models.DetallesServicioModel;
import com.bubble_dog.Services.DetallesServicioService;
import com.bubble_dog.exception.RespuestaEstado;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/detalleServicio")
public class DetallesServicioController {
    
    @Autowired(required = true)
    DetallesServicioService detallesServicioService;

    @GetMapping(value="path")
    @CrossOrigin("*")
    public ResponseEntity<List<DetallesServicioModel>> findAll() {
        return new ResponseEntity<>(detallesServicioService.findAll(), HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public RespuestaEstado findById(@PathVariable("id") Integer idCliente) {
        DetallesServicioModel detallesServicioModel = detallesServicioService.findById(idCliente);
        if(detallesServicioModel == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }

        return RespuestaEstado.PROCESO_EXITOSO;
    }
}
