package com.bubble_dog.Services;

import java.util.List;
import com.bubble_dog.Models.ClienteModel;

public interface IClienteService {

    ClienteModel create(ClienteModel clienteModel);

    ClienteModel update(ClienteModel clienteModel);

    ClienteModel findById(Integer id);

    List<ClienteModel> findAll();

    void delete(Integer id);


}
