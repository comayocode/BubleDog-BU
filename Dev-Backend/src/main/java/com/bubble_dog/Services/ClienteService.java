package com.bubble_dog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubble_dog.Models.ClienteModel;
import com.bubble_dog.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements  IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteModel create(ClienteModel clienteModel) {

        return clienteRepository.save(clienteModel);
    }

    @Override
    public ClienteModel update(ClienteModel clienteModel) {

        return clienteRepository.save(clienteModel);

    }

    @Override
    public ClienteModel findById(Integer id)  {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }

    @Override
    public List<ClienteModel> findAll() {

        return clienteRepository.findAll();
    }


    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
