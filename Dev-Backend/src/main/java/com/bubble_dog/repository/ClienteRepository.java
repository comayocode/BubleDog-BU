package com.bubble_dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bubble_dog.Models.ClienteModel;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
