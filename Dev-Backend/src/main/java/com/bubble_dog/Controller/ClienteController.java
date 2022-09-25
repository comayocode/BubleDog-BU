package com.bubble_dog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bubble_dog.Models.ClienteModel;
import com.bubble_dog.Services.ClienteService;
import com.bubble_dog.exception.RespuestaEstado;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll() throws Exception {

        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public RespuestaEstado create(@RequestBody ClienteModel clienteModel) {
        ClienteModel clientes = clienteService.update(clienteModel);
        if(!(clientes == null)) {
            return RespuestaEstado.ERROR_DE_PETICION;
        }

        return RespuestaEstado.CLIENTE_CREADO_CON_EXITO;
    }

    @PutMapping
    public RespuestaEstado update(@RequestBody ClienteModel clienteModel) {
        ClienteModel clientes = clienteService.update(clienteModel);
        if(clientes == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }
        clienteService.update(clienteModel);
        return RespuestaEstado.CLIENTE_ACTUALIZADO_CON_EXITO;
    }

    @GetMapping("/{id}")
    public RespuestaEstado findById(@PathVariable("id") Integer idCliente) {
        ClienteModel clienteModel = clienteService.findById(idCliente);
        if(clienteModel == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }

        return RespuestaEstado.PROCESO_EXITOSO;
    }

    @DeleteMapping("/{id}")
    public RespuestaEstado delete(@PathVariable("id") Integer id) throws Exception {
        ClienteModel clienteModel = clienteService.findById(id);
        if(clienteModel == null) {
            return RespuestaEstado.NO_EXISTE_EL_ID;
        }

        return RespuestaEstado.DELETED;
    }
}
