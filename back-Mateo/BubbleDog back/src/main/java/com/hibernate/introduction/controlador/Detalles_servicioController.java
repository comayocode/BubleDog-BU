package com.hibernate.introduction.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.modelo.detalles_servicio;
import com.hibernate.introduction.servicios.Detalles_servicioService;

@RestController
@RequestMapping("/detalles_servicio")


public class Detalles_servicioController {
    
    private Detalles_servicioService service; 

    // CONSTRUCTOR
    public Detalles_servicioController() {
        service = new Detalles_servicioService();
    }


    //metodos

    //crear registro
    @PostMapping
    public String create(@RequestBody detalles_servicio registro) {
        return service.create(registro);
    }

    //consultar registros
    @GetMapping
    public List<detalles_servicio> getDetalles_servicio() {
        return service.getDetalles_servicio();
    }

    //consultar registros x cedula
    @GetMapping("/{cedula}")
    public List<detalles_servicio> getDetallesXCedula(@PathVariable(name = "cedula") String cedula) {
        return service.getDetallesXCedula(cedula);
    }

    //actualizar registro
    @PutMapping
    public String updateDetalles(@RequestBody detalles_servicio registro){
        return service.updateDetalles(registro);
    }


    //eliminar registro
    @DeleteMapping("/delete/{id_detalles_servicio}")
    public String deleteDetalles(@PathVariable(name = "id_detalles_servicio") int id) {
        return service.deleteDetalles(id);
    }
}
