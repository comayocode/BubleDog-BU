package com.bubble_dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bubble_dog.Models.DetallesServicioModel;

@Repository
public interface DetallesServicioRepository extends JpaRepository<DetallesServicioModel, Integer> {
    
}
