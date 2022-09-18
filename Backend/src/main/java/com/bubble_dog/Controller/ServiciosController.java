package com.bubble_dog.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bubble_dog.Models.ServiciosModel;
import com.bubble_dog.Services.ServiciosService;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    
    private ServiciosService service;


    public ServiciosController() {
        service = new ServiciosService();
    }

    @GetMapping
    public List<ServiciosModel> getServicios(){
        return service.getServicios();
    }

    @PostMapping
    public String crearServicio(@RequestBody ServiciosModel servicio){
        return service.crearServicio(servicio);
    }

    @DeleteMapping
    public String borrarServicio(@RequestParam String id){
        return service.borrarServicios(id);
    }

    @GetMapping("/id")
    public ServiciosModel getServicioXId(@RequestParam String id){
        return service.servicioXId(id);
    }

    @PutMapping
    public String updateServicio(@RequestBody ServiciosModel servicio){
        return service.updateServicio(servicio);
    }
}
