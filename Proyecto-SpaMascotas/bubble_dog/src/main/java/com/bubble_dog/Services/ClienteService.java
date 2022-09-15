package com.bubble_dog.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bubble_dog.Models.ClienteModel;

public class ClienteService {
    
    /*ATRIBUTOS */
    private SessionFactory factory;

    //Contructores
    public ClienteService() {
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(ClienteModel.class)
        .buildSessionFactory();
    }
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();

        return session;
    }

    //Agregar clientes
    public String create(ClienteModel cliente){

        String message = "";
        Session session = openSession();

        try {
            session.persist(cliente);
            session.getTransaction().commit();

            message = "Clienete creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        session.close();
        return message;

    }
}
